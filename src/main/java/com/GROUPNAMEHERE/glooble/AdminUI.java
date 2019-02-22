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
        AdminWindow.setSize(350,350);
        AdminWindow.setBackground(Color.darkGray);
        AdminWindow.getContentPane().add(AdminPanel());
        AdminWindow.setJMenuBar(createMenuBar());
    }
    
    public JMenuBar createMenuBar()
    {
        JMenuBar GloobleAdminBar;
        JMenu menu;
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
        return GloobleAdminBar;
    }
    
    public JPanel AdminPanel()
    {
      JPanel AdminPanel;
      JButton AddButton, RemoveButton;
      JTextArea FileLog;
      JFileChooser FileChooser;
      AddButton = new JButton("Add a File");
      AddButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                FileIndexDialogue Add = new FileIndexDialogue();
                Add.AddIndexDialogue(null);
            }
        });
      RemoveButton = new JButton("Remove File");
      //listener here
      AdminPanel = new JPanel();
      AdminPanel.add(AddButton);
      AdminPanel.add(RemoveButton);
      add(AdminPanel, BorderLayout.PAGE_START);
      return AdminPanel;
    }
}
