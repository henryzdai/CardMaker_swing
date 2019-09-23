package org.wpi.cardmaker.Controller;

import org.wpi.cardmaker.Model.Card;
import org.wpi.cardmaker.Model.Page;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializationController implements Serializable {

    private static final long serialVersionUID = 1L;

   public SerializationController()
   {

   }

    public void ObjectWriter(Card card){
        try {
            FileOutputStream f = new FileOutputStream(new File("./objects/"+card.getName()));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(card);
            o.close();
            f.close();
            System.out.println("Object writed on the disk");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error In initializing stream");
        }
    }

    public void ObjectCopyWriter(Page page){
        try {
            FileOutputStream f = new FileOutputStream(new File("./objects/"+page.getName()));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(page);
            o.close();
            f.close();
            System.out.println("Object writed on the disk");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error In initializing stream");
        }
    }

    public void ObjectReader(String cardName){
        try {
            FileInputStream fi = new FileInputStream(new File("./objects/"+cardName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            Card card_new= (Card)oi.readObject();
            System.out.println("Object read from the file.");
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Page CopyObjectReadAndCreator(String cardName){
        Page page_new = new Page();
        try {
            FileInputStream fi = new FileInputStream(new File("./objects/"+cardName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            page_new= (Page)oi.readObject();
            System.out.println(page_new.toString());
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return page_new;
    }

    public Card ObjectReadAndCreator(String cardName){
       Card card_new = new Card();
        try {
            FileInputStream fi = new FileInputStream(new File("./objects/"+cardName));
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            card_new= (Card)oi.readObject();
            System.out.println(card_new.toString());
            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return card_new;
    }

    public static void main(String[] args) {
        /*Card card = new Card();
        SerializationController serializationController = new SerializationController();
        serializationController.ObjectWriter(card);*/
        Card card = new SerializationController().ObjectReadAndCreator("Card1");

        //serializationController.ObjectReader(card);
    }
}
