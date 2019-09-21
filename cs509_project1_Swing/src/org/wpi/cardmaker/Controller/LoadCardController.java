package org.wpi.cardmaker.Controller;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Constructor;

public class LoadCardController {

    public LoadCardController(){

    }

    public String[] ReadDirectory(){
        File folder = new File("./objects");
        File[] listOfFiles = folder.listFiles();
        String[] names = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            System.out.println("File " + listOfFiles[i].getName());
            names[i] = listOfFiles[i].getName();
        }
        return names;
    }


    public void AddCardController(){

        //new SerializationController().ObjectReader();
    }

    public void DeleteCardController(String name){
        name = "./objects/"+name;
        System.out.println(name);
        File file = new File(name);
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }

    public void loadCardController(){

    }

    public void DupicateCardController(){

    }

    public void UpdateController(){

    }

}
