package com.example.choi.doitmission04;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    EditText inputMessage;
    TextView inputCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMessage = (EditText) findViewById(R.id.editText);
        inputCount = (TextView) findViewById(R.id.byteView);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                byte[] bytes = null;

                try {
                    bytes = s.toString().getBytes("KSC5601");
                    int strCount = bytes.length;
                    inputCount.setText(strCount + " /80 바이트");
                } catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();

                try {
                    byte[] strBytes = str.getBytes("KSC5601");
                    if (strBytes.length > 80) {
                        s.delete(s.length() - 2, s.length() - 1);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };

        inputMessage.addTextChangedListener(watcher);
    }

    public void sendButton (View v){
        String message = inputMessage.getText().toString();
        Toast.makeText(getApplicationContext(), "입력한 메세지는\n" + message, Toast.LENGTH_LONG).show();
    }

    public void closeButton (View v){
        finish();
    }
}