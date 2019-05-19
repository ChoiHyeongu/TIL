
public class Television {

	boolean isSupply = false;//
	boolean isPowerOn = false;//
	String inputType;//
	int volume = 0;//
	// String[] cableChannel = {"KBS1", "KBS2", "MBC", "SBS", "EBS"};
	int curChannel = 0;

	void supplyOn() {
		System.out.println("������ ���޵Ǿ����!");
		isSupply = true;
	}

	void supplyOff() {
		System.out.println("������ ���ܵǾ����!");
		isSupply = false;
		isPowerOn = false;
		inputType = null;
		curChannel = 0;
		volume = 0;
	}

	void powerOn() {
		if (isSupply) {
			isPowerOn = true;
			System.out.println("TV�� �������!");
		}

		else
			System.out.println("������ ���޵��� �ʾҾ���!");
	}

	void powerOff() {
		isPowerOn = false;
		System.out.println("TV�� �������!");
	}

	void setInputType(int type) {
		switch (type) {
		case 1:
			inputType = "��������̿���!";
			System.out.println("�ܺ��Է� : " + inputType);
			break;
		case 2:
			inputType = "���ͳ�Ƽ�񿡿�!";
			System.out.println("�ܺ��Է� : " + inputType);
			break;
		case 3:
			System.out.println("��ǻ�Ϳ� ����Ǿ����!");
			inputType = "HDMI-PC";
			System.out.println("�ܺ��Է� : " + inputType);
			break;
		default:
			break;
		}
	}

	void volumeUp() {
		if (volume <= 50)
			volume++;

		System.out.println("���� ���� : " + volume);
	}

	void volumeDown() {
		if (isPowerOn) {
			if (volume >= 0)
				volume--;

			System.out.println("���� ���� : " + volume);
		}
	}

	void setMute() {
		System.out.println("���Ұſ���!");
		volume = 0;
	}

	void setChannel(int channel) {
		switch (inputType) {
		case "��������̿���!":
			curChannel = channel;
			System.out.println("���� ä�� : " + curChannel);
			break;
		case "���ͳ�Ƽ�񿡿�!":
			if (0 < channel && channel < 1000) {
				curChannel = channel;
				System.out.println("���� ä�� : " + curChannel);
			}
		case "����Ƽ�񿡿�!":
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
			System.out.println("HDMI-PC ����!");
			break;
		}
	}

}