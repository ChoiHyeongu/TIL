package com.example.choi.samleparcelabel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 2016-12-13.
 */

public class SimpleData implements Parcelable {
    int number;


    String message;

    /**
     *
     *
     * @param num
     * @param msg
     */
    public SimpleData(int num, String msg) {
        number = num;
        message = msg;
    }

    /**
     *
     *
     * @param src
     */
    public SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Creator CREATOR = new Creator() {

        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }

    };


    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
