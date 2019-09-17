package org.wpi.cardmaker.Controller;

import java.io.*;

public class SerializationController implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private String gender;

   public SerializationController()
   {

   }

   public void ObjectWriter(Object object){
       try {
           FileOutputStream fileOutputStream = new FileOutputStream(new File("ObjectSerialization.txt"));
           ObjectOutputStream objectOutStream = new ObjectOutputStream(fileOutputStream);
           objectOutStream.writeObject(object);
           objectOutStream.close();
           fileOutputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void ObjectReader(Object obejct){
       FileInputStream fi = null;
       try {
           fi = new FileInputStream(new File("ObjectSerialization.txt"));
           ObjectInputStream oi = new ObjectInputStream(fi);
           oi.close();
           fi.close();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

   }

    public static void main(String[] args) {

    }
}
