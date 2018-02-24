<<<<<<< HEAD
package ca.umontreal.iro.hackathon.loderunner;

/**
 *
 */
public class Runner extends BasicRunner {

    // TODO : Remplacer ceci par votre clé secrète
    public static final String ROOM = "caroline03";

    /* Utilisez cette variable pour choisir le niveau de départ
     *
     * Notez: le niveau de départ sera 1 pour tout
     * le monde pendant la compétition :v)
     */
    public static final int START_LEVEL = 1;

    public Runner() {
        super(ROOM, START_LEVEL);
    }

    @Override
    public void start(String[] grid) {
        System.out.println("Nouveau niveau ! Grille initiale reçue :");

        for (int i = 0; i < grid.length; i++) {
            String ligne = grid[i];

            System.out.println(ligne);
        }
    }

    @Override
    public Move next(int x, int y) {
        System.out.println("Position du runner : (" + x + ", " + y + ")");

        int direction = (int) (Math.random() * 4 + 1);

        Direction dir = Direction.fromInt(direction);

        return new Move(Event.MOVE, dir);
    }
}
=======
package ca.umontreal.iro.hackathon.loderunner;

import ca.hackermen.caroline.PathFinder;
import ca.hackermen.caroline.Position;
import java.util.ArrayList;

/**
 *
 */
public class Runner extends BasicRunner {

    // TODO : Remplacer ceci par votre clé secrète
    public static final String ROOM = "caroline18";
    
    /* Utilisez cette variable pour choisir le niveau de départ
     *
     * Notez: le niveau de départ sera 1 pour tout
     * le monde pendant la compétition :v)
     */
    public static final int START_LEVEL = 1;
    
    public PathFinder pathFinder;
    public char[][] mapMatrice;
    public Runner() {
        super(ROOM, START_LEVEL);
    }

    @Override
    public void start(String[] grid) {
        System.out.println("Nouveau niveau ! Grille initiale reçue :");
        char[][] matriceMap; 
        String ligne = grid[0];
        
        
        
        matriceMap = new char[grid.length][ligne.length()];

        for (int i = 0; i < matriceMap.length; i++) {
            ligne = grid[i];
            for (int j = 0; j < matriceMap[i].length; j++) {
                
                matriceMap[i][j] = ligne.charAt(j);
                
            }
        }
        
        pathFinder = new PathFinder(matriceMap);
        
    }

    @Override
    public Move next(int x, int y) {
        System.out.println("Position du runner : (" + x + ", " + y + ")");

        Direction dir = Direction.NONE;
        Position nextMove = pathFinder.getNextPos();
        
        if(x < nextMove.x) {
            dir = Direction.RIGHT;
        }
        else if (x > nextMove.x){
            dir = Direction.LEFT;
        }
        
        if (y < nextMove.y){
            dir = Direction.UP;
        }
        else if (y > nextMove.y){
            dir = Direction.DOWN;
        }

        return new Move(Event.MOVE, dir);
    }
}
>>>>>>> 08ed1733c623ef7ee317d9b1dc93f60d0005acfa
