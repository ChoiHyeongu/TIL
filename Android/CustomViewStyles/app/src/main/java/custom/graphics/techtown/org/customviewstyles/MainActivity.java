package custom.graphics.techtown.org.customviewstyles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewStyles view = new CustomViewStyles(this);

        setContentView(view);
    }
}
