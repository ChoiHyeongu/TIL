
public class Map {

	private static final int ROW = 23;
	private static final int COL = 15;

	private static int[][] map = new int[ROW][COL];

	static {
		for (int i = 0; i < ROW; i++) {
			map[i][0] = 1;
			map[i][COL - 1] = 1;
		}

		for (int i = 0; i < COL; i++) {
			map[ROW - 1][i] = 1;
		}
	}

	public static void drawMap() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == 1) {
					System.out.print("бс");
				} else {
					System.out.print("бр");
				}
			}
			System.out.println();
		}
	}
	
	public static void printBlock(int block) {
		System.out.println(block);
	}

	public static void moveBlock() {

	}

	public static void moveLeft() {

	}

	public static void moveRight() {

	}
}
