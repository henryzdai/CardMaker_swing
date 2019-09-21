package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Model.Page;
import org.wpi.cardmaker.SwingTestCase;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class ImageEditor {


    public ImageEditor(Page page){

    }

   /* private class PictureInsertActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            File pictureFile = choosePictureFile();

            if (pictureFile == null) {

                //editor__.requestFocusInWindow();
                return;
            }

            ImageIcon icon = new ImageIcon(pictureFile.toString());
            JButton picButton = new JButton(icon);
            picButton.setBorder(new LineBorder(Color.WHITE));
            picButton.setMargin(new Insets(0,0,0,0));
            picButton.setAlignmentY(.9f);
            picButton.setAlignmentX(.9f);
            //picButton.addFocusListener(new SwingTestCase.PictureFocusListener());
            picButton.setName("PICTURE_ID_" + new Random().nextInt());
            //editor__.insertComponent(picButton);
            //editor__.requestFocusInWindow();
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

    public void createAndShowUI(){

    }
}
