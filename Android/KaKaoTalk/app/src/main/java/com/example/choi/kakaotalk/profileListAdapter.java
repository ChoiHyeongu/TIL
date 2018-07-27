package com.example.choi.kakaotalk;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class profileListAdapter extends BaseAdapter {

    public static int sdk = android.os.Build.VERSION.SDK_INT;

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

            if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
                profileImage.setBackgroundDrawable(new ShapeDrawable(new OvalShape()));
            } else {
                profileImage.setBackground(new ShapeDrawable(new OvalShape()));
            }

            profileImage.setClipToOutline(true);
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
