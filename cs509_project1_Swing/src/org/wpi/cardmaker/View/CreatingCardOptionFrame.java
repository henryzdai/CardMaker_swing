package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Model.Card;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.*;

public class CreatingCardOptionFrame extends JFrame{
    public Card card = new Card();

    public CreatingCardOptionFrame() {
        /*getContentPane().setBackground(Color.DARK_GRAY);*/

    }

    public void createUI(){
        setTitle("Input Dialog in Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(400, 300);
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
    }

    public void RecipientNameInputDialog(Card card){
        JFrame frame = new JFrame("Creating card");
        Object recipientName = JOptionPane.showInputDialog(frame, "Input the name of the recipient", "Jane Doe");
        if(recipientName instanceof String)
        {
            card.setRecipient((String)recipientName);
            showMainWindow();
        }
    }

    public void showMainWindow(){
        new mainwindow().createUI(this.card);
    }



    public static void main(String args[]) {
        new CreatingCardOptionFrame().CardNameInputDialog();
    }

}