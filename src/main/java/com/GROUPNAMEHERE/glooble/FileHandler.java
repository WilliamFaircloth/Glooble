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
    
    static Map<String, HashMap<String,ArrayList>> index = new TreeMap<>();
    public static void createIndex() 
    {
        Path dir = Paths.get(defaultDirectory);
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir, "*.*"))
        {
            for (Path file: ds)
            {
                int wordPos = 0;
                String fileName = file.getFileName().toString();
                Scanner scan = new Scanner(file);
                while (scan.hasNext())
                {
                    String word = scan.next();
                    word = word.toLowerCase();
                    if (!index.containsKey(word))
                    {
                        HashMap<String, ArrayList> map = new HashMap<>();
                        ArrayList<Integer> wordLoc = new ArrayList();
                        wordLoc.add(wordPos);
                        map.put(fileName, wordLoc);
                        index.put(word, map);
                        
                    }
                    else if (index.containsKey(word))
                    try {
                        HashMap<String, ArrayList> map = index.get(word);
                        ArrayList<Integer> wordLoc /*= map.get(fileName)*/;
                        if (map.containsKey(fileName))
                        {
                            wordLoc = map.get(fileName);
                            wordLoc.add(wordPos);
                            map.put(fileName, wordLoc);
                        }
                        else if (!map.containsKey(fileName))
                        {
                            wordLoc = new ArrayList();
                            wordLoc.add(wordPos);
                            map.put(fileName, wordLoc);
                        }
                        index.put(word, map);
                    } catch (NullPointerException e) {
                        System.err.println(e);
                    }
                    wordPos++;
                }
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        System.out.println(index); //To test or check the result
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

