
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DataSort {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("소팅 처리할 데이터의 개수를 입력하세요 : ");
		int n = scanner.nextInt();
		Integer[] sortArr = new Integer[n];

		for (int i = 0; i < n; i++) {
			System.out.print("소팅 처리할 데이터를 입력하세요 : ");
			sortArr[i] = scanner.nextInt();
		}

		System.out.print("소트 전 : ");
		for (int i = 0; i < n; i++) {
			System.out.print(sortArr[i]+" ");
		}
		System.out.println();

		System.out.print("소트 후(오름차순) : ");
		Arrays.sort(sortArr);
		for (int i = 0; i < n; i++) {
			System.out.print(sortArr[i] + " ");
		}
		System.out.println();

		System.out.print("소트 후(내림차순) : ");
		Arrays.sort(sortArr, Collections.reverseOrder());
		for(int i=0;i<sortArr.length;i++) {
			System.out.print(sortArr[i]+" ");
		}

	}
}
