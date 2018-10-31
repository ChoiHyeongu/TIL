package com.example.motivation.firebaserealtimedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText userIDEdit;
    private EditText userNameEdit;
    private TextView outputText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        userIDEdit = findViewById(R.id.main_useridEdit);
        userNameEdit = findViewById(R.id.main_usernameEdit);
        outputText = findViewById(R.id.main_outputText);


        button = findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = userIDEdit.getText().toString();
                String name = userNameEdit.getText().toString();

                User user = new User(email, name);

                myRef.child("users").child("userInfo").setValue(email);
            }
        });
    }
}
