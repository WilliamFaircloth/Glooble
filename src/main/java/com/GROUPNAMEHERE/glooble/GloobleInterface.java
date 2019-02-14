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
import java.awt.*;
import java.awt.event.*;

public class GloobleInterface extends Frame
{   
    private Frame SearchWindow;
    public String SearchInput;

    public GloobleInterface()
    {
        createSearchWindow();
        createMenuBar();
        createwindowItems();
    }

    //creating the user interface window with closable button here
    public void createSearchWindow()
    {
        
        SearchWindow = new Frame ("Glooble Search");
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
    }
    
    //editing window to include text and search bar
    public void createwindowItems()
    {
      setLayout(new GridLayout(3,1));
      
      Label GloobleLabel;
      GloobleLabel = new Label("Glooble Search", Label.CENTER);
      GloobleLabel.setBackground(Color.darkGray);
      GloobleLabel.setForeground(Color.blue);
      GloobleLabel.setFont(new Font("ComicSansMS", Font.BOLD,20));
      SearchWindow.add(GloobleLabel);
      
    }

    //creating menu bar with file and settings menus
    //here I primarily wanted to make a clickable link to the administrator UI
    public void createMenuBar()
    {
        final MenuBar GloobleMenu = new MenuBar();
    
        Menu fileMenu = new Menu("File");
        Menu settingsMenu = new Menu("settings");
        MenuItem AdminWindowItem = new MenuItem("administration");
        AdminWindowItem.setActionCommand("administration");
    
        SearchWindow.setMenuBar(GloobleMenu);
        SearchWindow.setVisible(true);
    
        GloobleMenu.add(fileMenu);
        GloobleMenu.add(settingsMenu);
    
        settingsMenu.add(AdminWindowItem);
    
        AdminWindowItem.addActionListener((ActionEvent e) -> {
            SearchWindow = new Frame ("Admin Window");
            SearchWindow.setVisible(true);
            SearchWindow.setSize(600,600);
            SearchWindow.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.exit(0);
                }
            });
        });
    }
}