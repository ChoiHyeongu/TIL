import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coin11047 {

    public static void main(String[] args) {

        Integer[] coin = new Integer[10];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            coin[i] = scanner.nextInt();
        }

        Arrays.sort(coin, Collections.reverseOrder());

        for (int i = 0; i < coin.length; i++) {
            cnt += k/coin[i];
            k %= coin[i];
        }

        System.out.println(cnt);
    }
}
