
public class Television {

	boolean isSupply = false;//
	boolean isPowerOn = false;//
	String inputType;//
	int volume = 0;//
	// String[] cableChannel = {"KBS1", "KBS2", "MBC", "SBS", "EBS"};
	int curChannel = 0;

	void supplyOn() {
		System.out.println("전력이 공급되었어요!");
		isSupply = true;
	}

	void supplyOff() {
		System.out.println("공급이 차단되었어요!");
		isSupply = false;
		isPowerOn = false;
		inputType = null;
		curChannel = 0;
		volume = 0;
	}

	void powerOn() {
		if (isSupply) {
			isPowerOn = true;
			System.out.println("TV가 켜졌어요!");
		}

		else
			System.out.println("전력이 공급되지 않았어요ㅠ!");
	}

	void powerOff() {
		isPowerOn = false;
		System.out.println("TV가 꺼졌어요!");
	}

	void setInputType(int type) {
		switch (type) {
		case 1:
			inputType = "유선방송이에요!";
			System.out.println("외부입력 : " + inputType);
			break;
		case 2:
			inputType = "인터넷티비에요!";
			System.out.println("외부입력 : " + inputType);
			break;
		case 3:
			System.out.println("컴퓨터와 연결되었어요!");
			inputType = "HDMI-PC";
			System.out.println("외부입력 : " + inputType);
			break;
		default:
			break;
		}
	}

	void volumeUp() {
		if (volume <= 50)
			volume++;

		System.out.println("현재 볼륨 : " + volume);
	}

	void volumeDown() {
		if (isPowerOn) {
			if (volume >= 0)
				volume--;

			System.out.println("현재 볼륨 : " + volume);
		}
	}

	void setMute() {
		System.out.println("음소거에요!");
		volume = 0;
	}

	void setChannel(int channel) {
		switch (inputType) {
		case "유선방송이에요!":
			curChannel = channel;
			System.out.println("현재 채널 : " + curChannel);
			break;
		case "인터넷티비에요!":
			if (0 < channel && channel < 1000) {
				curChannel = channel;
				System.out.println("현재 채널 : " + curChannel);
			}
		case "유선티비에요!":
			if (isPowerOn) {
				switch (channel) {
				case 6:
					curChannel = 6;
					System.out.println("SBS");
					break;
				case 7:
					curChannel = 7;
					System.out.println("KBS2");
					break;
				case 9:
					curChannel = 9;
					System.out.println("KBS1");
					break;
				case 11:
					curChannel = 11;
					System.out.println("MBC");
					break;
				case 13:
					curChannel = 13;
					System.out.println("EBS");
					break;
				}
			}
			break;
		default:
			System.out.println("HDMI-PC 에요!");
			break;
		}
	}

}