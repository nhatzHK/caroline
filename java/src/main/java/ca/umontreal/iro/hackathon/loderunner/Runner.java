package ca.umontreal.iro.hackathon.loderunner;

import ca.hackermen.caroline.PathFinder;
import ca.hackermen.caroline.Position;
import ca.hackermen.caroline.sim.Carunner;

/**
 *
 */
public class Runner extends BasicRunner {

	// TODO : Remplacer ceci par votre clé secrète
	public static final String ROOM = "caroline10";

	/* Utilisez cette variable pour choisir le niveau de départ
	 *
	 * Notez: le niveau de départ sera 1 pour tout
	 * le monde pendant la compétition :v)
	 */
	public static final int START_LEVEL = 1;

	public PathFinder pathFinder;
	public char[][]   mapMatrice;

	public Runner () {
		super (ROOM, START_LEVEL);
		//super(START_LEVEL);
	}

	@Override public void start (String[] grid) {
		System.out.println ("Nouveau niveau ! Grille initiale reçue :");
		char[][] matriceMap;
		String   ligne = grid[0];


		matriceMap = new char[grid.length][ligne.length ()];

		for (int i = 0; i < matriceMap.length; i++) {
			ligne = grid[i];
			for (int j = 0; j < matriceMap[i].length; j++) {

				try {
					matriceMap[i][j] = ligne.charAt (j);
				} catch (StringIndexOutOfBoundsException e) {
					System.out.println ("H-W: " + grid.length + "-" + ligne
						.length () +
					                    "\ti-j:" +
					                    " " +
					                    i + "-" + j);
				}
			}
		}

		pathFinder = new PathFinder (matriceMap);
	}

	@Override public Move next (int x, int y) {
		System.out.println ("Position du runner : (" + x + ", " + y + ")");

		Direction dir      = Direction.NONE;
		Position  nextMove = pathFinder.getNextPos (x, y);

		if (nextMove == null) {
			pathFinder.createPath ();
			nextMove = pathFinder.getNextPos (x, y);
		}

		if (x < nextMove.x) {
			dir = Direction.RIGHT;
		} else if (x > nextMove.x) {
			dir = Direction.LEFT;
		}

		if (y < nextMove.y) {
			dir = Direction.UP;
		} else if (y > nextMove.y) {
			dir = Direction.DOWN;
		}

		return new Move (Event.MOVE, dir);
	}
}
