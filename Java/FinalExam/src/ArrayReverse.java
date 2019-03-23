public class ArrayReverse {

	public static void main(String[] args) {
	
		int[][] arr = new int[][] {
			{0,0,0,0,1},
			{0,0,0,1,1},
			{0,0,1,1,1},
			{0,1,1,1,1},
			{1,1,1,1,1},
		};
		
		for (int i = arr.length - 1; i >= 0; i--) {
			for(int j = arr[i].length - 1; j >= 0; j--) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}

}
