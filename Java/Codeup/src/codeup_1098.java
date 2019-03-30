import java.util.Scanner;

public class codeup_1098 {

	static int[][] board = new int[100][100];

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int w, h, n, l = 0, d = 0, x = 0, y = 0;

		w = scanner.nextInt();
		h = scanner.nextInt();
		n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			l = scanner.nextInt();
			d = scanner.nextInt();
			x = scanner.nextInt();
			y = scanner.nextInt();

			if (d == 0)
				setVertical(l, x - 1, y - 1);
			else
				setHorizontal(l, x - 1, y - 1);
		}

		printBoard(w, h);
	}

	public static void setVertical(int l, int x, int y) {
		for (int i = 0; i < l; i++) {
			board[x][y++] = 1;
		}
	}

	static void setHorizontal(int l, int x, int y) {
		for (int i = 0; i < l; i++) {
			board[x++][y] = 1;
		}
	}

	static void printBoard(int w, int h) {
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
}
