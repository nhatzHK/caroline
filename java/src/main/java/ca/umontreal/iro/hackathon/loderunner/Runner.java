package ca.umontreal.iro.hackathon.loderunner;

import ca.hackermen.caroline.PathFinder;

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

        int direction = (int) (Math.random() * 4 + 1);

        Direction dir = Direction.fromInt(direction);

        return new Move(Event.MOVE, dir);
    }
}
