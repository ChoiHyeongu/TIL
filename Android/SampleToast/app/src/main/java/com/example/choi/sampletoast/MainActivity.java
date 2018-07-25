package com.example.choi.sampletoast;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v){
        try{
            Toast toast = Toast.makeText(this, "위치가 바뀐 토스트 메세지 입니다.", Toast.LENGTH_LONG);
            int xOffset = Integer.parseInt(editText1.getText().toString());
            int yOffset = Integer.parseInt(editText1.getText().toString());

            toast.setGravity(Gravity.TOP|Gravity.TOP, xOffset, yOffset);
            toast.show();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0, -100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();
    }

    public void onButton3Clicked(View v){
        Snackbar.make(v, "스낵바입니다. ", Snackbar.LENGTH_LONG).show();
    }

}
