/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.hackermen.caroline;

/**
 *
 * @author Noot
 */
public class DeadEnd {
    
    Position pos1,pos2;
    
    public DeadEnd(Position pos1,Position pos2){
        
        this.pos1 = pos1;
        this.pos2 = pos2;
        
    }
    
    public boolean [][] setArea( char [][] mat){
        
        boolean [] [] matDE = new boolean [mat.length] [mat[0].length];
        
        
        for (int i = pos1.y; i < pos2.y; i++) {
            
            for (int j = pos1.x; j < pos2.x; j++) {
                
                matDE [i][j] = true;
                
            }
            
        }
        
    return matDE;
    }
    
}
