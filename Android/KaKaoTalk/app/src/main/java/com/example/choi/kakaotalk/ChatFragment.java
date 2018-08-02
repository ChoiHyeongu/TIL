package com.example.choi.kakaotalk;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    ListView chatList;
    ArrayList<ChatItem> chatItemArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_chatlist, container, false);

        chatList = (ListView) rootView.findViewById(R.id.chatList);
        chatItemArrayList = new ArrayList<ChatItem>();

        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));
        chatItemArrayList.add(new ChatItem(R.mipmap.moonbyul, "문별", "last Messsge", "2", "12:32"));

        chatList.setAdapter(new ChatListAdapter(getActivity(), chatItemArrayList));

        return rootView;
    }
}
