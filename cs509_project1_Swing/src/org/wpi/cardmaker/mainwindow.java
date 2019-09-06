package org.wpi.cardmaker;

import sun.jvm.hotspot.HelloWorld;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainwindow {
    private JPanel panel1;
    private JButton startButton;
    private JButton createCardButton;
    private JButton resetButton;
    private JButton loadCardButton;
    private JButton deleteCardButton;

    public mainwindow() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, world!");
            }
        });
        createCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello, world!");
            }
        });

    }


    // main function
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Maker");
        frame.setContentPane(new mainwindow().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,700);
        frame.pack();
        frame.setVisible(true);

    }
}
