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

public class GloobleSearch 
{
   
    public GloobleSearch ()
    {
       SearchResults();
    }
   
    public JPanel SearchResults()
    {
        JPanel ResultsPanel = new JPanel(new BorderLayout());
        ResultsPanel.setLayout(new BorderLayout());
        ResultsPanel.setVisible(true);
        JTextArea ResultsArea = new JTextArea(200,200);
        ResultsPanel.add(ResultsArea, BorderLayout.SOUTH);
        ResultsArea.setText("Your Search returned these results...");
        ResultsArea.setLineWrap(true);
        ResultsArea.setWrapStyleWord(true);
        JScrollPane areaScrollPane = new JScrollPane(ResultsArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        
        return ResultsPanel;
    }
}
