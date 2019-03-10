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
import javax.swing.filechooser.*;
import javax.swing.text.*;


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
        AdminWindow.setSize(450,405);
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
      AdminPanel = new JPanel();
      JButton AddButton, RemoveButton;
      
      JTextArea FileArea = new JTextArea(20,20);
      JScrollPane scrollPane = new JScrollPane(FileArea);
      FileArea.setEditable(false);
     
      AddButton = new JButton("Add File");
      AddButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String Interact = e.getActionCommand();
                if(Interact.equals("Add File"))
                {
                    JFileChooser AddChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    AddChooser.setMultiSelectionEnabled(true);
                    if (JFileChooser.APPROVE_OPTION == AddChooser.showOpenDialog(null)) 
                    { 
                        File selectedFile = AddChooser.getSelectedFile();
                        String filePath = selectedFile.getAbsolutePath();
                        
                        try
                        {
                        File source = new File(filePath);
                        File destination = new File(FileHandler.defaultDirectory, selectedFile.getName());
                        InputStream inStream = new FileInputStream(source);
                        OutputStream outStream = new FileOutputStream(destination);
                        byte[] streamBuffer = new byte[1024];
                        int length;
                            while ((length = inStream.read(streamBuffer)) > 0)
                            {
                               outStream.write(streamBuffer, 0, length);
                            }
                            if (inStream != null)inStream.close();
                            if (outStream != null)outStream.close();
                        }
                        catch(IOException event)
                        {
                            event.printStackTrace();
                        }
                        
                        for (File file : AddChooser.getSelectedFiles())
                        {
                          FileArea.append(file.getName() + System.getProperty("line.separator"));  
                        }  
                    }
                }
                else if(Interact.equals("Close"))
                {
                dispose();
                }
            }
        });
      
      RemoveButton = new JButton("Remove File");
      RemoveButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String Interact = e.getActionCommand();
                String userDirectory = System.getProperty("user.dir");
                if(Interact.equals("Remove File"))
                {
                    JFileChooser RemoveChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                    int Alpha = RemoveChooser.showSaveDialog(null);
                    RemoveChooser.setMultiSelectionEnabled(true);
                    if (Alpha == JFileChooser.APPROVE_OPTION) 
                    { 
                        File files[] = RemoveChooser.getSelectedFiles(); 
                        int counter = 0; 
                        // set text to blank 
                    }
                }
                else if(Interact.equals("Close"))
                {
                dispose();
                }
            }
        });
      
      AdminPanel.add(AddButton);
      AdminPanel.add(RemoveButton);
      AdminPanel.add(scrollPane);
      add(AdminPanel);
      return AdminPanel;
    }
    
}
