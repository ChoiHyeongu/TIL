package com.example.choi.doitmission06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;

    EditText id;
    EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginClicked(View v){

        id = (EditText) findViewById(R.id.id);
        pw = (EditText) findViewById(R.id.pw);

        String userID = id.getText().toString();
        String userPW = pw.getText().toString();

        if(userID.equals("") || userPW.equals("")) Toast.makeText(this, "아이디나 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, REQUEST_CODE_MENU);
        }
    }
}
