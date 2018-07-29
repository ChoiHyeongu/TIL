package com.example.choi.samplelistview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

class SingerAdapter extends BaseAdapter{
    ArrayList<SingerItem> items = new ArrayList<SingerItem>();
    MainActivity mainActivity;

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(SingerItem item) {
        items.add(item);
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        mainActivity = new MainActivity();
        SingerItemView view = new SingerItemView(mainActivity.context);
        SingerItem item = items.get(position);
        view.setName(item.getName());
        view.setMobile(item.getMobile());
        view.setAge(item.getAge());
        view.setImage(item.getResId());

        return view;
    }
}