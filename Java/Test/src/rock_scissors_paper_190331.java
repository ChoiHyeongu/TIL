import java.util.Random;
import java.util.Scanner;

public class rock_scissors_paper_190331 {

	public static void main(String[] args) {

		final int ROCK = 1;
		final int SCISSORS = 2;
		final int PAPER = 3;

		Random random = new Random();
		Scanner scanner = new Scanner(System.in);

		int yourWinCount = 0, comWinCount = 0;
		int yourInput, comInput;
		String result = "";

		System.out.println("��ſ� ����! ����! ��! ����~");
		System.out.println("���� : ����ڴ� ������������ �� �� �ֽ��ϴ�.");
		System.out.println("1�� ����, 2�� ����, 3�� ��!!");
		System.out.println("�׷� 10���� ���� �̱����� �¸��Դϴ�~");

		while (true) {
			comInput = random.nextInt(3) + 1;
			System.out.print("���ڿ� �����ϼ���~(1.����/2.����/3.��)>>");
			yourInput = scanner.nextInt();

			if (yourInput < 0 || yourInput > 3) {
				System.out.println("�Ѥ�;; 1~3���� �Է��϶�ϱ��.");
				continue;
			}

			if (yourInput == ROCK) {
				if (comInput == SCISSORS) {
					result = "Your WIN ";
					yourWinCount++;
				} else if (comInput == PAPER) {
					result = "Your LOSE";
					comWinCount++;
				} else {
					result = "Draw Game";
				}
			} else if (yourInput == SCISSORS) {
				if (comInput == PAPER) {
					result = "Your WIN ";
					yourWinCount++;
				} else if (comInput == ROCK) {
					result = "Your LOSE";
					comWinCount++;
				} else {
					result = "Draw Game";
				}
			} else // yourInput == PAPER{
			if (comInput == ROCK) {
				result = "Your WIN ";
				yourWinCount++;
			} else if (comInput == SCISSORS) {
				result = "Your LOSE";
				comWinCount++;
			} else {
				result = "Draw Game";
			}

			System.out.println("��������������������������������������������������������������");
			System.out.println("��          " + result + "          ��");
			System.out.println("��������������������������������������������������������������");
			System.out.printf("��RESULT�� User:%2dWIN, COM:%2dWIN��\n", yourWinCount, comWinCount);
			System.out.println("��������������������������������������������������������������");

			if (yourWinCount >= 10) {
				System.out.println("������� �н����� ���ӿ��� ���� ����Ͽ����ϴ�.");
				break;
			} else if (comWinCount >= 10) {
				System.out.println("������ �� �ٽ� �����ϼ���̤�...");
				break;
			}
		}
	}
}
