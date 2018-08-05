package choi.org.sampleandroidsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = editText.getText().toString().trim();

                ConnectThread thread = new ConnectThread(addr);
                thread.start();
            }
        });
    }

    class ConnectThread extends Thread{
        String hostname;

        public ConnectThread(String addr){
            hostname = addr;
        }

        @Override
        public void run() {
            try{
                int port = 5001;
                Socket sock = new Socket(hostname, port);

                ObjectOutputStream outputStream = new ObjectOutputStream(sock.getOutputStream());
                outputStream.writeObject("Hello AndroidTown on Android");
                outputStream.flush();

                ObjectInputStream inputStream = new ObjectInputStream(sock.getInputStream());
                String obj = (String) inputStream.readObject();

                Log.d("MainActivity", "서버에서 받은 메세지 : " + obj);

                sock.close();

            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
