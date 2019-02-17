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

public class SearchUI extends Frame
{
    public SearchUI ()
    {
       createSearchWindow(); 
    }
    
    public void createSearchWindow()
    {
        JFrame SearchWindow = new JFrame ("Glooble Search");
        SearchWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SearchWindow.setVisible(true);
        SearchWindow.setSize(600,600);
        SearchWindow.setBackground(Color.darkGray);
        SearchWindow.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });  
        SearchWindow.setJMenuBar(createMenuBar());
        SearchWindow.getContentPane().add(SearchBar());
    }
    
    public JMenuBar createMenuBar()
    {
        JMenuBar GloobleBar;
        JMenu menu, submenu;
        JMenuItem menuSelect;
        
        GloobleBar = new JMenuBar();
        
        menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "File");
        GloobleBar.add(menu);
        
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
        GloobleBar.add(menu);
        
        menuSelect = new JMenuItem("General Settings",KeyEvent.VK_T);
        menu.add(menuSelect);
        
        menu = new JMenu("Admin");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "Admin");
        GloobleBar.add(menu);
        
        menuSelect = new JMenuItem("Open Admin window",KeyEvent.VK_T);
        menuSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              AdminUI obj = new AdminUI();   
            }
        });
        menu.add(menuSelect);
        menu = new JMenu("About");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
        "About");
        GloobleBar.add(menu);
        menuSelect = new JMenuItem("Glooble Git",KeyEvent.VK_T);
        menu.add(menuSelect);
                
        return GloobleBar;
    }
    
    //Attempt at creating goofy ass searchbar
    public JPanel SearchBar()
    {
        JPanel S1;
        JTextField searchBar = new JTextField(20);
        S1 = new JPanel();
                
        S1.add(searchBar);
        add(S1, BorderLayout.CENTER);
        return S1;
        
    
    }
}
