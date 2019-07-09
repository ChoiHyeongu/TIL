package songpatechnicalhighschool.motivation.diaryapp;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WriteActivity extends AppCompatActivity {

    Calendar cal = Calendar.getInstance();
    EditText titleEditText;
    EditText contentEditText;
    Button saveButton;
    DBHelper dbHelper;
    Button datePickerDialogButton;
    String datePickerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        titleEditText = findViewById(R.id.write_titleEditText);
        contentEditText = findViewById(R.id.write_contentEditText);
        saveButton = findViewById(R.id.write_saveButton);
        datePickerDialogButton = findViewById(R.id.write_datePickerButton);


        datePickerDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(WriteActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        datePickerValue = String.format("%d년 %d월 %d일", year, month+1, date);
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));

                dialog.getDatePicker().setMaxDate(new Date().getTime());
                dialog.show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();

                if(isEmpty(title) || isEmpty(content)){
                    Toast.makeText(WriteActivity.this, "제목 혹은 내용이 비어있습니다.", Toast.LENGTH_SHORT).show();
                }

                dbHelper = new DBHelper(WriteActivity.this, "Diary.db", null, 1);


                dbHelper.insert(title, content, datePickerValue);
                finish();
            }
        });
    }

    boolean isEmpty(String str){
        if(str == null) return true;
        else return false;
    }
}
