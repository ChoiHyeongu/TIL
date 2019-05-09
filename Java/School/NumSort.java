
public class NumSort {

	public static void main(String[] args) {

		int max = 0;
		int[] array = { 1, 5, 3, 8, 2 };

		for (int i : array) {
			max = i > max ? i : max;
		}

		int min = max;

		for (int i : array) {
			min = i < min ? i : min;
		}


		System.out.println("Max : " + max);
		System.out.println("Min : " + min);
	}
}
