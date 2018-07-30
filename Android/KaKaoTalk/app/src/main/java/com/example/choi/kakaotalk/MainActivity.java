package com.example.choi.kakaotalk;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Fragment friendFragment;
    Fragment chatFragment;
    Fragment channelFragment;
    Fragment moreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendFragment = new FriendFragment();
        chatFragment = new ChatFragment();
        channelFragment = new ChannelFragment();
        moreFragment = new MoreFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, friendFragment).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_profile:
                        Toast.makeText(getApplicationContext(), "친구 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, friendFragment).commit();
                        break;

                    case R.id.action_chat:
                        Toast.makeText(getApplicationContext(), "채팅 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
                        break;

                    case R.id.action_channel:
                        Toast.makeText(getApplicationContext(), "채널 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, channelFragment).commit();
                        break;

                    case R.id.action_more:
                        Toast.makeText(getApplicationContext(), "더보기 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();
                        break;
                }
                return true;
            }
        });
    }
}

