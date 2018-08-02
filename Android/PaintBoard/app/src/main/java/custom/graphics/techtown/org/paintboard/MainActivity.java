package custom.graphics.techtown.org.paintboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PaintBoard view = new PaintBoard(this);
        setContentView(view);
    }
}
