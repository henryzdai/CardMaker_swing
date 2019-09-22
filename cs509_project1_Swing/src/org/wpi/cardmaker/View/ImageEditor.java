package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.LoadCardController;
import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Controller.VisualElementController;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;
import org.wpi.cardmaker.SwingTestCase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class ImageEditor {
    public JFrame frame__;
    public JScrollPane cardList__;
    public JButton loadBbutton;
    public JButton deleteButton;
    public JButton updateButton;
    public JButton duplicateButton;
    public JList cardList;
    public String currentFile;
    public String[] fileList;



    public ImageEditor(Page page){

    }

    public void createAndShowUI(){
        frame__ = new JFrame("Card List");
        //cardList__ = new JScrollPane();
        loadBbutton = new JButton("Display");
       /* loadBbutton.addActionListener(new LoadList.AddButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new LoadList.DeleteButtonListener());
        updateButton = new JButton("Update");
        updateButton.addActionListener(new LoadList.UpdateButtonListener());
        duplicateButton = new JButton("Duplicate");
        duplicateButton.addActionListener(new LoadList.DuplicateButtonListener())*/;

        JPanel panel1 = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        panel1.add(loadBbutton);

        fileList = ReadImageDirectory();
        JList<String> jlist = new JList<>(fileList);
        jlist.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent le) {
                int idx = jlist.getSelectedIndex();
                if (idx != -1)
                    System.out.println("Current selection: " + fileList[idx]);
                currentFile = fileList[idx];
            }
        });

        frame__.add(panel1, BorderLayout.NORTH);
        frame__.add(jlist, BorderLayout.CENTER);

        frame__.setSize(900,600);
        frame__.setLocation(150,80);
        frame__.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame__.setVisible(true);
        jlist.requestFocusInWindow();
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Card card__ = new SerializationController().ObjectReadAndCreator(currentFile);
            new MakerWindow(card__).createAndShowUI();
        }
    }

    public String[] ReadImageDirectory(){
        File folder = new File("./objects/cs509_project1_Swing/src/resources");
        File[] listOfFiles = folder.listFiles();
        String[] names = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("File " + listOfFiles[i].getName());
            names[i] = listOfFiles[i].getName();
        }
        return names;
    }
    public static void main(String[] args) {
        new ImageEditor(new Page()).createAndShowUI();
    }
}
