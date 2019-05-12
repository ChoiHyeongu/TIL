public class Television {

    boolean isSupply = false;
    boolean isPowerOn = false;
    String inputType;
    int volume = 0;
    int[] channelList;
    int curChannel = 0;

    void supplyOn() {
        System.out.println("전력 공급");
        isSupply = true;
    }

    void supplyOff() {
        System.out.println("공급 차단");
        isSupply = false;
        isPowerOn = false;
        inputType = null;
        volume = 0;
    }

    void powerOn() {
        if (isSupply){
            isPowerOn = true;
            System.out.println("TV가 켜졌습니다.");
        }

        else
            System.out.println("전력이 공급되지 않았습니다.");
    }

    void powerOff() {
        isPowerOn = false;
        System.out.println("TV가 꺼졌습니다.");
    }

    void setInputType(int type) {
        switch (type) {
            case 1:
                channelList = new int[5];
                inputType = "유선방송";
                System.out.println("외부입력 : " + inputType);
                break;
            case 2:
                channelList = new int[999];
                inputType = "인터넷티비";
                System.out.println("외부입력 : " + inputType);
                break;
            case 3:
                System.out.println("컴퓨터와 연결되었습니다.");
                inputType = "HDMI-PC";
                System.out.println("외부입력 : " + inputType);
                break;
            default:
                break;
        }
    }

    void volumeUp(){
        if(volume <=50)
            volume = volume++;

        System.out.println("현재 볼륨 : " + volume);
    }

    void volumeDown(){
        if(volume >=0)
            volume = volume--;

        System.out.println("현재 볼륨 : " + volume);
    }

    void setMute(){
        System.out.println("음소거");
        volume = 0;
    }

    void setChannel(int channel){
        switch (inputType){
            case "유선방송" :
                curChannel = channel;
                System.out.println("현재 채널 : " + curChannel);
                break;
            case "인터넷티비":
                if(channel < 1 || channel > 999){
                    curChannel = channel;
                    System.out.println("현재 채널 : " + curChannel);
                }
                break;
            default:
                System.out.println("HDMI-PC 입니다.");
                break;
        }
    }

}
