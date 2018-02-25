package ca.hackermen.caroline.sim;

public enum Levels {
	A(1);

	public int level;
	Levels(int i) {
		level = i;
	}

	public static String[] getMap(int i) {
		switch (i) {
			case 1:
				return new String[] {
					"                             ",
					"                             ",
					"                             ",
					"                             ",
					"&    $         $           $ ",
					"#############################"
				};
		}

		return null;
	}

	public static Carunner.Pos getPlayerInit(int i) {
		switch (i) {
			case 1:
				return new Carunner.Pos (0, 4);
		}

		return null;
	}
}
