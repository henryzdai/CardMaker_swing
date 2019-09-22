package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.CreatingCardController;
import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Controller.VisualElementController;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MakerWindow {
    public JFrame frame;
    private JButton addVisualElementButton;
    private JButton deleteVisualElementButton;
    private JButton copyVisualElementButton;
    private JButton pasteVisualElementButton;
    private JButton saveButton;
    private JButton editVisualElementButton;
    private JButton nextPageButton;
    private JPanel Pages;
    private JPanel FrontPage;
    private JPanel BackPage;
    private JPanel LeftPage;
    private JPanel RightPage;
    private JLabel backText;
    private JLabel backImage;
    private JLabel frontImage;
    private JLabel frontText;
    private JButton buttonOK;
    private JButton buttonCancel;
    public JPanel pagePanel;

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

        // Controller
        visualElementController = new VisualElementController(card);

    }

    public void createAndShowUI(){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        JFrame frame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType+"--"+ card.getFrontPage().getName());
        frame.setSize(1200,700);
        frame.setResizable(false);
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



        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();


        frame.setLayout(new BorderLayout());

        /*BoxLayout boxlayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxlayout);*/
        frame.add(menuPanel,BorderLayout.NORTH);


        Border blackline, redLine;
        redLine = BorderFactory.createLineBorder(Color.red);
        blackline = BorderFactory.createLineBorder(Color.black);
        JPanel elementPanel = new JPanel();
        elementPanel.setPreferredSize(new Dimension(900,600));
        //elementPanel.setBounds(100,50,900,600);
        elementPanel.setBorder(blackline);
        //creatingCardController.setOrientation(card, frontPanel);
        JPanel pagePanel = new JPanel();
        pagePanel.setPreferredSize(new Dimension(900,600));
        //pagePanel.setBounds(0,0,900,600);
        pagePanel.setBorder(redLine);
        JPanel imagePanel = new JPanel();
        JPanel textPanel = new JPanel();
        elementPanel.add(pagePanel);
        imagePanel.setPreferredSize(new Dimension(300,300));
        textPanel.setPreferredSize(new Dimension(400,400));
        pagePanel.setLayout(new FlowLayout());
        pagePanel.add(imagePanel);
        pagePanel.add(textPanel);

        frontText = new JLabel("Test Text");
        frontImage = new JLabel("Test Image");

        card.getFrontPage().setImageLabel(frontImage);
        card.getFrontPage().setTextLabel(frontText);
        card.getBackPage().setImageLabel(backImage);
        card.getBackPage().setTextLabel(backText);

        frontText.addMouseListener(myMouseAdapter);
        frontText.addMouseMotionListener(myMouseAdapter);
        frontImage.addMouseListener(myMouseAdapter);
        frontImage.addMouseMotionListener(myMouseAdapter);

        imagePanel.add(frontImage);
        textPanel.add(frontText);
        frame.add(elementPanel,BorderLayout.CENTER);







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
        Card card = new Card();
        card.setOrientation("landscape");
        new MakerWindow(card).createAndShowUI();
    }
}

class MyMouseAdapter extends MouseAdapter {

    private Point initialLoc;
    private Point initialLocOnScreen;

    @Override
    public void mousePressed(MouseEvent e) {
        Component comp = (Component)e.getSource();
        initialLoc = comp.getLocation();
        initialLocOnScreen = e.getLocationOnScreen();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Component comp = (Component)e.getSource();
        Point locOnScreen = e.getLocationOnScreen();

        int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
        int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
        comp.setLocation(x, y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Component comp = (Component)e.getSource();
        Point locOnScreen = e.getLocationOnScreen();

        int x = locOnScreen.x - initialLocOnScreen.x + initialLoc.x;
        int y = locOnScreen.y - initialLocOnScreen.y + initialLoc.y;
        comp.setLocation(x, y);
    }
}