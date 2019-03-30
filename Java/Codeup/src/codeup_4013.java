import java.util.Scanner;

public class codeup_4013 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] binary = new int[1000];
		
		int n = scanner.nextInt();
		int quotient = 0;
		int remainder = 0;
		int cnt = 0;
		
		while(n >= 2) {
			n = n/2;
			remainder = n%2;
			System.out.println(remainder);
		}
		
		
	}
}
