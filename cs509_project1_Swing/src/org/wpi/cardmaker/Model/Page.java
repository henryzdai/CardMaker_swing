package org.wpi.cardmaker.Model;

import javax.swing.*;
import java.awt.*;

public class Page {
    public String text;
    public String name;
    public java.awt.Image image;
    public String textType;
    public int textSize;
    public JLabel textLabel;
    public JLabel imageLabel;

    public Page() {
        this.text = "Default Text";
        this.name = "Page1";
        this.text = " ";
    }

    public Page(String text, String name, Image image, String textType) {
        this.text = text;
        this.name = name;
        this.image = image;
        this.textType = textType;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Page(String name){
        this.name = name;
    }


}
