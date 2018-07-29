package com.example.choi.kakaotalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FriendItemView extends LinearLayout {

    ImageView imageView;
    TextView nameView;
    TextView moodView;

    public FriendItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.profile_item, this, true);

        imageView = (ImageView) findViewById(R.id.profileImage);
        nameView  = (TextView) findViewById(R.id.profileName);
        moodView  = (TextView) findViewById(R.id.profileMood);
    }


    public void setProfileImage(int resId) {
        imageView .setImageResource(resId);
    }

    public void setProfileName(String name) {
        nameView.setText(name);
    }

    public void setProfileMood(String mood) {
        moodView.setText(mood);
    }
}
