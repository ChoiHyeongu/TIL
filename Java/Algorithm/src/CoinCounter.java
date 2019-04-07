import java.util.Scanner;

public class CoinCounter {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		int ocheon = 0, cheon = 0, obeak = 0, beak = 0;
		int arr[] = { 5000, 1000, 500, 100 };

		ocheon = money / 5000;
		cheon = money % 5000 / 1000;
		obeak = money % 5000 % 1000 / 500;
		beak = money % 5000 % 1000 % 500 / 100;

		System.out.println("��õ�� : " + ocheon);
		System.out.println("õ�� : " + cheon);
		System.out.println("����� : " + obeak);
		System.out.println("��� : " + beak);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+"��: "+money/arr[i]);
			money%=arr[i];
		}

	}

}
