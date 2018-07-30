package com.example.choi.kakaotalk;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileListAdapter extends BaseAdapter {

    Context context;
    ArrayList<ProfileItem> profileItemArrayList;

    ImageView profileImageView;
    TextView nameTextView;
    TextView moodTextView;

    public ProfileListAdapter(Context context, ArrayList<ProfileItem> profileItemArrayList) {
        this.context = context;
        this.profileItemArrayList = profileItemArrayList;
    }

    @Override
    public int getCount() {
        return this.profileItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return profileItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.profile_item, null);

            profileImageView = (ImageView) convertView.findViewById(R.id.profileImage);
            profileImageView.setBackground(new ShapeDrawable(new OvalShape()));
            profileImageView.setClipToOutline(true);
            nameTextView = (TextView) convertView.findViewById(R.id.profileName);
            moodTextView = (TextView) convertView.findViewById(R.id.profileMood);
        }

        profileImageView.setImageResource(profileItemArrayList.get(position).getProfileImage());
        nameTextView.setText(profileItemArrayList.get(position).getProfileName());
        moodTextView.setText(profileItemArrayList.get(position).getProfileMood());

        return convertView;
    }
}
