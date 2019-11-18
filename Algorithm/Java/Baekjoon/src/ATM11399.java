import java.util.Arrays;
import java.util.Scanner;

public class ATM11399 {

    public static void main(String[] args) {
        int[] time = new int[1000];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            time[i] = scanner.nextInt();
        }

        Arrays.sort(time,0,n);

        int sum = 0;
        int time_sum = 0;
        for (int i = 0; i < n; i++) {
            sum += time[i];
            time_sum += sum;
        }

        System.out.print(time_sum);
    }
}