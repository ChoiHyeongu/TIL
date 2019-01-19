package com.example.motivation.intentpractice;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button sub1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.main_text);
        sub1 = (Button) findViewById(R.id.main_sub1);
        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                Intent getIntent = getIntent();

                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case 100:
                    Toast.makeText(this, data.getStringExtra("Text"), Toast.LENGTH_SHORT).show();
                    textView.setText(data.getStringExtra("Text"));
                    break;
            }
        }
    }
}


