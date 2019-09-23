package org.wpi.cardmaker.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaterMenu extends JFrame {
    private JPanel contentPane;
    private JButton loadCardButton;
    private JButton CreateButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public StaterMenu() {
        setContentPane(contentPane);

        CreateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateCard().createAndShowUI();
            }
        });

        loadCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadList().createAndShowUI();
            }
        });
    }

    public void createAndShowUI(){
        JFrame frame = new JFrame("Card Maker");
        frame.setContentPane(new StaterMenu().getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.setLocation(500,500);
        frame.pack();
        frame.setVisible(true);
    }

    public void showCreatingOptionPane(){
        new CreatingCardOptionFrame().CardNameInputDialog();
    }



    // main function
    public static void main(String[] args) {
        new StaterMenu().createAndShowUI();
    }
}
