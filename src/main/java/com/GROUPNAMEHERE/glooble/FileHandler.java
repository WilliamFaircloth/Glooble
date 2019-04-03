/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GROUPNAMEHERE.glooble;

/**
 *
 * @author William
 * @author Reid
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.*;
import java.nio.file.*;
import java.util.Date;
import java.io.File;
import org.json.*;

public class FileHandler 
{
    static String currentDir = System.getProperty("user.dir");
    static String defaultDirectory = currentDir + File.separatorChar + "Glooble Files";
    final File GloobleFileDirectory = new File(defaultDirectory + "/index");
    final static File fileINFO = new File(defaultDirectory + "/index" + "/fileINFO.txt");
    
    public FileHandler ()
    {
       CreateHandler(); 
    }
    
    public File SendFile()
    {
        File SendFile = GloobleFileDirectory;
        return SendFile;
    }
    
    public void CreateHandler()
    {
        if(!GloobleFileDirectory.exists())
        {
            defaultDirectory = JOptionPane.showInputDialog("Please input a directory to store files", currentDir);
            GloobleFileDirectory.mkdirs();
        }
    }
    
    public static void updateFileInfo() 
    {
        try 
        {
            Path dir = Paths.get(defaultDirectory);
            PrintStream out = new PrintStream( new FileOutputStream(fileINFO));
            try (DirectoryStream<Path> updateStream = Files.newDirectoryStream(dir, "*.*"))
            {
                for (Path file: updateStream)
                {
                    JSONObject jo1 = new JSONObject()
                    .put("File Name", file.getFileName().toString())
                    .put("File Path", file.toString())
                    .put("Last Modified", new Date(file.toFile().lastModified()));
                    out.println(jo1);
                }
            } catch (IOException x) {
                System.err.println(x);
            }
            out.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        
    }
    
    Map<String, Set<IndexData<String,ArrayList>>> index = new TreeMap<>();
    public static void createIndex() 
    {
    
    }
}

/**
 * A class to be used with the createIndex method.
 * Each instance is intended to hold the name of a file and an ArrayList of
 * the locations of a word in that file. 
 * 
 * The class is a modified version of the Tuple class seen within the
 * NestedMap.java demo on wpollock.com/COP2805C.
 * 
 * @author Reid
 * @param <T1>
 * @param <T2> 
 */
class IndexData <T1, T2>
{
    public final T1 fileName;
    public final T2 wordLoc;
    
    IndexData(T1 t, T2 s)
    {
        fileName = t;
        wordLoc = s;
    }
    
    public T1 getIndexedFileName() {return fileName;}
    public T2 getIndexedWordLoc() {return wordLoc;}
}

