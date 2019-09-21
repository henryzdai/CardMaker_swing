package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.LoadCardController;

import javax.swing.*;
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

    public LoadCardController loadCardController;

    public LoadList(){
        loadCardController = new LoadCardController();

    }


    public void createAndShowUI(){
        frame__ = new JFrame("Card List");
        cardList__ = new JScrollPane();
        loadBbutton = new JButton("Load");
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


        frame__.add(panel1, BorderLayout.NORTH);
        frame__.add(cardList__, BorderLayout.CENTER);

        frame__.setSize(900,600);
        frame__.setLocation(150,80);
        frame__.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame__.setVisible(true);

        cardList__.requestFocusInWindow();
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadCardController.AddCardController();
        }
    }

    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadCardController.DeleteCardController();
        }
    }

    private class UpdateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadCardController.UpdateController();
        }
    }

    private class DuplicateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadCardController.DupicateCardController();
        }
    }


    public static void main(String[] args) {
        new LoadList().createAndShowUI();
    }
}
