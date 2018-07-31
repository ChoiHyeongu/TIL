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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Fragment friendFragment;
    Fragment chatFragment;
    Fragment channelFragment;
    Fragment moreFragment;

    TextView nowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friendFragment = new FriendFragment();
        chatFragment = new ChatFragment();
        channelFragment = new ChannelFragment();
        moreFragment = new MoreFragment();

        nowFragment = findViewById(R.id.nowView);

        getSupportFragmentManager().beginTransaction().add(R.id.container, friendFragment).commit();

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, friendFragment).commit();
                        nowFragment.setText(R.string.friend);
                        break;

                    case R.id.action_chat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, chatFragment).commit();
                        nowFragment.setText(R.string.chat);
                        break;

                    case R.id.action_channel:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, channelFragment).commit();
                        nowFragment.setText(R.string.channel);
                        break;

                    case R.id.action_more:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, moreFragment).commit();
                        nowFragment.setText(R.string.edit);
                        break;
                }
                return true;
            }
        });
    }
}

