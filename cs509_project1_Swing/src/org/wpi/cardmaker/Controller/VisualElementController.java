package org.wpi.cardmaker.Controller;
import org.wpi.cardmaker.*;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;
import org.wpi.cardmaker.View.ImageEditor;
import org.wpi.cardmaker.View.TextEditor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class VisualElementController {
    public Card card;
    public JPanel contentPane;
    public Page page;
    public JFrame frame__;
    public SerializationController serializationController;


    public VisualElementController(Card card){
        this.card = card;
        serializationController = new SerializationController();
    }


    public void ChoosePage(String command){
        String[] choices = { "Front Page"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "Which page to add?", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                choices, // Array of choices
                choices[0]); // Initial choice
            if (input == "Front Page") {
                page = card.getFrontPage();
                ChooseVisualElementType(page, command);
            }

    }

    public void ChooseVisualElementType(Page page, String command){
        String[] choices = { "Image", "Text"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "Which type to add?", JOptionPane.QUESTION_MESSAGE, null, // Use
                choices, // Array of choices
                choices[0]); // Initial choice
        if(input == "Image"){
            if(command == "Add") {
                addImage(page.getImageLabel(), "1", page);
            }
            if(command == "Delete") {
                page.getImageLabel().setIcon(null);
            }
            if(command == "Copy") {
                CopyImage(page);
            }
            if(command == "Paste") {
                PasteImage(page);
            }
        }
        if(input == "Text"){
            if(command == "Add") {
                showTextEditor();
            }
            if(command == "Delete") {
                page.getTextLabel().setText(" ");
            }
            if(command == "Copy") {
                CopyText(page);
            }
            if(command == "Paste") {
                PasteText(page);
            }
        }
        System.out.println(input);
    }

    public void showTextEditor(){
        TextEditor tx = new TextEditor(page);
        tx.createAndShowGUI();
    }

    public void showImageEditor(){
        ImageEditor ix = new ImageEditor(page);
        ix.createAndShowUI();
    }



    public void addText(JLabel label, String text){
       label.setText(text);
    }

    public void addImage(JLabel label, String id, Page page){
        String filename = "./cs509_project1_Swing/src/resources/"+id+".jpg";
        Image image;
        try
        {
            image = ImageIO.read(new File(filename));
            ImageIcon imageIcon = new ImageIcon(image);
            label.setIcon(imageIcon);
            page.setImagePath(filename);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void displayImage(JLabel label, String name){
        String filename = name;
        Image image;
        try
        {
            image = ImageIO.read(new File(filename));
            ImageIcon imageIcon = new ImageIcon(image);
            label.setIcon(imageIcon);
            //page.setImagePath(filename);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void CopyText(Page page){
        String textToCopy = page.getTextLabel().getText();
        StringSelection stringSelection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public void CopyImage(Page page){
        Page copy_object = new Page();
        copy_object.setName("copy_object");
        copy_object.setImagePath(page.getImagePath());
        serializationController.ObjectCopyWriter(copy_object);
    }

    public void PasteImage(Page page){
        Page copy_object = serializationController.CopyObjectReadAndCreator("copy_object");
        page.setImagePath(copy_object.getImagePath());
        String filename = page.getImagePath();
        Image image;
        try
        {
            image = ImageIO.read(new File(filename));
            ImageIcon imageIcon = new ImageIcon(image);
            page.getImageLabel().setIcon(imageIcon);
            page.setImagePath(filename);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void PasteText(Page page){
        String textToCopy = "";
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        //StringSelection stringSelection = new StringSelection(textToCopy);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        if(clipboard.isDataFlavorAvailable(dataFlavor)) {
            try {
                textToCopy = (String)clipboard.getData(dataFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(textToCopy);
        //page.getTextLabel().setFont();
        page.getTextLabel().setText(textToCopy);
        //clipboard.setContents(stringSelection, null);
    }


}
