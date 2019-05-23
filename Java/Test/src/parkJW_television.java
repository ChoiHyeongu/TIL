import java.util.Scanner;

//10112 ¹ÚÁö¿ø


public class parkJW_television {

	public static void main(String[] args) {
		
		
		
		
		Television tv = new Television();
		
		
		tv.supplyOn();
		tv.powerOn();
		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();
		tv.setInputType(type);
		tv.volumeUp(); //1
		tv.volumeDown(); //0
		int channel = scanner.nextInt();
		tv.setChannel(channel);
		tv.setMute();
		tv.volumeUp(); //1
		tv.volumeUp(); //1
		tv.volumeUp(); //1
		tv.volumeUp(); //1
		tv.volumeUp(); //1
		tv.powerOff();
		System.out.println(tv.curChannel);
		System.out.println(tv.volume);
		System.out.println(tv.inputType);
		tv.supplyOff();
		System.out.println(tv.curChannel);
		System.out.println(tv.volume);
		System.out.println(tv.inputType);
	}
}