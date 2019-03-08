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

public class FileHandler 
{
    public FileHandler ()
    {
       CreateHandler(); 
    }
    
    public void CreateHandler()
    {
        String currentDir = System.getProperty("user.dir");
        String inputValue = JOptionPane.showInputDialog("Please input a directory to store files", currentDir);
        
        File GloobleFiles = new File(inputValue + File.separatorChar + "Glooble Files" );
        if (!GloobleFiles.exists()) {
            if (GloobleFiles.mkdir()) {
                //put decision stuff here
            } else {
                //put decision stuff here 
            }
        }
    }
}
