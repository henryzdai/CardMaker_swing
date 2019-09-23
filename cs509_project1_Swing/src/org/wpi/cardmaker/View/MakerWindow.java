package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.CreatingCardController;
import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Controller.VisualElementController;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class MakerWindow {
    public JFrame frame;
    public JFrame BackFrame;
    public JFrame LeftFrame;
    public JFrame RightFrame;
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
    public JButton displayAllPagesButton;
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

    public void createAndShowUI(Page page){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        JFrame frame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType+"--"+ card.getFrontPage().getName());
        frame.setSize(1200,1200);
        frame.setResizable(false);
        JPanel menuPanel = new JPanel();

        displayAllPagesButton = new JButton("Display");
        addVisualElementButton = new JButton("Add Element");
        deleteVisualElementButton = new JButton("Delete Element");
        copyVisualElementButton = new JButton("Copy Element");
        pasteVisualElementButton = new JButton("Paste Element");
        editVisualElementButton = new JButton("Edit Element");
        saveButton = new JButton("Save Card");

        displayAllPagesButton.addActionListener(new displayAllPagesActionListener());
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
        menuPanel.add(displayAllPagesButton);
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
        elementPanel.setBorder(blackline);
        JPanel pagePanel = new JPanel();
        creatingCardController.setOrientation(card, pagePanel);
        pagePanel.setBorder(redLine);
        JPanel imagePanel = new JPanel();
        JPanel textPanel = new JPanel();
        elementPanel.add(pagePanel);
        imagePanel.setPreferredSize(new Dimension(300,300));
        textPanel.setPreferredSize(new Dimension(400,400));
        pagePanel.setLayout(new FlowLayout());
        pagePanel.add(imagePanel);
        pagePanel.add(textPanel);

        frontText = new JLabel();
        frontImage = new JLabel();

        frontText.addMouseListener(myMouseAdapter);
        frontText.addMouseMotionListener(myMouseAdapter);
        frontImage.addMouseListener(myMouseAdapter);
        frontImage.addMouseMotionListener(myMouseAdapter);


        visualElementController.addText(frontText, "This is were you insert text!");
        System.out.println(card.getFrontPage().getImagePath());
        if(card.getFrontPage().getImagePath()=="./cs509_project1_Swing/src/resources/5.jpg")
        {
            System.out.println("Called!");
            visualElementController.addImage(frontImage,"5",card.getFrontPage());
        }else{
            visualElementController.displayImage(frontImage,card.getFrontPage().getImagePath());
        }


        //System.out.println(page.getTextSize());
        frontText.setFont(new Font(page.getTextType(), Font.PLAIN,page.getTextSize()));
        //frontText.setFont(card.getFrontPage().getTextType());
        frontText.setText(card.getFrontPage().getText());

        //visualElementController.displayImage(frontImage, card.getFrontPage().getImagePath());





        page.setImageLabel(frontImage);
        page.setTextLabel(frontText);

        /*card.getBackPage().setImageLabel(backImage);
        card.getBackPage().setTextLabel(backText);*/


        imagePanel.add(frontImage);
        textPanel.add(frontText);
        frame.add(elementPanel,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(150,50);
        frame.setVisible(true);
    }

    public void createLeftPage(Page page){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        LeftFrame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType+"--"+ card.getFrontPage().getName());
        LeftFrame.setSize(1200,1200);
        LeftFrame.setResizable(false);
        JPanel menuPanel = new JPanel();

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        LeftFrame.setLayout(new BorderLayout());
        LeftFrame.add(menuPanel,BorderLayout.NORTH);
        Border blackline, redLine;
        redLine = BorderFactory.createLineBorder(Color.red);
        blackline = BorderFactory.createLineBorder(Color.black);
        JPanel elementPanel = new JPanel();
        elementPanel.setPreferredSize(new Dimension(900,600));
        //elementPanel.setBounds(100,50,900,600);
        elementPanel.setBorder(blackline);
        //creatingCardController.setOrientation(card, frontPanel);
        JPanel pagePanel = new JPanel();
        creatingCardController.setOrientation(card, pagePanel);
        pagePanel.setBorder(redLine);
        JPanel imagePanel = new JPanel();
        JPanel textPanel = new JPanel();
        elementPanel.add(pagePanel);
        imagePanel.setPreferredSize(new Dimension(300,300));
        textPanel.setPreferredSize(new Dimension(400,400));
        pagePanel.setLayout(new FlowLayout());
        pagePanel.add(imagePanel);
        pagePanel.add(textPanel);

        frontText = new JLabel();
        frontImage = new JLabel();

        page.setImageLabel(frontImage);
        page.setTextLabel(frontText);
        frontText.setText(page.getText());



        imagePanel.add(frontImage);
        textPanel.add(frontText);
        LeftFrame.add(elementPanel,BorderLayout.CENTER);

        //LeftFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LeftFrame.setLocation(0,0);
        LeftFrame.setVisible(false);
    }

    public void createBackPage(Page page){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        BackFrame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType+"--"+ card.getFrontPage().getName());
        BackFrame.setSize(1200,1200);
        BackFrame.setResizable(false);
        JPanel menuPanel = new JPanel();

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();


        BackFrame.setLayout(new BorderLayout());

        /*BoxLayout boxlayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(boxlayout);*/
        BackFrame.add(menuPanel,BorderLayout.NORTH);


        Border blackline, redLine;
        redLine = BorderFactory.createLineBorder(Color.red);
        blackline = BorderFactory.createLineBorder(Color.black);
        JPanel elementPanel = new JPanel();
        elementPanel.setPreferredSize(new Dimension(900,600));
        //elementPanel.setBounds(100,50,900,600);
        elementPanel.setBorder(blackline);
        //creatingCardController.setOrientation(card, frontPanel);
        JPanel pagePanel = new JPanel();
        creatingCardController.setOrientation(card, pagePanel);
        //pagePanel.setPreferredSize(new Dimension(900,600));
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

        frontText = new JLabel();
        frontImage = new JLabel();
        frontText.setText(page.getText());

        page.setImageLabel(frontImage);
        page.setTextLabel(frontText);
        /*card.getBackPage().setImageLabel(backImage);
        card.getBackPage().setTextLabel(backText);*/


        imagePanel.add(frontImage);
        textPanel.add(frontText);
        BackFrame.add(elementPanel,BorderLayout.CENTER);

        //BackFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BackFrame.setLocation(100,100);
        BackFrame.setVisible(false);
    }

    public void createRightPage(Page page){
        String name = card.getName();
        String eventType = card.getEventType();
        String recipient = card.getRecipient();
        RightFrame = new JFrame(name+"-"+"A card for "+recipient+"'s "+eventType+"--"+ card.getFrontPage().getName());
        RightFrame.setSize(1200,1200);
        RightFrame.setResizable(false);
        JPanel menuPanel = new JPanel();
        RightFrame.setLayout(new BorderLayout());
        RightFrame.add(menuPanel,BorderLayout.NORTH);


        Border blackline, redLine;
        redLine = BorderFactory.createLineBorder(Color.red);
        blackline = BorderFactory.createLineBorder(Color.black);
        JPanel elementPanel = new JPanel();
        elementPanel.setPreferredSize(new Dimension(900,600));
        //elementPanel.setBounds(100,50,900,600);
        elementPanel.setBorder(blackline);
        //creatingCardController.setOrientation(card, frontPanel);
        JPanel pagePanel = new JPanel();
        creatingCardController.setOrientation(card, pagePanel);
        //pagePanel.setPreferredSize(new Dimension(900,600));
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

        frontText = new JLabel();
        frontImage = new JLabel();
        frontText.setText(page.getText());
        //ImageIcon imageIcon = new ImageIcon(ImageIO.read(new File("./cs509_project1_Swing/src/resources/5.jpg")));

        page.setImageLabel(frontImage);
        page.setTextLabel(frontText);

        imagePanel.add(frontImage);
        textPanel.add(frontText);
        RightFrame.add(elementPanel,BorderLayout.CENTER);

        //RightFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RightFrame.setLocation(400,400);
        RightFrame.setVisible(false);
    }

    // Button's Listener method
    private class AddVisualElementActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //visualElementController.ChooseVisualElementType(card.getFrontPage(),"Add");
            visualElementController.ChoosePage("Add");
        }
    }

    private class displayAllPagesActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("clicked!");
            if(displayAllPagesButton.getText().equals("Display")){
                BackFrame.setVisible(true);
                LeftFrame.setVisible(true);
                RightFrame.setVisible(true);
                displayAllPagesButton.setText("Undisplay");
            }
        }
    }

    private class DelVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChooseVisualElementType(card.getFrontPage(),"Delete");
        }
    }
    private class CopyVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChooseVisualElementType(card.getFrontPage(),"Copy");
        }
    }
    private class PasteVisualElementActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            visualElementController.ChooseVisualElementType(card.getFrontPage(),"Paste");
        }
    }

    public class SaveCard implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SerializationController().ObjectWriter(card);
        }
    }

////////Main
    public static void main(String[] args) {
        Card card = new Card();
        card.setOrientation("landscape");
        MakerWindow window = new MakerWindow(card);
        window.createAndShowUI(card.getFrontPage());
        window.createBackPage(card.getBackPage());
        window.createLeftPage(card.getLeftPage());
        window.createRightPage(card.getRightPage());
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