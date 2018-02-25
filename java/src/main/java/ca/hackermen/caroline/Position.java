package ca.hackermen.caroline;

public class Position {
	public int x, y, z;
	public char c;

	public Position(int x, int y, int z, char c) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.c = c;
	}

	@Override
	public boolean equals(Object p) {
		Position pos = (Position) p;
		return pos.x == x && pos.y == y;
	}

	public static Position[][] createMap(char[][] symbols) {
		Position[][] map = new Position[symbols.length][symbols[0].length];
		for (int i = 0; i < symbols.length; ++i) {
			for (int j = 0; j < symbols[0].length; ++j) {
				map[i][j] = new Position (j, i, Integer.MAX_VALUE,
				                          symbols[i][j]);
			}
		}
		return map;
	}
        
}
