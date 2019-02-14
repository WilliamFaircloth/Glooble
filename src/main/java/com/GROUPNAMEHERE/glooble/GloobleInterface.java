/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GROUPNAMEHERE.glooble;

/**
 *
 * @author William, Cody, Reid
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class GloobleInterface extends Frame
{   
    private Frame SearchWindow;
    private Frame AdminWindow;
    public String SearchInput;
    public String GloobleGit = "https://github.com/WilliamFaircloth/Glooble";

    public GloobleInterface()
    {
        createSearchWindow();
        createMenuBar();
        createwindowItems();
    }

    //creating the user interface window with closable button here
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
    }
    
    public void createAdminWindow()
    {
        JFrame AdminWindow = new JFrame ("Glooble Admin");
        AdminWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminWindow.setVisible(true);
        AdminWindow.setSize(600,600);
        AdminWindow.setBackground(Color.darkGray);
        AdminWindow.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        }); 
    }
    
    //editing window to include text and search bar
    public void createwindowItems()
    {
      //search page label and search bar go here
    }

    //here I primarily wanted to make the menu and a clickable link to the admin UI
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
              createAdminWindow();   
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
}