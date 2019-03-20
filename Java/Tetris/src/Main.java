import java.util.Random;

public class Main {

	public static void main(String[] args) {

		int i = 0;
		boolean survive = true;

		Random random = new Random();
	
		while (i < 10) {
			int getBlockValue = random.nextInt(7);
			Map.printBlock(getBlockValue);
			i++;
		}
	}
}
