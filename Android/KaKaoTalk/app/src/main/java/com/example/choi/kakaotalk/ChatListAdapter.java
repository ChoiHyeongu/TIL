package com.example.choi.kakaotalk;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter{

    Context context;
    ArrayList<ChatItem> chatItemArrayList;

    ImageView roomImage;
    TextView roomName;
    TextView curMessage;
    TextView curDate;
    TextView numberOfMemeber;

    public ChatListAdapter(Context context, ArrayList<ChatItem> chatItemArrayList, ImageView roomImage, TextView roomName, TextView curMessage, TextView curDate, TextView numberOfMemeber) {
        this.context = context;
        this.chatItemArrayList = chatItemArrayList;
        this.roomImage = roomImage;
        this.roomName = roomName;
        this.curMessage = curMessage;
        this.curDate = curDate;
        this.numberOfMemeber = numberOfMemeber;
    }

    @Override
    public int getCount() {
        return this.chatItemArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatItemArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chat_item, null);

            roomImage = (ImageView) convertView.findViewById(R.id.roomImage);
            roomName = (TextView) convertView.findViewById(R.id.roomName);
            curMessage = (TextView) convertView.findViewById(R.id.curChatText);
            curDate = (TextView) convertView.findViewById(R.id.curDate);
            numberOfMemeber = (TextView) convertView.findViewById(R.id.numOfMember);
        }

        roomImage.setImageResource(chatItemArrayList.get(position).getRoomImage());
        roomName.setText(chatItemArrayList.get(position).getRoomName());
        curMessage.setText(chatItemArrayList.get(position).getCurMessage());
        curDate.setText(chatItemArrayList.get(position).getCurMessageTime());
        numberOfMemeber.setText(chatItemArrayList.get(position).getNumberOfPeople());

        return convertView;
    }
}
