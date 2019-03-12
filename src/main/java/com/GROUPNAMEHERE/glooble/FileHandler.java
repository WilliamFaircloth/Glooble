/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GROUPNAMEHERE.glooble;

/**
 *
 * @author William
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.nio.file.*;

public class FileHandler 
{
    static String currentDir = System.getProperty("user.dir");
    static String defaultDirectory = currentDir + File.separatorChar + "Glooble Files";
    final File GloobleFileDirectory = new File(defaultDirectory + "/index");
    
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
}

