package com.example.choi.samplegreedview;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    TextView textView3;
    ImageView imageView;

    public SingerItemView(Context context){
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView =(TextView) findViewById(R.id.textView);
        textView2 =(TextView) findViewById(R.id.textView2);
        textView3 =(TextView) findViewById(R.id.textView3);
        imageView =(ImageView) findViewById(R.id.imageView);
    }

    public void setName(String name){
        textView.setText(name);
    }

    public void setMobile(String mobile){
        textView2.setText(mobile);
    }

    public void setAge(int age){
        textView3.setText(String.valueOf(age));
    }

    public void setImage(int resId){
        imageView.setImageResource(resId);
    }
}

