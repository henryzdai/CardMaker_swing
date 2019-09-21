package org.wpi.cardmaker.View;

import com.sun.tools.javac.comp.Flow;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.wpi.cardmaker.Controller.CreatingCardController;
import org.wpi.cardmaker.Model.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateCard {
    public JFrame frame;
    JTextField nameText;
    JTextField recipientText;

    String name;
    String recipient;
    String eventType;
    String orientation;


    public Card card;
    public CreatingCardController creatingCardController;




    public CreateCard(){
        card = new Card();
        creatingCardController = new CreatingCardController();
    }
    public CreateCard(Card card){
        this.card = card;
        creatingCardController = new CreatingCardController();

    }

    public void createAndShowUI(){
        frame = new JFrame("Creating a new Card");
        //JPanel panel = new JPanel();
        //frame.setContentPane(panel);
        frame.setSize(500,500);
        BoxLayout boxlayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxlayout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //name
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JLabel inputName = new JLabel("Input a card name:");
        nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(200,20));
        panel1.add(inputName);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(nameText);

        // Event Type
        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        JLabel eventMessage = new JLabel("Select an event type:");
        JComboBox eventType = new JComboBox(card.eventOption);
        eventType.addItemListener(new EventTypeChangeListener());
        panel2.add(eventMessage);
        panel2.add(new JSeparator(SwingConstants.VERTICAL));
        panel2.add(eventType);

        // Recipient
        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        JLabel inputRecipient = new JLabel("Input the recipient's name:");
        recipientText = new JTextField();
        recipientText.setPreferredSize(new Dimension(200,20));
        //recipient.setBounds(50,70,200,100);
        panel3.add(inputRecipient);
        panel3.add(new JSeparator(SwingConstants.VERTICAL));
        panel3.add(recipientText);

        // Orientation
        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JLabel inputOrientation = new JLabel("Select card's orientation:");
        JComboBox orientation = new JComboBox(card.orientationOption);
        orientation.addItemListener(new OrientationChangeListener());
        panel4.add(inputOrientation);
        panel4.add(new JSeparator(SwingConstants.VERTICAL));
        panel4.add(orientation);

        // Button
        JPanel panel5 = new JPanel();
        panel4.setLayout(new FlowLayout());
        JButton okButton = new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");
        okButton.addActionListener(new confirmButtonActionListener());
        cancelButton.addActionListener(new cancelButtonActionListener());
        panel5.add(okButton);
        panel4.add(new JSeparator(SwingConstants.VERTICAL));
        panel5.add(cancelButton);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);
        frame.setLocation(150,50);
        frame.setVisible(true);
    }

    // listener
    public class confirmButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            name = nameText.getText();
            recipient = recipientText.getText();
            creatingCardController.setProperties(card, name, eventType, recipient, orientation);
            new MakerWindow(card).createAndShowUI();
        }
    }



    public class cancelButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }
    }

    public class EventTypeChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Object item = event.getItem();
                eventType = (String)item;
            }
        }
    }
    public class OrientationChangeListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Object item = event.getItem();
                orientation = (String)item;
                System.out.println(orientation);
            }
        }
    }




    public static void main(String[] args) {
        new CreateCard().createAndShowUI();
    }

}
