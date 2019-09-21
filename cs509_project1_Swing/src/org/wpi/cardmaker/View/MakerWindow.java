package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.CreatingCardController;
import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Controller.VisualElementController;
import org.wpi.cardmaker.Model.Card;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakerWindow {
    public JFrame frame;
    private JButton addVisualElementButton;
    private JButton deleteVisualElementButton;
    private JButton copyVisualElementButton;
    private JButton pasteVisualElementButton;
    private JButton saveButton;
    private JButton editVisualElementButton;
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
    private JLabel FrontText;
    private JButton buttonOK;
    private JButton buttonCancel;

    //Controller
    public VisualElementController visualElementController;
    public CreatingCardController creatingCardController;

    // Card
    public Card card;

    public MakerWindow(Card card){
        this.card = card;
        creatingCardController = new CreatingCardController();
        // Initialize
        this.card = card;
        card.getFrontPage().setImageLabel(FrontImage);
        card.getFrontPage().setTextLabel(FrontText);
        card.getBackPage().setImageLabel(BackImage);
        card.getBackPage().setTextLabel(BackPageText);

        // Controller
        visualElementController = new VisualElementController(card);

    }

    public void createAndShowUI(){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        JFrame frame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType);
        creatingCardController.setOrientation(card, frame);

        JPanel menuPanel = new JPanel();
        addVisualElementButton = new JButton("Add Element");
        deleteVisualElementButton = new JButton("Delete Element");
        copyVisualElementButton = new JButton("Copy Element");
        pasteVisualElementButton = new JButton("Paste Element");
        editVisualElementButton = new JButton("Edit Element");
        saveButton = new JButton("Save Card");

        addVisualElementButton.addActionListener(new AddVisualElementActionListener());
        deleteVisualElementButton.addActionListener(new DelVisualElementActionListener());
        copyVisualElementButton.addActionListener(new CopyVisualElementActionListener());
        pasteVisualElementButton.addActionListener(new PasteVisualElementActionListener());
        saveButton.addActionListener(new SaveCard());

        menuPanel.add(addVisualElementButton);
        menuPanel.add(new JSeparator(SwingConstants.VERTICAL));
        menuPanel.add(deleteVisualElementButton);
        menuPanel.add(new JSeparator(SwingConstants.VERTICAL));
        menuPanel.add(copyVisualElementButton);
        menuPanel.add(new JSeparator(SwingConstants.VERTICAL));
        menuPanel.add(pasteVisualElementButton);
        menuPanel.add(new JSeparator(SwingConstants.VERTICAL));
        menuPanel.add(editVisualElementButton);
        menuPanel.add(new JSeparator(SwingConstants.VERTICAL));
        menuPanel.add(saveButton);

        frame.add(menuPanel);

        JPanel frontPanel = new JPanel();
        



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150,50);
        frame.setVisible(true);
    }

    // Button's Listener method
    private class AddVisualElementActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Add");
        }
    }

    private class DelVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Delete");
        }
    }
    private class CopyVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Copy");
        }
    }
    private class PasteVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChoosePage("Paste");
        }
    }

    public class SaveCard implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SerializationController().ObjectWriter(card);
        }
    }


    public static void main(String[] args) {
        new MakerWindow(new Card()).createAndShowUI();
    }
}
