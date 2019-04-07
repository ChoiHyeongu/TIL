import java.util.Scanner;

public class codeup_1097 {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[19][19];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		int n = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			for (int j = 0; j < 19; j++) {
				if (arr[x - 1][j] == 0) {
					arr[x - 1][j] = 1;
				} else {
					arr[x - 1][j] = 0;
				}
			}

			for (int j = 0; j < 19; j++) {
				if (arr[j][y - 1] == 0) {
					arr[j][y - 1] = 1;
				} else {
					arr[j][y - 1] = 0;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
