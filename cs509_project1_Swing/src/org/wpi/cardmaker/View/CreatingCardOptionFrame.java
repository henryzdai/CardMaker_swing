package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Model.Card;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

public class CreatingCardOptionFrame extends JFrame{
    public Card newCard = new Card();

    public CreatingCardOptionFrame() {
        /*getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Input Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
        getContentPane().setLayout(null);*/
    }


    // in put card name
    public void CardNameInputDialog(){
        Card card = new Card();

        JFrame frame = new JFrame("Creating card");
        Object cardName = JOptionPane.showInputDialog(frame, "Input a card name", "card1");
        if(cardName instanceof String)
        {
            card.setName((String)cardName);
            System.out.println((String)cardName);
            SelectEventTypeDialog(card);
        }
    }


    //SelectEventTypeDialog
    public void SelectEventTypeDialog(Card card) {
        JFrame frame = new JFrame("Creating card");
        // prompt the user to enter their name
        //String name = JOptionPane.showInputDialog(frame, "Name of the card?");
        Object cardType = JOptionPane.showInputDialog(new JFrame(),
                "What is your card's event type?",
                "Event Type",
                JOptionPane.QUESTION_MESSAGE,
                null,
                card.getEventOption(),
                card.getEventOption()[0]);
        if (cardType instanceof String)
        {
            card.setEventType((String)cardType);
            RecipientNameInputDialog(card);
        }
        // get the user's input. note that if they press Cancel, 'name' will be null
        /*if ((int)cardType == JOptionPane.YES_OPTION) {
            System.out.println("Yes");
        } else if ((int)cardType == JOptionPane.NO_OPTION) {
            System.out.println("No");
        } else if ((int)cardType == JOptionPane.CLOSED_OPTION) {
            System.out.println("Closed by hitting the cross");
        }*/
    }

    public void RecipientNameInputDialog(Card card){
        JFrame frame = new JFrame("Creating card");
        Object recipientName = JOptionPane.showInputDialog(frame, "Input the name of the recipient", "Jane Doe");
        if(recipientName instanceof String)
        {
            card.setRecipient((String)recipientName);
            showMainWindow(card);
        }
    }

    public void showMainWindow(Card card){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        JFrame frame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType);
        frame.setContentPane(new org.wpi.cardmaker.View.mainwindow().getContentPane());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800,700);
        frame.pack();
        frame.setVisible(true);
    }



    public static void main(String args[]) {
        new CreatingCardOptionFrame().CardNameInputDialog();
    }

}