package org.wpi.cardmaker;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.*;


public class SwingTestCase extends JFrame {

    private JLabel[] jLabelArr;
    private JPanel jLabelPanel = new JPanel();

    public SwingTestCase() {
        setLayout(new FlowLayout());
        jLabelArr = new JLabel[10];
        for (int i = 0; i < 10; i++) {

            jLabelArr[i] = new JLabel(new ImageIcon("/Users/henry/Workspace/git/java/project1/cs509_project1_Swing/src/resources/backimage.jpg"));
            jLabelPanel.add(jLabelArr[i]);

            jLabelArr[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    onMouseClicked(e);
                }
            });
        }
        add(jLabelPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(400, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void onMouseClicked(MouseEvent e) {
        for (int i = 0; i < 10; i++)
            if (e.getSource() == jLabelArr[i]) {
                System.out.println("Label" + i + "was clicked");
            }
    }

    public static void main(String[] args) {
        new SwingTestCase();
    }
}