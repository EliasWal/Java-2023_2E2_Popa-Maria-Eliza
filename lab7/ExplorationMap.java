package com.mycompany.lab7;

/**
 *
 * @author Elias
 */
public class ExplorationMap {
    private final Cell[][] matrix;
    
    public boolean visit(int row, int col, Robot robot){
        synchronized (matrix[row][col]){
            if(!visit[row][col]){
               
                List<Token> tokens = explore.
            }
        }
        return false;
    } 

    @Override
    public String toString() {
        return "ExplorationMap{" + "matrix=" + matrix + '}';
    }

}
