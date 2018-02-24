package ca.hackermen.caroline;

import java.util.ArrayList;

public class PathFinder {

	Position exit;
	Position player;
	ArrayList<Position> coins = new ArrayList<> ();
	ArrayList<Position> path  = new ArrayList<> ();
	Position[][] map;

	public PathFinder (char[][] map) {
		posCoins ();
		posExit ();
		posPlayer ();
	}

	/**
	 * Remplit l'array list avec les positions des coins
	 *
	 * @param
	 */
	public void posCoins () {

	}

	/**
	 * Return la position de la porte sur la map
	 *
	 * @return
	 */
	public Position posExit () {
		Position position = new Position (0, 0);

		return position;
	}

	/**
	 * Return la position du player
	 *
	 * @return
	 */
	public Position posPlayer () {
		Position position = new Position (0, 0);

		return position;
	}

	public void createPath () {
		Position goal;
		path.clear ();
		path.add (player);
		for (int i = 0; i < path.size (); ++ i) {
			ArrayList<Position> branches = getBranches (player);
			goal = jackPot(branches);
			if (goal != null) {
				path.add (goal);
				break;
			} else {
				path.addAll (branches);
			}

			// FIXME: debug, to remove
			if (path.size () > 5) {
				break;
			}
		}
	}

	/**
	 * Renovie une liste des directions possibles a partir de la position
	 * actuelle
	 *
	 * @param p
	 *
	 * @return
	 */
	public ArrayList<Position> getBranches (Position p) {

		ArrayList<Position> around = new ArrayList<> ();
		around.add (new Position (p.x + 1, p.y, p.z));
		around.add (p);

		if (! (p.x + 1 > map.length)) {
			around.add (new Position (p.x + 1, p.y, p.z + 1));
		}

		if (! (p.x - 1 < 0)) {
			around.add (new Position (p.x - 1, p.y, p.z + 1));
		}

		if (! (p.y + 1 > map.length)) {
			around.add (new Position (p.x, p.y + 1, p.z + 1));
		}

		if (! (p.y - 1 < 0)) {
			around.add (new Position (p.x, p.y - 1, p.z + 1));
		}

		ArrayList<Integer> toRemoveAround = new ArrayList<> ();

		for (int i = 0; i < path.size (); ++ i) {
			for (int j = 0; j < around.size (); ++ j) {
				if (around.get (j).equals (path.get (i))) {
					if (around.get (j).z < path.get (i).z) {
						toRemoveAround.add (j);
					} else {
						path.get (i).z = around.get (j).z;
					}
				}
			}
		}

		for (int i = 0; i < toRemoveAround.size (); ++ i) {
			around.remove (toRemoveAround.get (i) - i);
		}

		return around;
	}

	/**
	 * Retourne la premiere case dans la liste qui contient un coin ou une porte
	 * @param p
	 * @return
	 */
	public Position jackPot(ArrayList<Position> p) {
		return null;
	}
}
