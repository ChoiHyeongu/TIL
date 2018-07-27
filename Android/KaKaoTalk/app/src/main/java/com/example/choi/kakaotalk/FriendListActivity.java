package com.example.choi.kakaotalk;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendListActivity extends FragmentActivity {

    ListView profileList;
    profileListAdapter profileListAdapter;
    ArrayList<profileList> profileListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        addFriend();
    }

    public void addFriend(){
        profileList = (ListView) findViewById(R.id.profileList);
        profileListArrayList = new ArrayList<profileList>();

        profileListArrayList.add(new profileList(R.mipmap.me, "최형우", "MAMAMOO"));
        profileListArrayList.add(new profileList(R.mipmap.solar, "솔라", "I am sun"));
        profileListArrayList.add(new profileList(R.mipmap.moonbyul, "문별", "I am moon"));
        profileListArrayList.add(new profileList(R.mipmap.wheein, "휘인", "I am wind"));
        profileListArrayList.add(new profileList(R.mipmap.hwasa, "화사", "I am flower"));

        profileListAdapter = new profileListAdapter(FriendListActivity.this, profileListArrayList);
        profileList.setAdapter(profileListAdapter);
    }
}
