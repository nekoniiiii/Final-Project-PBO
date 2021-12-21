package files;

public class Level {
	
	public static int MAX_LEVEL = 5;
	public static int[][][] levels = new int[5][10][12];

	public static int[][] getLevel(int level){
		fillLevels();
		return levels[level];
	}
	
	public static void fillLevels() {
		levels[0] = level1;
		levels[1] = level2;
		levels[2] = level3;
		levels[3] = level4;
		levels[4] = level5;
	}
	
	private static int[][] level1 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, // teratas
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

	private static int[][] level2 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0},
										{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
										{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
										{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level3 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 2, 0, 0, 0, 2, 2, 0, 0, 0, 2, 0},
										{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
										{0, 0, 1, 1, 2, 2, 2, 2, 1, 1, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level4 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0},
										{0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
										{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
										{0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private static int[][] level5 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0},
										{0, 0, 0, 1, 2, 1, 1, 2, 1, 0, 0, 0},
										{0, 0, 1, 1, 2, 1, 1, 2, 1, 1, 0, 0},
										{0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
										{2, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 2},
										{0, 0, 0, 2, 0, 1, 1, 0, 2, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
										{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

}
