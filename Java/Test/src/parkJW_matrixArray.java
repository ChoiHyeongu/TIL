import java.util.Random;

public class parkJW_matrixArray {
	  public static void main(String[] args) {

	        int[][] array1 = new int[4][4]; // 첫번째 []는 행을 나타내고, 두번째[]는 열을 나타낸다.
	        int[][] array2 = new int[4][4]; // 첫번째 []는 행을 나타내고, 두번째[]는 열을 나타낸다.
	        int[][] array3 = new int[4][4]; // 첫번째 []는 행을 나타내고, 두번째[]는 열을 나타낸다.
	        int[][] array4 = new int[4][4]; // 첫번째 []는 행을 나타내고, 두번째[]는 열을 나타낸다.

	        Random random = new Random();

	        System.out.println("원본 배열 데이터");

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array1[i][j] = random.nextInt(100) + 1;
	                array2[i][j] = random.nextInt(100) + 1;

	                System.out.printf("[%3d]", array1[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("원본 배열 데이터");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                System.out.printf("[%3d]", array2[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("===================");
	        System.out.println("원소의 합");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array3[i][j] = array1[i][j] + array2[i][j];//더하기
	                System.out.printf("[%3d]", array3[i][j]);//출력
	            }
	            System.out.println();
	        }
	        System.out.println("원소의 차");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array4[i][j] = array1[i][j] - array2[i][j];//뺴고
	                System.out.printf("[%3d]", array4[i][j]);//출력
	            }
	            System.out.println();
	        }
	    }
}
