package com.mycompany.lab6;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Elias
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int numDots;
    private double lineProbability;
    final static int W = 800, H = 600;
    
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    public void setNumDots(int numDots) {
        this.numDots = numDots;
    }

    public void setLineProbability(double lineProbability) {
        this.lineProbability = lineProbability;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = 400;
        int centerY = 600;
        int radius = 250;
        int dotSize = 10;
        
        
    }

}
