import java.util.Random;

public class parkJW_matrixArray {
	  public static void main(String[] args) {

	        int[][] array1 = new int[4][4]; // ù��° []�� ���� ��Ÿ����, �ι�°[]�� ���� ��Ÿ����.
	        int[][] array2 = new int[4][4]; // ù��° []�� ���� ��Ÿ����, �ι�°[]�� ���� ��Ÿ����.
	        int[][] array3 = new int[4][4]; // ù��° []�� ���� ��Ÿ����, �ι�°[]�� ���� ��Ÿ����.
	        int[][] array4 = new int[4][4]; // ù��° []�� ���� ��Ÿ����, �ι�°[]�� ���� ��Ÿ����.

	        Random random = new Random();

	        System.out.println("���� �迭 ������");

	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array1[i][j] = random.nextInt(100) + 1;
	                array2[i][j] = random.nextInt(100) + 1;

	                System.out.printf("[%3d]", array1[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("���� �迭 ������");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                System.out.printf("[%3d]", array2[i][j]);
	            }
	            System.out.println();
	        }
	        System.out.println("===================");
	        System.out.println("������ ��");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array3[i][j] = array1[i][j] + array2[i][j];//���ϱ�
	                System.out.printf("[%3d]", array3[i][j]);//���
	            }
	            System.out.println();
	        }
	        System.out.println("������ ��");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {

	                array4[i][j] = array1[i][j] - array2[i][j];//����
	                System.out.printf("[%3d]", array4[i][j]);//���
	            }
	            System.out.println();
	        }
	    }
}
