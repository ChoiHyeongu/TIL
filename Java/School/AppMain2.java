import java.util.Scanner;

public class AppMain2 {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.powerOn();
		System.out.println("계산기");
		System.out.println("1:덧셈 2:곱셈");

		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println("첫번째 숫자.");
		int input1 = scanner.nextInt();
		System.out.println("두번째 숫자.");
		int input2 = scanner.nextInt();

		switch (num) {
		case 1:
			int plus = cal.plus(input1, input2);
			System.out.println(plus);
			break;
		case 2:
			int mul = cal.mul(input1, input2);
			System.out.println(mul);
			break;
		default:
			break;
		}
		
		scanner.close();
		
		cal.powerOff();
	}
}
