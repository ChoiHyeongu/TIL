package com.example.choi.doitmission06;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.choi.doitmission06.LoginActivity.REQUEST_CODE_MENU;
import static com.example.choi.doitmission06.MenuActivity.REQUEST_CODE_CUSTOMER;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    public void goMenu(View v){
        finish();
    }

    public void goLogin(View v){
        Intent loginIntent = new Intent(getBaseContext(), LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginIntent.putExtra("menu", "고객 관리");
        setResult(Activity.RESULT_OK, loginIntent);
        startActivity(loginIntent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_CUSTOMER) {
            if (intent != null) {
                String message = intent.getStringExtra("menu");

                Toast toast = Toast.makeText(getBaseContext(), "이전 엑티비티 : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }
}
