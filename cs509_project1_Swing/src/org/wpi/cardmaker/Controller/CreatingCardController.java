package org.wpi.cardmaker.Controller;

import org.wpi.cardmaker.Model.Card;

import javax.swing.*;
import java.awt.*;

public class CreatingCardController {
    Card card;
    public SerializationController serializationController;

    public CreatingCardController(){
        serializationController = new SerializationController();
    }


    public void setProperties(Card card, String name, String eventType, String recipient, String orientation){
        card.setName(name);
        card.setRecipient(recipient);
        card.setEventType(eventType);
        card.setOrientation(orientation);
        if(eventType == card.eventOption[1]){
            card.getLeftPage().setText(card.defaultText[1]);
        }
        if(eventType == card.eventOption[2]){
            card.getLeftPage().setText(card.defaultText[2]);
        }
        if(eventType == card.eventOption[3]){
            card.getLeftPage().setText(card.defaultText[3]);
        }
        if(eventType == card.eventOption[4]){
            card.getLeftPage().setText(card.defaultText[4]);
        }
        if(eventType == card.eventOption[5]){
            card.getLeftPage().setText(card.defaultText[5]);
        }
        System.out.println(card.getName()+card.getRecipient()+card.getOrientation()+card.getEventType());
        serializationController.ObjectWriter(card);
    }

    public void setOrientation(Card card, JPanel panel){
        String orientation = card.getOrientation();
        if(orientation == null){
            panel.setPreferredSize(new Dimension(900,600));
        }
        if(orientation == "default"){
            panel.setPreferredSize(new Dimension(900,600));
        }
        if(orientation == "landscape"){
            panel.setPreferredSize(new Dimension(900,600));
        }
        if(orientation == "portrait"){
            panel.setPreferredSize(new Dimension(600,900));
        }
    }

    public void setWindowName(Card card, JFrame frame){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        frame.setName(name+"-"+"A card for "+recipient+"'s "+eventType);
    }
}
