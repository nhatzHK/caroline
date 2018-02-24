package ca.hackermen.caroline;

import java.util.ArrayList;

public class PathFinder {
  
	ArrayList<Position> coins = new ArrayList<> ();
	ArrayList<Position> path  = new ArrayList<> ();
	Position            exit;
	Position            player;
<<<<<<< HEAD
	ArrayList<Position> coins;
<<<<<<< HEAD
	int foundCoins = 0;

	public PathFinder(char[][] map) {
=======
  char [][] mapMatrice;
  
	public PathFinder(String[][] map) {
    mapMatrice=map;
>>>>>>> 08ed1733c623ef7ee317d9b1dc93f60d0005acfa
=======
        char [][] mapMatrice;
  
	public PathFinder(char[][] map) {
                mapMatrice=map;
>>>>>>> master
		posCoins(coins,map);
		posExit();
		posPlayer();
	}

	/**
	 * Remplit l'array list avec les positions des coins
	 *
	 * @param
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
	 *
	 * @return
	 */
	public Position posExit () {
		Position position = new Position (0, 0);
                
                for (int i = 0; i <mapMatrice.length; i++)
                {
                    for (int j = 0; j <mapMatrice[i].length; j++) {
                        
                        if(mapMatrice[i][j]=='S')
                        {
                            position.x=j;
                            position.y=i;
                        }
                    }
            }


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
    
    
    public Position getNextPos() {
        Position pos;
        
        pos = path.get(0);
        path.remove(0);
        
        return pos;
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

		if (! (p.x + 1 > mapMatrice.length)) {
			around.add (new Position (p.x + 1, p.y, p.z + 1));
		}

		if (! (p.x - 1 < 0)) {
			around.add (new Position (p.x - 1, p.y, p.z + 1));
		}

		if (! (p.y + 1 > mapMatrice.length)) {
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
        
        public boolean validMove(Position init, Position finale) {
            boolean isOk = false;
            
            //mm ligne
            if(init.x == finale.x) {
                //vérifier si espace ou corde
                if (finale.c == ' ' || finale.c == '-' || finale.c == '$') {
                    isOk = true;
                }
                //vérifier si non bloc
                else if(finale.c == '@' || finale.c == '#') {
                    isOk = false;
                }
                
            }
            //mm colonne
            if(init.y == finale.y) {
                //finale est plus bas
                if(init.y > finale.y) 
                {
                    //ADD CODE TO FALL HERE...
                }
                //finale est plus haut
                else    
                {
                    //vérifier si espace ou corde
                    if (init.c == 'H' && (finale.c == 'H' || finale.c == ' ' || finale.c == '$' || finale.c == '-')) {
                        isOk = true;
                    }
                    else {
                        isOk = false;
                    }
                }
                
            }
            
            return isOk;
        }
}
