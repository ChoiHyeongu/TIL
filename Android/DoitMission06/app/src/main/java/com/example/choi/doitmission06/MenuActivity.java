package com.example.choi.doitmission06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CUSTOMER = 101;
    public static final int REQUEST_CODE_SALES = 102;
    public static final int REQUEST_CODE_PRODUCT = 103;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent receivedIntent = getIntent();
        String msg = receivedIntent.getStringExtra("menu");

        Toast.makeText(this, "이전 엑티비티 : " + msg, Toast.LENGTH_LONG).show();
    }

    public void customerClicked(View v) {

        Intent intent = new Intent(getBaseContext(), SalesActivty.class);
        intent.putExtra("menu", "메뉴");
        startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
    }

    public void salesClicked(View v) {

        Intent intent = new Intent(getBaseContext(), SalesActivty.class);
        intent.putExtra("menu", "메뉴");
        startActivityForResult(intent, REQUEST_CODE_SALES);
    }

    public void productClicked(View v) {

        Intent intent = new Intent(getBaseContext(), SalesActivty.class);
        intent.putExtra("menu", "메뉴");
        startActivityForResult(intent, REQUEST_CODE_PRODUCT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_CUSTOMER) {
                String message = intent.getStringExtra("menu");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "이전 엑티비티 : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_SALES) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "이전 엑티비티 : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_PRODUCT) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "이전 엑티비티 : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }
    }
}
