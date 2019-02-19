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

import java.awt.event.*; 
import javax.swing.filechooser.*;
import java.io.*; 
import javax.swing.*;
class FileIndexDialogue extends JFrame implements ActionListener 
{
    FileIndexDialogue ()
    {
    
    }
    
    //This dialogue uses Jfilechooser to select files for Glooble search function
    static JLabel NoFileStupid;
    
    public static void AddIndexDialogue(String []args)
    {
        JFrame IndexDialogue = new JFrame ("IndexDialogue");
        IndexDialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        IndexDialogue.setVisible(true);
        IndexDialogue.setSize(500, 250);
        FileIndexDialogue FileC = new FileIndexDialogue();
        JButton AddButton = new JButton("Add");
        AddButton.addActionListener(FileC); 
        JButton CloseButton = new JButton("Close");
        CloseButton.addActionListener(FileC);
        JPanel FilePanel = new JPanel();
        FilePanel.add(AddButton); 
        FilePanel.add(CloseButton);
        NoFileStupid = new JLabel("no file big dummy!");
        
        FilePanel.add(NoFileStupid); 
        IndexDialogue.add(FilePanel);
    }
    
    public void actionPerformed(ActionEvent evt)
    {
        String Interact = evt.getActionCommand();
        if(Interact.equals("Add"))
        {
            JFileChooser AddChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            int Alpha = AddChooser.showSaveDialog(null);
            AddChooser.setMultiSelectionEnabled(true);
            if (Alpha == JFileChooser.APPROVE_OPTION) 
            { 
                File files[] = AddChooser.getSelectedFiles(); 
                int counter = 0; 
                // set text to blank 
                NoFileStupid.setText("");
                while (counter++ < files.length) 
                    NoFileStupid.setText(NoFileStupid.getText() + " " + files[counter - 1].getName());
            }
            else
                NoFileStupid.setText("Somthing went Wrong");
        }
        else if(Interact.equals("Close"))
        {
            dispose();
        }    
    }
}
