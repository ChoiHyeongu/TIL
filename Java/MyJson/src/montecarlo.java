import java.util.Random;
import java.util.Scanner;

public class montecarlo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("몇 번 던지시겠습니까? ");
		int n = scanner.nextInt();
		double pi = montecarlo(n);
		
		System.out.println("결과 값 : " + pi);
	}
	
	static double montecarlo(int n) {
		
		Random rand = new Random();
		double x, y, pi;
		int cnt = 0, circle = 0;
		
		for(int i=0; i < n; i++) {
			x = rand.nextDouble() % 2.0;
			y = rand.nextDouble() % 2.0;
			cnt++;
			
			if((x*x)+(y*y) <= 1)
				circle++;
		}
		
		pi = (double)(4*circle) / (double)cnt;
	
		return pi;
	}
}
