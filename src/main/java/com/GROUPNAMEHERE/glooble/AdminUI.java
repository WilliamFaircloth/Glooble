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
        AdminWindow.setJMenuBar(createMenuBar());
    }
    
    public JMenuBar createMenuBar()
    {
        JMenuBar GloobleAdminBar;
        JMenu menu, submenu;
        JMenuItem menuSelect;
        
        GloobleAdminBar = new JMenuBar();
        
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "File");
        GloobleAdminBar.add(menu);
        
        menuSelect = new JMenuItem("Open      Ctrl+O",KeyEvent.VK_T);
        menu.add(menuSelect);
        menuSelect = new JMenuItem("Close",KeyEvent.VK_T);
        menu.add(menuSelect);
        menuSelect = new JMenuItem("Save      Ctrl+S",KeyEvent.VK_T);
        menu.add(menuSelect);
        menuSelect = new JMenuItem("SaveAs...",KeyEvent.VK_T);
        menu.add(menuSelect);
        menu.addSeparator();
        menuSelect = new JMenuItem("Exit",KeyEvent.VK_T);
        menu.add(menuSelect);

        menu = new JMenu("Settings");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "Settings");
        GloobleAdminBar.add(menu);
        
        menuSelect = new JMenuItem("General Settings",KeyEvent.VK_T);
        menu.add(menuSelect);
        
        menu.add(menuSelect);
        menu = new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "About");
        GloobleAdminBar.add(menu);
        menuSelect = new JMenuItem("Glooble Git",KeyEvent.VK_T);
        menu.add(menuSelect);
        
        return GloobleAdminBar;
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
