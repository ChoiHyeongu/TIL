package com.example.motivation.firebaserealtimedatabase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    DatabaseReference itemRef;
    ArrayAdapter<String> adapter;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        listView = findViewById(R.id.list_listview);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();
        itemRef = ref.child("Item");
        adapter = new ArrayAdapter<String>(this, R.layout.item_listview, R.id.item_title);

        itemRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    String title = ds.getKey();
                    adapter.add(title);
                    Log.d(TAG, "Title : " + title);
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
