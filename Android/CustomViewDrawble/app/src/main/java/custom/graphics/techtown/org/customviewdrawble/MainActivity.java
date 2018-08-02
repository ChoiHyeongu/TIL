package custom.graphics.techtown.org.customviewdrawble;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomViewDrawbles customViewDrawbles = new CustomViewDrawbles(this);
        setContentView(customViewDrawbles);
    }
}
