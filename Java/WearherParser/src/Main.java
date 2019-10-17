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
			System.out.println("오늘을 기준으로 앞으로 7일간의 날씨만 알 수 있습니다.");
			System.out.print("날짜를 선택하세요 : ");
			input = scanner.nextInt();
			
			if(Integer.toString(day) == day) {
				
			}
			
			weather.getWeekWeather(input);
		}
	}
}
