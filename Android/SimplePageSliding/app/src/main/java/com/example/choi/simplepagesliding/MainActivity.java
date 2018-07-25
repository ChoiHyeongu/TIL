package com.example.choi.simplepagesliding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    boolean isPageOpen = false;

    Animation translateLeftAnim;
    Animation translateRightAnim;
    LinearLayout page;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        page = (LinearLayout) findViewById(R.id.page);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingPageAnimationListner animListner = new SlidingPageAnimationListner();
        translateLeftAnim.setAnimationListener(animListner);
        translateRightAnim.setAnimationListener(animListner);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){

        page = (LinearLayout) findViewById(R.id.page);

        if (isPageOpen){
            page.startAnimation(translateRightAnim);
        } else {
            page.setVisibility(View.VISIBLE);
            page.startAnimation(translateLeftAnim);
        }
    }

    private class SlidingPageAnimationListner implements Animation.AnimationListener{
        public void onAnimationEnd(Animation animation){

            button = (Button) findViewById(R.id.button);

            if (isPageOpen){
                page.setVisibility(View.INVISIBLE);

                button.setText("Open");
                isPageOpen = false;
            } else {
                button.setText("Close");
                isPageOpen = true;
            }
        }

        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationStart(Animation animation) {

        }
    }
}
