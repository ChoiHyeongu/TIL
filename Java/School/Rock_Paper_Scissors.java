import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {

	public static void main(String[] args) {

		final int SCISSORS = 1;
		final int ROCK = 2;
		final int PAPER = 3;

		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.>>");

		Random random = new Random();

		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt();
		int com = random.nextInt(3) + 1;

		System.out.println("당신은 " + user + "입니다.");
		System.out.println("컴은 " + com + "입니다.");

//		if (user == com) {
//			System.out.println("비겼습니다.");
//		} else if (user == ROCK && com == SCISSORS 
//				|| user == SCISSORS && com == PAPER
//				|| user == PAPER && com == ROCK) {
//			System.out.println("당신이 이겼습니다.");
//		} else {
//			System.out.println("컴이 이겼습니다.");
//		}

		switch (user - com) {
		case 0:
			System.out.println("비겼습니다.");
			break;
		case -2: case 1:
			System.out.println("당신이 이겼습니다.");
			break;
		case 2: case -1:
			System.out.println("컴이 이겼습니다.");
			break;
		}
	}

}
