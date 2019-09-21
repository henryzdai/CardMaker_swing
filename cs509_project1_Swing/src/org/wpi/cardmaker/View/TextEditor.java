package org.wpi.cardmaker.View;

import org.wpi.cardmaker.Controller.SerializationController;
import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;
import org.wpi.cardmaker.SwingTestCase;
import sun.font.FontFamily;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class TextEditor {
    public Page page;
    public JFrame frame__;
    public JTextPane editor__;
    public JComboBox fontSizeCombo__;
    public JComboBox fontFamilyCombo__;
    private static final String MAIN_TITLE = "My Editor - ";
    private static final String DEFAULT_FONT_FAMILY = "SansSerif";
    private static final int DEFAULT_FONT_SIZE = 18;
    private static final List<String> FONT_LIST = Arrays.asList(new String [] {"Arial", "Calibri", "Cambria", "Courier New", "Comic Sans MS", "Dialog", "Georgia", "Helevetica", "Lucida Sans", "Monospaced", "Tahoma", "Times New Roman", "Verdana"});
    private static final String [] FONT_SIZES  = {"Font Size", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30"};

    public TextEditor(Page page){
        this.page = page;
    }

    public void createAndShowGUI(){
        frame__ = new JFrame("Text Editor");
        editor__ = new JTextPane();
        JScrollPane editorScrollPane = new JScrollPane(editor__);
        editor__.setText(page.getText());

        JButton submit = new JButton();
        submit.setText("Submit");
        submit.addActionListener(new SubmitButtonListener());

        fontSizeCombo__ = new JComboBox<String>(FONT_SIZES);
        fontSizeCombo__.setEditable(false);
        fontSizeCombo__.addItemListener(new FontSizeItemListener());


        Vector<String> editorfonts = getEditorFonts();
        editorfonts.add(0,"Font Family");
        fontFamilyCombo__ = new JComboBox<String>(editorfonts);
        fontFamilyCombo__.setEditable(false);
        fontFamilyCombo__.addItemListener(new FontFamilyItemListener());

        JPanel panel1 = new JPanel(new FlowLayout((FlowLayout.LEFT)));
        panel1.add(fontSizeCombo__);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(fontFamilyCombo__);
        panel1.add(new JSeparator(SwingConstants.VERTICAL));
        panel1.add(submit);


        frame__.add(panel1, BorderLayout.NORTH);
        frame__.add(editorScrollPane, BorderLayout.CENTER);

        frame__.setSize(900,600);
        frame__.setLocation(150,80);
        frame__.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame__.setVisible(true);

        editor__.requestFocusInWindow();

    }


    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*SerializationController sl = new SerializationController();
            sl.ObjectWriter(page);*/
            frame__.setVisible(false);
            page.setText(editor__.getText());
            page.getTextLabel().setFont(new Font(page.getTextType(), Font.PLAIN,24));
            page.getTextLabel().setText(page.text);

        }
    } // SubmitButtonListener


    private class FontSizeItemListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {

            if ((e.getStateChange() != ItemEvent.SELECTED) ||
                    (fontSizeCombo__.getSelectedIndex() == 0)) {
                return;
            }

            String fontSizeStr = (String) e.getItem();
            int newFontSize = 0;
            try {
                newFontSize = Integer.parseInt(fontSizeStr);
            }
            catch (NumberFormatException ex) {

                return;
            }

            fontSizeCombo__.setAction(new StyledEditorKit.FontSizeAction(fontSizeStr, newFontSize));
            //fontSizeCombo__.setSelectedIndex(0); // initialize to (default) select
            page.setTextSize(newFontSize);
            editor__.requestFocusInWindow();
        }
    } // FontSizeItemListener

    private class FontFamilyItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {

            if ((e.getStateChange() != ItemEvent.SELECTED) ||
                    (fontFamilyCombo__.getSelectedIndex() == 0)) {
                return;
            }

            String fontFamily = (String) e.getItem();
            fontFamilyCombo__.setAction(new StyledEditorKit.FontFamilyAction(fontFamily, fontFamily));
            //fontFamilyCombo__.setSelectedIndex(0); // initialize to (default) select
            page.setTextType(fontFamily);
            editor__.requestFocusInWindow();
        }
    } // FontFamilyItemListener

    /*
     * Returns a collection of Font names that are available from the
     * system fonts and are matched with the desired font list (FONT_LIST).
     */
    private Vector<String> getEditorFonts() {

        String [] availableFonts =
                GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        Vector<String> returnList = new Vector<>();

        for (String font : availableFonts) {

            if (FONT_LIST.contains(font)) {
                returnList.add(font);
            }
        }

        return returnList;
    }


    public static void main(String [] args)
            throws Exception {

        UIManager.put("TextPane.font",
                new Font(DEFAULT_FONT_FAMILY, Font.PLAIN, DEFAULT_FONT_SIZE));
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TextEditor(new Page()).createAndShowGUI();
            }
        });
    }
}
