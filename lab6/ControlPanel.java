package com.mycompany.lab6;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Elias
 */
public class ControlPanel extends JPanel{
        final MainFrame frame;
        JButton exitBtn = new JButton("Exit");
        JButton loadButton;
        JButton saveButton;
        JButton resetButton;
        JButton exitButton;
        //create all buttons (Load, Exit, etc.)
        //...TODO
        public ControlPanel(MainFrame frame) {
            this.frame = frame; init();
        }
        private void init() {
            //change the default layout manager (just for fun)
            setLayout(new FlowLayout(FlowLayout.CENTER));
            loadButton = new JButton("Load");
            saveButton = new JButton("Save");
            resetButton = new JButton("Reset");
            exitButton = new JButton("Exit");
            //configure listeners for all buttons
            exitBtn.addActionListener(this::exitGame);
            //...TODO
            add(loadButton);
            add(saveButton);
            add(resetButton);
            add(exitButton);
        }
        private void exitGame(ActionEvent e) {
            frame.dispose();
        }
        //...TODO
}
