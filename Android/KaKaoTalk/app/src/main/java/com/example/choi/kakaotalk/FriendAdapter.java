package com.example.choi.kakaotalk;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class FriendAdapter extends BaseAdapter {

    ArrayList<FriendItem> profileItems = new ArrayList<FriendItem>();
    MainActivity mainActivity;

    @Override
    public int getCount() {
        return profileItems.size();
    }

    public void addFriend(FriendItem item) {
        profileItems.add(item);
    }

    @Override
    public Object getItem(int position) {
        return profileItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        mainActivity = new MainActivity();
        FriendItemView friendView = new FriendItemView(mainActivity.context);
        FriendItem friendItem = profileItems.get(position);

        friendView.setProfileImage(friendItem.getResId());
        friendView.setProfileName(friendItem.getName());
        friendView.setProfileMood(friendItem.getMood());

        return friendView;
    }
}
