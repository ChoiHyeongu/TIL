package com.example.choi.kakaotalk;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class FriendFragment extends Fragment {

    ListView profileList;
    ArrayList<ProfileItem> profileItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_friendlist, container, false);

        ImageView myImg= (ImageView) rootView.findViewById(R.id.myImg);
        myImg.setBackground(new ShapeDrawable(new OvalShape()));
        myImg.setClipToOutline(true);

        profileList = (ListView) rootView.findViewById(R.id.friendList);
        profileItemArrayList = new ArrayList<ProfileItem>();

        profileItemArrayList.add(new ProfileItem(R.mipmap.chu, "추세연", "profile 1"));
        profileItemArrayList.add(new ProfileItem(R.mipmap.solar, "솔라", "profile 2"));
        profileItemArrayList.add(new ProfileItem(R.mipmap.moonbyul, "문별", "profile 3"));
        profileItemArrayList.add(new ProfileItem(R.mipmap.wheein, "휘인", "profile 4"));
        profileItemArrayList.add(new ProfileItem(R.mipmap.hwasa, "화사", "profile 5"));
        profileList.setAdapter(new ProfileListAdapter(getActivity(), profileItemArrayList));

        return rootView;
    }
}
