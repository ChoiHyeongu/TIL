package com.example.motivation.firebaserealtimedatabase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mItemRef= mRootRef.child("Item");
    private EditText itemName;
    private EditText itemContent;
    private EditText searchEdit;
    private TextView outputText;
    private Button inputButton;
    private Button outputButton;
    private Button listviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemName = findViewById(R.id.main_item_name);
        itemContent = findViewById(R.id.main_item_content);
        outputText = findViewById(R.id.main_outputText);
        searchEdit = findViewById(R.id.main_search);

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
                String searchItem = searchEdit.getText().toString();
                Log.d(TAG, "Search item = " + searchItem);

                mItemRef.child(searchItem).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String content = dataSnapshot.getValue(String.class);
                        outputText.append(content + "\n");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.w(TAG, "Failed to read value.");
                    }
                });
            }
        });

        listviewButton = (Button) findViewById(R.id.main_listviewButton);
        listviewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListviewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addItem(String name, String content) {
        mItemRef.child(name).setValue(content);
        Log.d(TAG, "Name : " + name + " Content : " + content);
    }
}
