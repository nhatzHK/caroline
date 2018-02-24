package ca.hackermen.caroline;

public class Position {
	int x, y, z;
	char c = ' ';

	public Position(int x, int y) {
		this(x, y, 0);
	}

	public Position(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public boolean equals(Object p) {
		Position pos = (Position) p;
		return pos.x == x && pos.y == y;
	}
}
