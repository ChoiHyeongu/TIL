package com.example.choi.doitmission03;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    BitmapDrawable bitmap;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);

        imageView1.setImageResource(R.drawable.beach);

    }

    public void button1Clicked(View v){
        imageUp();
    }

    public void button2Clicked(View v){
        imageDown();
    }

    private void imageUp(){
        imageView1.setImageResource(R.drawable.beach);
        imageView2.setImageResource(0);
        imageView1.invalidate();
        imageView2.invalidate();
    }

    private void imageDown(){
        imageView1.setImageResource(0);
        imageView2.setImageResource(R.drawable.beach);
        imageView1.invalidate();
        imageView2.invalidate();
    }
}
