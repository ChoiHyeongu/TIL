import java.util.Random;

public class MatrixArray {

	public static void main(String[] args) {

		int[][] arr1 = new int[4][4];
		int[][] arr2 = new int[4][4];
		int[][] sum = new int[4][4];
		int[][] subtract = new int[4][4];

		Random random = new Random();

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				arr1[i][j] = random.nextInt(100) + 1;
				arr2[i][j] = random.nextInt(100) + 1;
			}
		}

		System.out.println("원본 배열 데이터");

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				System.out.printf("[%3d] ", arr1[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.printf("[%3d] ", arr2[i][j]);
			}
			System.out.println();
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				sum[i][j] = arr1[i][j] + arr2[i][j];
				subtract[i][j] = arr1[i][j] - arr2[i][j];
			}
		}
		
		System.out.println("=======================");
		System.out.println("원소의 합");

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				System.out.printf("[%3d] ", sum[i][j]);
			}
			System.out.println();
		}

		System.out.println("원소의 차");

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				System.out.printf("[%3d] ", subtract[i][j]);
			}
			System.out.println();
		}
	}
}
