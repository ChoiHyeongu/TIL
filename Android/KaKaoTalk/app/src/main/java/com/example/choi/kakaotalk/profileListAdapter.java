package com.example.choi.kakaotalk;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class profileListAdapter extends BaseAdapter {

    ImageView profileImage;
    TextView nameView;
    TextView moodView;

    @Override
    public int getCount() {
        return this.profileListArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.profileListArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.profile_view,null);
            profileImage = (ImageView) convertView.findViewById(R.id.imageView);
            nameView = (TextView) convertView.findViewById(R.id.nameView);
            moodView = (TextView) convertView.findViewById(R.id.moodView);

        }

        profileImage.setImageResource(profileListArrayList.get(position).getProfileImage());
        nameView .setText(profileListArrayList.get(position).getName());
        moodView.setText(profileListArrayList.get(position).getMood());

        return convertView;
    }

    Context context;
    ArrayList<profileList> profileListArrayList;

    public profileListAdapter(Context context, ArrayList<profileList> profileListArrayList) {
        this.context = context;
        this.profileListArrayList = profileListArrayList;
    }
}
