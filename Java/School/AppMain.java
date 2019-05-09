
public class AppMain {

	public static void main(String[] args) {

		int[] scores = { 95, 71, 84, 93, 87 };
		int sum = 0, max = 0;

		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("점수 총합 : " + sum);

		sum = 0;

		for (int i : scores) {
			sum += i;
		}
		
		System.out.println("점수 총합 : " + sum);
		
		for (int i : scores) {
			max = i > max ? i : max;
		}
		
		System.out.println("최대값 : " + max);
	}
}
