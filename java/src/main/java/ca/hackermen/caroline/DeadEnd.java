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
        
        
        for (int i = pos1.getY(); i < pos2.getY(); i++) {
            
            for (int j = pos1.getX(); j < pos2.getX(); j++) {
                
                matDE [i][j] = true;
                
            }
            
        }
        
    return matDE;
    }
    
    public boolean [][] mergeArea(boolean area1 [][],boolean area2[][]){
        
        boolean area3 [][] = new boolean [area1.length][area1[0].length];
        
        for (int i = 0; i < area1.length; i++) {
            
            for (int j = 0; j < area1[j].length; j++) {
                
                if (area1[i][j] == true || area2[i][j] == true) {
                    
                    area3[i][j] = true;
                    
                }
                
            }
            
        }
        
        return area3;
    }
    
}
