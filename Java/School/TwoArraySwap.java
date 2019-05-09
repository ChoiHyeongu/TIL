
public class TwoArraySwap {

	public static void main(String[] args) {

		int matrix[][] = { 
				{ 0, 0, 0, 0 },
				{ 1, 0, 0, 0 }, 
				{ 1, 1, 0, 0 }, 
				{ 1, 1, 1, 0 } 
				};

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				if(j!=matrix[i].length - 1) 
					System.out.print(",");
			}
			System.out.println();
		}
		
		System.out.println();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[j][i]);
				if(j!=matrix[i].length - 1) 
					System.out.print(",");
			}
			System.out.println();
		}
	}

}
