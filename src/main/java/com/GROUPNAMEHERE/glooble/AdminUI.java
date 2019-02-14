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

public class AdminUI extends Frame
{
    public AdminUI ()
    {
       createAdminWindow(); 
    }
    
    public void createAdminWindow()
    {
        JFrame AdminWindow = new JFrame ("Glooble Admin");
        AdminWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        AdminWindow.setVisible(true);
        AdminWindow.setSize(600,600);
        AdminWindow.setBackground(Color.darkGray);
        AdminWindow.getContentPane().add(AdminButtons());
    }
    
    public JPanel AdminButtons()
    {
      JPanel buttonPanel;
      JButton AddButton, RemoveButton;
      AddButton = new JButton("Add a File");
      //listener here
      RemoveButton = new JButton("Remove File");
      //listener here
      buttonPanel = new JPanel();
      buttonPanel.add(AddButton);
      buttonPanel.add(RemoveButton);
      add(buttonPanel, BorderLayout.PAGE_START);
      return buttonPanel;
    }
}
