import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		int input = 1;
		
		SimpleDateFormat dayFormat = new SimpleDateFormat ("dd");
				
		Date time = new Date();
				
		String day = dayFormat.format(time);
				
		System.out.println(day);
		
		Weather weather = new Weather();
		weather.getCalender();
		
		Scanner scanner = new Scanner(System.in);
		
		while(input!=0) {
			System.out.println();
			System.out.println("������ �������� ������ 7�ϰ��� ������ �� �� �ֽ��ϴ�.");
			System.out.print("��¥�� �����ϼ��� : ");
			input = scanner.nextInt();
			
			if(Integer.toString(day) == day) {
				
			}
			
			weather.getWeekWeather(input);
		}
	}
}
