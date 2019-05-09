import java.util.Scanner;

public class CoinCount {

	public static void main(String[] args) {

		int productPrice = 4320;
		Scanner scanner = new Scanner(System.in);
		System.out.print("금액을 지불해 주세요 : ");
		int money = scanner.nextInt();
		scanner.nextLine();
		int change = money - productPrice;
		
		if (change > 0) {
			System.out.println(change/500);
			change = change%500;
			System.out.println(change/100);
			change = change%100;
			System.out.println(change/50);
			change = change%50;
			System.out.println(change/10);
			change = change%10;
		} else if(change == 0){
			System.out.println("거스름 돈이 없습니다.");	
		} else {
			System.out.println("제품을 구매할 수 없어요.");
		}

	}

}
