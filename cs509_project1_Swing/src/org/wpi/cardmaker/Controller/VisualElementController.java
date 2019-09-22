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



    public VisualElementController(Card card){
        this.card = card;
    }

    public void ChoosePage(String command){
        String[] choices = { "Front Page", "Back Page"};
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
            if (input == "Back Page") {
                page = card.getBackPage();
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
                addImage(page.getImageLabel(), "1");
            }
            if(command == "Delete") {
                page.getImageLabel().setIcon(null);
            }
            if(command == "Copy") {

            }
            if(command == "Paste") {

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

    public void addImage(Page page, JFrame frame, JLabel label){
        File pictureFile = choosePictureFile(frame);

        if (pictureFile == null) {
            frame.requestFocusInWindow();
            return;
        }

        ImageIcon icon = new ImageIcon(pictureFile.toString());
        JButton picButton = new JButton(icon);
        picButton.setBorder(new LineBorder(Color.WHITE));
        picButton.setMargin(new Insets(0,0,0,0));
        picButton.setAlignmentY(.9f);
        picButton.setAlignmentX(.9f);

        page.getImageLabel().setIcon(icon);
        //picButton.addFocusListener(new SwingTestCase.PictureFocusListener());
        picButton.setName("PICTURE_ID_" + new Random().nextInt());
        //frame.insertComponent(picButton);
        frame.requestFocusInWindow();
    }

    public File choosePictureFile(JFrame frame) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "PNG, JPG & GIF Images", "png", "jpg", "gif");
        chooser.setFileFilter(filter);
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        else {
            return null;
        }
    }
    public void addText(JLabel label, String text){
       label.setText(text);
    }

    public void addImage(JLabel label, String id){
        //Image immage= "resources/backimage.jpg";
        String filename = "./cs509_project1_Swing/src/resources/"+id+".jpg";
        Image image;
        try
        {
            image = ImageIO.read(new File(filename));
            ImageIcon imageIcon = new ImageIcon(image);
            label.setIcon(imageIcon);
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

    public void CopyImage(){

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
