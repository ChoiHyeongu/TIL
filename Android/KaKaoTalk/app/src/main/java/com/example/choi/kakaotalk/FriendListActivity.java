package com.example.choi.kakaotalk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendListActivity extends AppCompatActivity {

    ListView profileList;
    profileListAdapter profileListAdapter;
    ArrayList<profileList> profileListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        profileList = (ListView) findViewById(R.id.profileList);
        profileListArrayList = new ArrayList<profileList>();

        profileListArrayList.add(new profileList(R.mipmap.me, "최형우", "카카오톡 클론 코딩 중"));
        profileListArrayList.add(new profileList(R.mipmap.solar, "솔라", "I am sum"));
        profileListArrayList.add(new profileList(R.mipmap.moonbyul, "문별", "I am moon"));
        profileListArrayList.add(new profileList(R.mipmap.wheein, "휘인", "I am flower"));
        profileListArrayList.add(new profileList(R.mipmap.hwasa, "화사", "I am wind"));

        profileListAdapter = new profileListAdapter(FriendListActivity.this, profileListArrayList);
        profileList.setAdapter(profileListAdapter);
    }
}
