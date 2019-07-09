package songpatechnicalhighschool.motivation.diaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    ArrayList<Diary> diaryArrayList;
    ListView listView;
    DBHelper dbHelper;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.list_listview);

        if( dbHelper == null ) {
            dbHelper = new DBHelper(ListActivity.this,"Diary.db", null , 1);
        }

        try{
            diaryArrayList = dbHelper.getResult();
            listView.setAdapter(new CustomAdapter(diaryArrayList, ListActivity.this));
            customAdapter = new CustomAdapter(diaryArrayList, this);
            listView.setAdapter(customAdapter);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
