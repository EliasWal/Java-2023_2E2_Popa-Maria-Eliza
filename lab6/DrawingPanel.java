package com.mycompany.lab6;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Elias
 */
public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int numDots;
    private double probability;
    //private List<Point> points= new ArrayList<>();
   // private List<Color> colors= new ArrayList<>();
    //private List<Line> lines= new ArrayList<>();
    //private boolean gameEnded = false;
    final static int W = 800, H = 600;
    
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        initPanel();
    }
    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        setBackground(Color.white);
    }

    public void setNumDots(int numDots) {
        this.numDots=numDots;
        repaint();
    }
    
    public int getNumDots() {
        numDots = (Integer) frame.configPanel.dotsSpinner.getValue();
        return numDots;
    }

    public double getProbability() {
        probability = (double)frame.configPanel.linesCombo.getSelectedItem();
        return probability;
    }

    public void setProbability(double Probability) {
        this.probability = probability;
    }

    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = 400;
        int centerY = 300;
        int radius = 250;
        int dotSize = 10;
        g.setColor(Color.BLACK);
        numDots = (Integer) frame.configPanel.dotsSpinner.getValue();
        probability = (double) frame.configPanel.linesCombo.getSelectedItem() ;
        java.util.List<Point> points = new ArrayList<>();
        for (int i = 0; i < numDots; i++) {
        double angle = i * 2 * Math.PI / numDots;
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY + radius * Math.sin(angle));
        g.fillOval(x - dotSize / 2, y - dotSize / 2, dotSize, dotSize);
        points.add(new Point(x, y));
    }
    int nr = 0;
    g.setColor(Color.RED);
    for (int i = 0; i < numDots; i++) {
        for (int j = i + 1; j < numDots; j++) {
            if (Math.random()< probability) {
                g.drawLine(points.get(i).x, points.get(i).y, points.get(j).x, points.get(j).y);
                nr++;
            }
        }
    }
    }
    

}
