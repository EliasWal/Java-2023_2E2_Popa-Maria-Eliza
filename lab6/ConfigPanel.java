package com.mycompany.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Elias
 */
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    
    private void init() {
        //create the label and the spinner
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        
        linesLabel = new JLabel("Line probability:");
        Double[] lineOptions = {1.0, 0.75 , 0.5, 0.25};
        linesCombo = new JComboBox(lineOptions);
        createButton = new JButton("Create new game");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numDots= (int) dotsSpinner.getValue();
                double numLines= (double) linesCombo.getSelectedItem();
                frame.repaint();
                 System.out.println(numLines);
            }
        });

         //create the rest of the components
         //...TODO
         add(dotsLabel); //JPanel uses FlowLayout by default
         add(dotsSpinner);
         add(linesLabel);
         add(linesCombo);
         add(createButton);
         //...TODO
    }
   
}
