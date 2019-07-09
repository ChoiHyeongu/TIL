package songpatechnicalhighschool.motivation.diaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    TextView titleText;
    TextView contentText;
    String title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        titleText = findViewById(R.id.detail_titleText);
        contentText = findViewById(R.id.detail_contentText);

        Intent getIntent = getIntent();
        title = getIntent.getExtras().getString("Title");
        content = getIntent.getExtras().getString("Content");
        Toast.makeText(this, title +". " + content, Toast.LENGTH_SHORT).show();

        titleText.setText(title);
        contentText.setText(content);
    }
}
