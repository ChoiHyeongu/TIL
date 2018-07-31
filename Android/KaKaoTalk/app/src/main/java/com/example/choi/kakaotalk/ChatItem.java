package com.example.choi.kakaotalk;

public class ChatItem {

    private int roomImage;
    private String roomName;
    private String  curMessage;
    private int numberOfPeople;
    private String curMessageTime;

    public int getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(int roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getCurMessage() {
        return curMessage;
    }

    public void setCurMessage(String curMessage) {
        this.curMessage = curMessage;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getCurMessageTime() {
        return curMessageTime;
    }

    public void setCurMessageTime(String curMessageTime) {
        this.curMessageTime = curMessageTime;
    }

    public ChatItem(int roomImage, String roomName, String curMessage, int numberOfPeople, String curMessageTime) {
        this.roomImage = roomImage;
        this.roomName = roomName;
        this.curMessage = curMessage;
        this.numberOfPeople = numberOfPeople;
        this.curMessageTime = curMessageTime;
    }
}
