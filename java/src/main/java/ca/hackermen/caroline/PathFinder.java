package ca.hackermen.caroline;

import java.util.ArrayList;

public class PathFinder {

    char[][] mapMatrice;
    Position exit;
    Position player;
    ArrayList<Position> coins;
    int foundCoins = 0;

    public PathFinder(char[][] map) {

        mapMatrice = map;

        posCoins(coins);
        posExit();
        posPlayer();
    }

    /**
     * Remplit l'array list avec les positions des coins
     *
     * @param coins
     */
    public void posCoins(ArrayList<Position> coins) {
        
        
    }

    /**
     * Return la position de la porte sur la map
     *
     * @return
     */
    public Position posExit() {
        Position position = new Position(0, 0);

        return position;
    }

    /**
     * Return la position du player
     *
     * @return
     */
    public Position posPlayer() {
        Position position = new Position(0, 0);

        for (int i = 0; i < mapMatrice.length; i++) {
            for (int j = 0; j < mapMatrice[i].length; j++) {
                if(mapMatrice[i][j] == '&') {
                    position.x = j;
                    position.y = i;
                }
            }
            
        }
        return position;
    }
}
