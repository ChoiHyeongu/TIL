import java.util.Scanner;

public class codeup_4013 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[1000];

		int n = scanner.nextInt();
		int cal_n = n ;
		int remainder = 0;
		int cnt = 0;

		while (cal_n >= 2) {
			remainder = cal_n % 2;
			cal_n = cal_n / 2;
			arr[cnt++] = remainder;
		}

		arr[cnt++] = cal_n;
		
		for (int i = cnt-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		
		System.out.println();
		
		
		cal_n = n;
		cnt = 0;

		while (cal_n >= 8) {
			remainder = cal_n % 8;x
			cal_n = cal_n / 8;
			arr[cnt++] = remainder;
		}
		
		arr[cnt++] = remainder;

		for (int i = cnt-1; i >= 0; i--) {
			System.out.print(arr[i]);
		}

	}
}
