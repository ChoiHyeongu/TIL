package com.example.choi.sampleintent;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU= 101;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU) {
            Toast.makeText(getApplicationContext(), "onActivityResult 메서드 호출됨. 요청 코드 : + " + requestCode + ", 결과 코드 : " + resultCode, Toast.LENGTH_LONG).show();

            if(resultCode == REQUEST_CODE_MENU) {
                String name  = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(), "응답으로 전달된 name : "+name, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        Intent intent = new Intent();
        ComponentName name = new ComponentName("com.example.choi.sampleintent", "com.example.choi.sampleintent.MenuActivity");
        intent.setComponent(name);
        startActivityForResult(intent, REQUEST_CODE_MENU);
    }
}
