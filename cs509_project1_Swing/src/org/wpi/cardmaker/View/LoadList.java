package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.CreatingCardController;
import org.wpi.cardmaker.Controller.LoadCardController;
import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Model.Card;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class LoadList {
    public JFrame frame__;
    public JScrollPane cardList__;
    public JButton loadBbutton;
    public JButton deleteButton;
    public JButton updateButton;
    public JButton duplicateButton;
    public JList cardList;
    public String currentFile;
    public String[] fileList;

    public LoadCardController loadCardController;

    public LoadList(){
        loadCardController = new LoadCardController();
    }


    public void createAndShowUI(){
        frame__ = new JFrame("Card List");
        //cardList__ = new JScrollPane();
        loadBbutton = new JButton("Display");
        loadBbutton.addActionListener(new AddButtonListener());
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        updateButton = new JButton("Update");
        updateButton.addActionListener(new UpdateButtonListener());
        duplicateButton = new JButton("Duplicate");
        duplicateButton.addActionListener(new DuplicateButtonListener());

        JPanel panel1 = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        panel1.add(loadBbutton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(deleteButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(updateButton);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(duplicateButton);

        fileList = loadCardController.ReadDirectory();
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

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadCardController.DeleteCardController(currentFile);
            frame__.dispose();
            new LoadList().createAndShowUI();
        }
    }

    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Card card__ = new SerializationController().ObjectReadAndCreator(currentFile);
            new CreateCard(card__).createAndShowUI();
        }
    }

    private class DuplicateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Card card__ = new SerializationController().ObjectReadAndCreator(currentFile);
            card__.setName("Duplicated_"+card__.getName());
            new SerializationController().ObjectWriter(card__);
            frame__.dispose();
            new LoadList().createAndShowUI();
        }
    }


    public static void main(String[] args) {
        new LoadList().createAndShowUI();
    }
}
