import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int input = 1;
		
		Weather weather = new Weather();
		weather.getCalender();
		
		Scanner scanner = new Scanner(System.in);
		
		while(input!=0) {
			System.out.println();
			System.out.println("������ �������� ������ 7�ϰ��� ������ �� �� �ֽ��ϴ�.");
			System.out.print("��¥�� �����ϼ��� : ");
			input = scanner.nextInt();
			weather.getWeather(input);
		}
	}
}
