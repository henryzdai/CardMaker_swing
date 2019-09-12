package org.wpi.cardmaker.View;

import org.wpi.cardmaker.SwingTestCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainwindow extends JDialog {
    private JPanel contentPane;
    private JPanel ButtonPanel;
    private JScrollPane CardPanel;
    private JButton addVisualElementButton;
    private JButton deleteVisualElementButton;
    private JButton copyVisualElementButton;
    private JButton pasteVisualElementButton;
    private JButton saveButton;
    private JButton button6;
    private JPanel Pages;
    private JPanel FrontPage;
    private JPanel BackPage;
    private JPanel LeftPage;
    private JPanel RightPage;
    private JLabel BackPageText;
    private JLabel BackImage;
    private JLabel FrontImage;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel FrontTextLabel;
    private JButton buttonOK;
    private JButton buttonCancel;

    public mainwindow() {
        setContentPane(contentPane);
        setModal(true);

        //image test
        //ImageIcon image = new ImageIcon("resources/frontimage.jpg");
        //FrontImage.setIcon(image);
        //contentPane.add(FrontImage);

        HighlightMouseListener hml = new HighlightMouseListener();
        FrontPage.addMouseListener(hml);
        FrontImage.addMouseListener(hml);
        BackImage.addMouseListener(hml);
        BackPage.addMouseListener(hml);
        BackPageText.setText("Test text");

        addVisualElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addImage(FrontImage);
            }
        });
    }


    public class HighlightMouseListener extends MouseAdapter {
        private JLabel previous;

        @Override
        public void mouseClicked(MouseEvent e) {
            Component source = e.getComponent();
            if (!(source instanceof JLabel)) {
                return;
            }
            JLabel label = (JLabel) source;
            if (previous != null) {
                previous.setBackground(null);
                previous.setForeground(null);
                previous.setOpaque(false);
                previous.setText("null");
            }
            previous = label;
            label.setForeground(Color.WHITE);
            label.setBackground(Color.BLUE);
            label.setOpaque(true);
            label.setText("Clicked");
        }

    }

    public void addImage(JLabel label){
        //Image immage= "resources/backimage.jpg";
        ImageIcon imageicon = new ImageIcon("/Users/henry/Workspace/git/java/project1/cs509_project1_Swing/src/resources/backimage.jpg");
        label.setIcon(imageicon);
    }

    public void addText(JLabel label){
        label.setText("Test");
    }


    public void addOption(){
        String[] choices = { "Image", "Text"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                choices, // Array of choices
                choices[1]); // Initial choice
        System.out.println(input);
    }

    // main function
    public static void main(String[] args) {
        JFrame frame = new JFrame("Card Maker");
        frame.setContentPane(new mainwindow().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800,700);
        frame.pack();
        frame.setVisible(true);

    }
}
