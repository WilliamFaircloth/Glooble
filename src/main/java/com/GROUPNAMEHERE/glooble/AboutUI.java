/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GROUPNAMEHERE.glooble;

/**
 *
 * @author Reid
 */

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AboutUI extends Frame 
{
     // About message, shows who program was created by, date, and copyright
    String aboutMessage = "Created by William Faircloth, Cody Mullins,\n"
        + "Brandon Henriksen, and Reid Wheeler.\n"
        + "Tampa, Florida 2019\n" 
        + " © 2019";
    
    // Creates About window
    public AboutUI ()
    {
        createAboutWindow();
    }        
    
    public void createAboutWindow()
    {
        JOptionPane.showMessageDialog(null, aboutMessage);
    }
    
/** 
 *  //Leaving this here as an option for a more detailed about window. 
    public void createAboutWindow()
    {
        JFrame AboutWindow = new JFrame ("About Glooble");
        AboutWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AboutWindow.setSize(500,300);
        AboutWindow.setBackground(Color.darkGray);
        AboutWindow.setVisible(true);
    }
 */
}
