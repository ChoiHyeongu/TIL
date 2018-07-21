package com.example.choi.doitmission05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public static final int RESPONSE_CODE_OK = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void customButtonClicked(View v){
        Intent customIntent = new Intent();
        customIntent.putExtra("menu", "고객 관리");
        setResult(AppCompatActivity.RESULT_OK, customIntent);
        finish();
    }

    public void salesButtonClicked(View v){
        Intent customIntent = new Intent();
        customIntent.putExtra("menu", "매출 관리");
        setResult(AppCompatActivity.RESULT_OK, customIntent);
        finish();
    }

    public void productButtonClicked(View v){
        Intent customIntent = new Intent();
        customIntent.putExtra("menu", "상품 관리");
        setResult(AppCompatActivity.RESULT_OK, customIntent);
        finish();
    }
}
