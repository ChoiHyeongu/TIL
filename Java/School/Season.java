import java.util.Scanner;

public class Season {

	public static void main(String[] args) {

		System.out.print("현재 월을 입력하세요.(숫자)>> ");
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();

		switch (month) {
		case 1: case 2: case 3:
			System.out.println("현재 계졀은 봄입니다.");
			break;
		case 4: case 5: case 6:
			System.out.println("현재 계졀은 여름입니다.");
			break;
		case 7: case 8: case 9:
			System.out.println("현재 계졀은 가을입니다.");
			break;
		case 10: case 11: case 12:
			System.out.println("현재 계졀은 겨울입니다.");
			break;
		default:
			break;
		}

	}

}
