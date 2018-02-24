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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    
        
        
        
}
