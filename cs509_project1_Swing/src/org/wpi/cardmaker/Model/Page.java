package org.wpi.cardmaker.Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Page implements Serializable {
    public String text;
    public String name;
    public String imagePath;
    public String textType;
    public int textSize;
    public JLabel textLabel;
    public JLabel imageLabel;
    public Font font;

    public Page(){
        this.name = "Page Name";
        this.text = " ";
        this.imagePath = "./cs509_project1_Swing/src/resources/5.jpg";
        //this.imageIcon = new ImageIcon(ImageIO.read(new File("./cs509_project1_Swing/src/resources/5.jpg")));
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public JLabel getTextLabel() {
        return textLabel;
    }

    public void setTextLabel(JLabel textLabel) {
        this.textLabel = textLabel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public void setImageLabel(JLabel imageLabel) {
        this.imageLabel = imageLabel;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Page(String name){
        this.name = name;
    }


}
