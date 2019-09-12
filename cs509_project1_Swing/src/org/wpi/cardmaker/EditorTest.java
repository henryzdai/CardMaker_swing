package org.wpi.cardmaker;

// Java program to create a blank text field and set BOLD font type
import org.wpi.cardmaker.Model.Page;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class EditorTest extends JFrame implements ActionListener {
    // JTextField
    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton b;


    // label to diaplay text
    static JLabel l;

    // confirm
    static JButton confirm;
    // Font name;
    static JLabel font;
    // Font choice;
    static JComboBox fontStyle;
    // Font name;
    static JLabel size;
    // Font choice;
    static JComboBox sizeNumber;




    // default constructor
    EditorTest()
    {
    }

    // main class
    public static void main(String[] args)
    {
        // create a new frame to stor text field and button
        f = new JFrame("textfield");

        // create a label to display text
        l = new JLabel("nothing entered");

        // create a new button
        b = new JButton("submit");

        // create a object of the text class
        EditorTest te = new EditorTest();

        // addActionListener to button
        b.addActionListener(te);


        //
        Page page = new Page();
        confirm = new JButton("Ok");
        font = new JLabel("Font");
        fontStyle = new JComboBox();
        fontStyle.addItem("Comic Sans MS");
        fontStyle.addItem("Lucida Calligraphy");
        fontStyle.addItem("Times New Roman");
        size = new JLabel("Font Size");
        String[] sizeArray = { "1", "2", "3", "4", "5", "6" , "24","25"};
        sizeNumber = new JComboBox(sizeArray);


        //juice
        ItemListener ItemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                int state = itemEvent.getStateChange();
                System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
                System.out.println("Item: " + itemEvent.getItem());
                ItemSelectable is = itemEvent.getItemSelectable();
                page.setTextType((String) itemEvent.getItem());
            }
        };

        sizeNumber.addItemListener(ItemListener);
        fontStyle.addItemListener(ItemListener);


        // create a object of JTextField with 16 columns
        t = new JTextField(16);

        // create an object of font type
        Font fo = new Font("Serif", Font.BOLD, 20);
        Font fo1 = new Font("Comic Sans MS", Font.PLAIN, 24);
        Font fo2 = new Font("Lucida Calligraphy", Font.PLAIN, 24);
        Font fo3 = new Font("Times New Roman", Font.ROMAN_BASELINE, 24);

        // set the font of the textfield
        Font fon = new Font(page.getTextType(),Font.PLAIN,24);
        t.setFont(fon);

        // create a panel to add buttons and textfield
        JPanel p = new JPanel();

        // add buttons and textfield to panel
        p.add(t);
        p.add(font);
        p.add(fontStyle);
        p.add(size);
        p.add(sizeNumber);
        p.add(b);
        p.add(l);
        p.add(confirm);
        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);

        f.show();
    }

    // if the vutton is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("submit")) {
            //Font fon = new Font(page.getTextType(),Font.PLAIN,24);
            // set the text of the label to the text of the field
            l.setText(t.getText());
            //l.setFont(fon);
            // set the text of field to blank
            t.setText("  ");
        }
    }
}