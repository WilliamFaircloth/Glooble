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

public class SearchUI extends JFrame
{
    public SearchUI ()
    {
       createSearchWindow(); 
    }
    
    public void createSearchWindow()
    {
        JFrame SearchWindow = new JFrame ("Glooble Search");
        SearchWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SearchWindow.setContentPane(SearchBar());
        getContentPane().add(SearchBar(), BorderLayout.CENTER);
        SearchWindow.setJMenuBar(createMenuBar());
        SearchWindow.setVisible(true);
        SearchWindow.setSize(800,800);
        SearchWindow.setBackground(Color.darkGray);
        SearchWindow.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });  
    }
    
    public JMenuBar createMenuBar()
    {
        JMenuBar GloobleBar;
        JMenu menu;
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
        menuSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
              System.exit(0);   
            }
        });
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
        menuSelect = new JMenuItem("About Glooble", KeyEvent.VK_T);
        menuSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                AboutUI obj = new AboutUI();
            }
        });
        menu.add(menuSelect);
        menuSelect = new JMenuItem("Glooble Git",KeyEvent.VK_T);
        menuSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try 
                {
                    String url = "https://github.com/WilliamFaircloth/Glooble";
                    Desktop.getDesktop().browse(java.net.URI.create(url));
                }
                catch (java.io.IOException g) 
                {
                    System.out.println(g.getMessage());
                }
            }
        });
        menu.add(menuSelect);
                
        return GloobleBar;
    }
    
    public JPanel SearchBar()
    {
        JPanel SearchPanel;
        JButton SearchButton;
        JTextField SearchBar;
        JCheckBox AllTerms, AnyTerms, Exact;
        
        SearchPanel = new JPanel();
        GroupLayout Searchlayout = new GroupLayout(SearchPanel);
        Searchlayout.setAutoCreateGaps(true);
        Searchlayout.setAutoCreateContainerGaps(true);
        
        SearchBar = new JTextField(30);
        SearchButton = new JButton("Search");
        AllTerms = new JCheckBox("Search All Terms");
        AnyTerms = new JCheckBox("Search Any Terms");
        Exact = new JCheckBox("Search Exact Match");
        
        Searchlayout.setHorizontalGroup(Searchlayout.createSequentialGroup()
            
            .addGroup(Searchlayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(SearchBar)
                .addGroup(Searchlayout.createSequentialGroup()
                    .addGroup(Searchlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(AllTerms))
                        .addComponent(AnyTerms)
                        .addComponent(Exact)))
            .addGroup(Searchlayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(SearchButton)) 
        );        
        
        Searchlayout.setVerticalGroup(Searchlayout.createSequentialGroup()
            .addGroup(Searchlayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(SearchBar)
            .addComponent(SearchButton))
        .addGroup(Searchlayout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addComponent(AllTerms)
            .addComponent(AnyTerms)
            .addComponent(Exact)));
        
        SearchPanel.setLayout(Searchlayout);
        return SearchPanel;
    }
    
}
