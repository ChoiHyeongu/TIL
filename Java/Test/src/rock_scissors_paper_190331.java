import java.util.Random;
import java.util.Scanner;

public class rock_scissors_paper_190331 {

	public static void main(String[] args) {

		final int ROCK = 1; //상수 값이 안바뀜 
		final int SCISSORS = 2;
		final int PAPER = 3;

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int yourWinCount = 0, comWinCount = 0;
		int yourInput, comInput;
		String result = ""; //Win Lose Draw game

		System.out.println("즐거운 가위! 바위! 보! 게임~");
		System.out.println("설명 : 사용자는 가위바위보를 낼 수 있습니다.");
		System.out.println("1은 가위, 2는 바위, 3은 보!!");
		System.out.println("그럼 10판을 먼저 이긴쪽이 승리입니다~");

		while (true) {
			comInput = random.nextInt(3) + 1;
			System.out.print("용자여 선택하세요~(1.가위/2.바위/3.보)>>");
			yourInput = scanner.nextInt();

			if (yourInput < 1 || yourInput > 3) {
				System.out.println("ㅡㅡ;; 1~3번만 입력하라니깐요.");
				continue;
			}

			if (yourInput == comInput) {
				result = "Draw Game";
			} else if (yourInput == ROCK && comInput == SCISSORS 
					|| yourInput == SCISSORS && comInput == PAPER
					|| yourInput == PAPER && comInput == ROCK) {

				result = "Your Win ";
				yourWinCount++;
			} else {
				result = "Your Lose";
				comWinCount++;
			}
			
			System.out.println(yourInput+", "+comInput);

			System.out.println("┌─────────────────────────────┐");
			System.out.println("│          " + result + "          │");
			System.out.println("├──────┬──────────────────────┤");
			System.out.printf("│RESULT│ User:%2dWIN, COM:%2dWIN│\n", yourWinCount, comWinCount);
			System.out.println("└──────┴──────────────────────┘");

			if (yourWinCount >= 10) {
				System.out.println("사용자의 압승으로 게임에서 최종 우승하였습니다.");
				break;
			} else if (comWinCount >= 10) {
				System.out.println("다음에 또 다시 도전하세요ㅜㅜ...");
				break;
			}
		}
	}
}
