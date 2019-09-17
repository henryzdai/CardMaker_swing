package org.wpi.cardmaker.Controller;
import org.wpi.cardmaker.*;
import org.wpi.cardmaker.Model.Card;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class VisualElementController {
    public Card card;
    public JPanel contentPane;



    public VisualElementController(){

    }
    public void ChooseVisualElementType(JPanel JFrame){

        String[] choices = { "Image", "Text"};
        String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
                "The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null, // Use
                // default
                // icon
                choices, // Array of choices
                choices[1]); // Initial choice
        if(input == "Image"){

        }
        if(input == "Text"){

        }
        System.out.println(input);
    }

    public void addImage(JLabel label){
        //Image immage= "resources/backimage.jpg";
        ImageIcon imageicon = new ImageIcon("/Users/henry/Workspace/git/java/project1/cs509_project1_Swing/src/resources/backimage.jpg");
        label.setIcon(imageicon);
    }

    public void addText(JLabel label, String text){
        //Image immage= "resources/backimage.jpg";
        label.setText(text);
    }

    /*private class PictureInsertActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            File pictureFile = choosePictureFile();

            if (pictureFile == null) {

                editor__.requestFocusInWindow();
                return;
            }

            ImageIcon icon = new ImageIcon(pictureFile.toString());
            JButton picButton = new JButton(icon);
            picButton.setBorder(new LineBorder(Color.WHITE));
            picButton.setMargin(new Insets(0,0,0,0));
            picButton.setAlignmentY(.9f);
            picButton.setAlignmentX(.9f);
            picButton.addFocusListener(new SwingTestCase.PictureFocusListener());
            picButton.setName("PICTURE_ID_" + new Random().nextInt());
            editor__.insertComponent(picButton);
            editor__.requestFocusInWindow();
        }

        private File choosePictureFile() {

            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    "PNG, JPG & GIF Images", "png", "jpg", "gif");
            chooser.setFileFilter(filter);

            if (chooser.showOpenDialog(frame__) == JFileChooser.APPROVE_OPTION) {

                return chooser.getSelectedFile();
            }
            else {
                return null;
            }
        }
    } // PictureInsertActionListener*/
}
