import java.util.Scanner;

public class ScoreTable {

	public static void main(String[] args) {

		String scoreTable[][] = new String[5][8];
		int sum = 0, average = 0, choice = 0, cnt = 0;
		String grade;

		Scanner scanner = new Scanner(System.in);

		while (choice != 4) {
			System.out.println("[�Է�����] 1.�����Է�  2.����ó�� 3.����ǥȮ�� 4.���α׷� ����");
			System.out.print("[�����ȣ �Է� 1~4] : ");

			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if(cnt >= 5) {
					System.out.println("�л� �����͸� �߰����� ���մϴ�.");
					System.out.println("����ó���� �Ͻñ� �ٶ��ϴ�.");
					System.out.println();
					continue;
				}
				
				System.out.print((cnt+1)+"��° �л��� �̸��� �Է��ϼ��� : ");
				scoreTable[cnt][0] = scanner.next();
				System.out.print((cnt+1)+"��° �л��� ���������� �Է��ϼ��� : ");
				scoreTable[cnt][1] = scanner.next();
				System.out.print((cnt+1)+"��° �л��� ���������� �Է��ϼ��� : ");
				scoreTable[cnt][2] = scanner.next();
				System.out.print((cnt+1)+"��° �л��� ���������� �Է��ϼ��� : ");
				scoreTable[cnt][3] = scanner.next();
				System.out.print((cnt+1)+"��° �л��� ���������� �Է��ϼ��� : ");
				scoreTable[cnt][4] = scanner.next();
				cnt++;
				System.out.println();
				break;
			case 2:
				if(cnt < 5) {
					System.out.println("��� �ڷᰡ �Էµ��� �ʾ� ����ó���� �� �� �����ϴ�.");
					System.out.println("��� ������ �Է��Ͻñ� �ٶ��ϴ�.");
					System.out.println();
					continue;
				}
				
				System.out.println("(--)(__)(--)(__)(--)(__)(--)(__)(--)(__)(--)(__)");
				for (int i = 0; i < scoreTable.length; i++) {
					for (int j = 1; j < scoreTable[i].length - 3; j++) {
						sum += Integer.parseInt(scoreTable[i][j]);
					}
					average = sum / 4;
					if (average >= 90)
						grade = "1���";
					else if (average >= 80)
						grade = "2���";
					else if (average >= 70)
						grade = "3���";
					else if (average >= 60)
						grade = "4���";
					else if (average >= 50)
						grade = "5���";
					else if (average >= 40)
						grade = "6���";
					else if (average >= 30)
						grade = "7���";
					else if (average >= 20)
						grade = "8���";
					else
						grade = "9���";

					scoreTable[i][5] = String.valueOf(sum);
					scoreTable[i][6] = String.valueOf(average);
					scoreTable[i][7] = String.valueOf(grade);

					sum = 0;
				}
				System.out.println("����ó���� �Ϸ� �Ǿ����ϴ�^^ ����� Ȯ���ϼ���");
				break;
			case 3:
				System.out.println("================================================================");
				System.out.println("�л���\t����\t����\t����\t����\t����\t���\t���");
				System.out.println("================================================================");
				for (int i = 0; i < scoreTable.length; i++) {
					for (int j = 0; j < scoreTable[i].length; j++) {
						System.out.printf("%3s\t",scoreTable[i][j]);
					}
					System.out.println();
					System.out.println();
				}
				break;
			case 4:
				System.out.println("�����ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("ERROR : �ǹٸ� ó�� ���ڸ� �Է��Ͻñ� �ٶ��ϴ�.");
				System.out.println();
				break;
			}
		}
	}
}
