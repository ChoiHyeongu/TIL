package com.example.motivation.intentpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editText = (EditText) findViewById(R.id.sub1_edit);
        button = (Button) findViewById(R.id.sub1_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textIntent = new Intent();
                textIntent.putExtra("Text", editText.getText().toString());
                setResult(RESULT_OK, textIntent);
                finish();
            }
        });
    }
}
