package com.example.motivation.firebaserealtimedatabase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mContentRef = mRootRef.child("Name");
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private EditText itemName;
    private EditText itemContent;
    private EditText findText;
    private TextView outputText;
    private Button inputButton;
    private Button outputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemName = findViewById(R.id.main_item_name);
        itemContent = findViewById(R.id.main_item_content);
        outputText = findViewById(R.id.main_outputText);
        findText = findViewById(R.id.main_find);

        inputButton = findViewById(R.id.main_input);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = itemName.getText().toString();
                String content = itemContent.getText().toString();

                addItem(name, content);
                Log.d(TAG, "Name :" + name + " Content : " + content);
            }
        });

        outputButton = findViewById(R.id.main_output);
        outputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mRootRef.child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String content = dataSnapshot.child("Name").getValue(String.class);
                Log.d(TAG, "Read value : " + content);
                outputText.setText(content);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addItem(String name, String content) {
        mContentRef.child(name).push().setValue(content);
        Log.d(TAG, "Name : " + name + " Content : " + content);
    }
}
