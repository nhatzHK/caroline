package ca.hackermen.caroline.sim;

import ca.umontreal.iro.hackathon.loderunner.Move;

public abstract class Carunner {

	protected int      level;
	protected Pos      player;
	protected String[] map;
	public Carunner (int level) {
		this.level = level;
		player = Levels.getPlayerInit (level);
		map = Levels.getMap (level);
	}

	private void move (int direction) {
		switch (direction) {
			case 1:
				player.y += 1;
				break;
			case 2:
				player.x -= 1;
				break;
			case 3:
				player.y -= 1;
				break;
			case 4:
				player.x += 1;
				break;
		}
	}

	public void run () {
		start (map);
		Move next = this.next (player.x, player.y);
		while (next != null){
			move (next.direction.getValue ());
		}
	}

	public abstract Move next (int x, int y);

	public abstract void start (String[] grid);

	static class Pos {

		int x;
		int y;

		public Pos (int a, int b) {
			x = a;
			y = b;
		}
	}
}
