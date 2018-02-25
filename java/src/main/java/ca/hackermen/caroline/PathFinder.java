package ca.hackermen.caroline;

import java.util.ArrayList;
import java.util.Iterator;
import static java.lang.Math.min;

public class PathFinder {

	public Position[][] mapMatrice;
	ArrayList<Position> goals = new ArrayList<> ();
	ArrayList<Position> path  = new ArrayList<> ();
	Position player;

	public PathFinder (char[][] map) {
		mapMatrice = Position.createMap (map);
		goals.add (posExit ());
		goals.addAll (getGoals ());
		player = posPlayer ();
	}

	/**
	 * Remplit l'array list avec les positions des coins
	 *
	 * @param
	 */
	public ArrayList<Position> getGoals () {
		ArrayList<Position> gls = new ArrayList<> ();
		for (int i = 0; i < mapMatrice.length; i++) {
			for (int j = 0; j < mapMatrice[i].length; j++) {
				if (mapMatrice[i][j].c == '$') {
					gls.add (mapMatrice[i][j]);
				}
			}
		}

		return gls;
	}


	/**
	 * Return la position de la porte sur la map
	 *
	 * @return
	 */
	public Position posExit () {
		Position exit = null;
		boolean  done = false;

		for (int i = 0; i < mapMatrice.length; i++) {
			for (int j = 0; j < mapMatrice[i].length; j++) {
				if (mapMatrice[i][j].c == 'S') {
					exit = mapMatrice[i][j];
					done = true;
					break;
				}
			}

			if (done) {
				break;
			}
		}

		return exit;
	}

	/**
	 * Return la position du player
	 *
	 * @return
	 */
	public Position posPlayer () {
		boolean  done   = false;
		Position player = null;

		for (int i = 0; i < mapMatrice.length; i++) {
			for (int j = 0; j < mapMatrice[i].length; j++) {
				if (mapMatrice[i][j].c == '&') {
					player = mapMatrice[i][j];
					done = true;
					break;
				}
			}

			if (done) {
				break;
			}
		}

		return player;
	}

	public Position getNextPos (int x, int y) {
		player = mapMatrice[y][x];
		System.out.println ("Player: " + player.z);
		System.out.println ("x - 1: " + mapMatrice[player.y][player.x - 1].z);

		if (player.x > 0 && mapMatrice[player.y][player.x - 1].z == 1) {
			player.x++;
			return mapMatrice[player.y][player.x];
		}

		if (player.x < mapMatrice[0].length - 1 &&
		    mapMatrice[player.y][player.x + 1].z - player.z == 1)
		{
			player.x--;
			return mapMatrice[player.y][player.x];
		}

		return null;
	}

	public void createPath () {

		//clearZ();

		path.clear ();


		Position goal = goals.get (goals.size () - 1);
		goal.z = 0;
		path.add (goal);
		System.out.println ("Goal: " + goal.x + ", " + goal.y + ", " + goal.z);

		for (int i = 0; i < path.size (); ++ i) {
			printMap ();
			ArrayList<Position> branches = getBranches (path.get (i));

			for (Position p : branches) {
				System.out.println (p.x + ", " + p.y + ", " + p.z);
			}

			if (foundPlayer (branches)) {
				break;
			} else {
				path.addAll (branches);
			}
		}
	}

	/**
	 * Renovie une liste des directions possibles a partir de la position
	 * actuelle
	 *
	 * @param current
	 *
	 * @return
	 */
	public ArrayList<Position> getBranches (Position current) {

		ArrayList<Position> around = new ArrayList<> ();
		if (current.y + 1 < mapMatrice.length) {
			around.add (mapMatrice[current.y + 1][current.x]);
			around.get (around.size () - 1).z = min(current.z + 1,
			                                        mapMatrice[current.y +
			                                                   1][current.x].z);
		}

		if (current.y - 1 > 0) {
			around.add (mapMatrice[current.y - 1][current.x]);
			around.get (around.size () - 1).z = min(current.z + 1,
			                                        mapMatrice[current.y -
			                                                   1][current.x].z);
		}

		if (current.x + 1 < mapMatrice[0].length) {
			around.add (mapMatrice[current.y][current.x + 1]);
			around.get (around.size () - 1).z = min(current.z + 1,
			                                        mapMatrice[current.y][current.x + 1].z);
		}

		if (current.x - 1 > 0) {
			around.add (mapMatrice[current.y][current.x - 1]);
			around.get (around.size () - 1).z = min(current.z + 1,
			                                        mapMatrice[current
				                                        .y][current.x - 1].z);
		}

		for (Position pos : path) {
			Iterator<Position> itPos = around.iterator ();
			//boolean done = false;

			while (itPos.hasNext ()) {
				Position p = itPos.next ();
				if (! validMove (current, p)) {
					itPos.remove ();
				} else if (p.equals (pos)) {
					mapMatrice[pos.y][pos.x].z = min (pos.z, p.z);
					itPos.remove ();
				}
			}
		}

		return around;
	}

	public boolean validMove (Position init, Position finale) {
		boolean isOk = false;
		//mm ligne
		if (init.x == finale.x) {
			//vérifier si espace ou corde
			if (finale.c == ' ' || finale.c == '-' || finale.c == '$') {
				isOk = true;
			}
			//vérifier si non bloc
			else if (finale.c == '@' || finale.c == '#') {
				isOk = false;
			}
		}
		//mm colonne
		if (init.y == finale.y) {
			//finale est plus bas
			if (init.y > finale.y) {
				//ADD CODE TO FALL HERE...
                                
                                if (finale.c == '#' || finale.c == '@') {
                                    isOk = false;
                                }
			}
			//finale est plus haut
			else {
				//vérifier si espace ou corde
				if (init.c == 'H' &&
				    (finale.c == 'H' || finale.c == ' ' || finale.c == '$' ||
				     finale.c == '-'))
				{
					isOk = true;
				} else {
					isOk = false;
				}
			}
		}

		return isOk;
	}

	public boolean foundPlayer (ArrayList<Position> branches) {
		System.out.println ("Called");
		for (Position branch : branches) {
			if (player.x == branch.x && player.y == branch.y) {
				System.out.println ("found");
				return true;
			}
		}

		return false;
	}

	public void printMap () {
		for (int i = 0; i < mapMatrice.length; ++ i) {
			for (int j = 0; j < mapMatrice[i].length; ++ j) {
				System.out.print (mapMatrice[i][j].z != Integer.MAX_VALUE ?
				                  mapMatrice[i][j].z + " " :
				                  "e ");
			}
			System.out.println ();
		}
	}

	public void clearZMap () {
		for (int i = 0; i < mapMatrice.length; i++) {
			for (int j = 0; j < mapMatrice[i].length; j++) {
				mapMatrice[i][j].z = Integer.MAX_VALUE;
			}
		}
	}
}
