package ca.hackermen.caroline;

import java.util.ArrayList;

public class PathFinder {
	Position            exit;
	Position            player;
	ArrayList<Position> coins;
	int foundCoins = 0;

	public PathFinder(String[][] map) {
		posCoins(coins,map);
		posExit();
		posPlayer();
	}

	/**
	 * Remplit l'array list avec les positions des coins
	 * @param coins
	 */
	public void posCoins(ArrayList<Position> coins, char [][] mat) {
            

            for (int i = 0; i < mat.length; i++) {
             
                for (int j = 0; j < mat[i].length; j++) {
                    
                    if(mat[i][j] == '$'){
                        
                        coins.add(new Position(i, j));
                        
                    }
                    
                }
                
            }
            
            
	}
        

	/**
	 * Return la position de la porte sur la map
	 * @return
	 */
	public Position posExit() {
		Position position = new Position (0, 0);

		return position;
	}

	/**
	 * Return la position du player
	 * @return
	 */
	public Position posPlayer() {
		Position position = new Position (0, 0);

		return position;
	}
}
