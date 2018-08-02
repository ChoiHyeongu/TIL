package com.example.choi.kakaotalk;

public class ChannelItem {
    private String HeadlineText;
    private int headlineImage;
    private String subText1;
    private String subImage1
    private String subText2;
    private String subImage2;

    public ChannelItem(String headlineText, int headlineImage, String subText1, String subImage1, String subText2, String subImage2) {
        HeadlineText = headlineText;
        this.headlineImage = headlineImage;
        this.subText1 = subText1;
        this.subImage1 = subImage1;
        this.subText2 = subText2;
        this.subImage2 = subImage2;
    }

    public String getHeadlineText() {
        return HeadlineText;
    }

    public void setHeadlineText(String headlineText) {
        HeadlineText = headlineText;
    }

    public int getHeadlineImage() {
        return headlineImage;
    }

    public void setHeadlineImage(int headlineImage) {
        this.headlineImage = headlineImage;
    }

    public String getSubText1() {
        return subText1;
    }

    public void setSubText1(String subText1) {
        this.subText1 = subText1;
    }

    public String getSubImage1() {
        return subImage1;
    }

    public void setSubImage1(String subImage1) {
        this.subImage1 = subImage1;
    }

    public String getSubText2() {
        return subText2;
    }

    public void setSubText2(String subText2) {
        this.subText2 = subText2;
    }

    public String getSubImage2() {
        return subImage2;
    }

    public void setSubImage2(String subImage2) {
        this.subImage2 = subImage2;
    }
}
