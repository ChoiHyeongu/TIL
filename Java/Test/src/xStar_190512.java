import java.util.Scanner;

public class xStar_190512 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		int n = 0;
		int m = input - 1;

		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input; j++) {
				if(j == n || j == m) 
					System.out.print(" * ");
				
				else 
					System.out.print(" ");
			}
			
			System.out.println();
			n++;
			m--;
		}
	}

}
