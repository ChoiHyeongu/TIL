package custom.graphics.techtown.org.myprogress;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    String msg = null;

    Handler handler = new Handler();
    CompletionThread completionThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressTask task = new ProgressTask();
                task.execute("시작");
            }
        });

        completionThread = new CompletionThread();
        completionThread.start();
    }

    class ProgressTask extends AsyncTask<String, Integer, Integer> {

        int value = 0;

        @Override
        protected Integer doInBackground(String... strings) {

            while (true) {
                if (value > 100) {
                    break;
                }
                value++;

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                }
            }

            publishProgress(value);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            Toast.makeText(getApplicationContext(), "완료됨", Toast.LENGTH_LONG).show();
        }
    }

    class ProgressThread extends Thread {

        int value = 0;

        @Override
        public void run() {
            while (true) {
                if (value > 100) {
                    break;
                }
                value++;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(value);
                    }
                });

                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                }
            }

            completionThread.completionHandler.post(new Runnable() {
                @Override
                public void run() {
                    msg = "OK";
                    Log.d("MainActivity", "메세지 : " + msg);
                }
            });
        }
    }

    class CompletionThread extends Thread {

        public Handler completionHandler = new Handler();

        @Override
        public void run() {
            Looper.prepare();
            Looper.loop();
        }
    }
}
