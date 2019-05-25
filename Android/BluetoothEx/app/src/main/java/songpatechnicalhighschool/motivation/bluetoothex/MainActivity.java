package songpatechnicalhighschool.motivation.bluetoothex;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    RecyclerView bluetoothList;
    BluetoothListAdapter bluetoothListAdapter;
    List<Map<String,String>> dataDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findBluetooth();

        bluetoothList = findViewById(R.id.main_bluetoothList);
        bluetoothListAdapter = new BluetoothListAdapter(dataDevice, getApplicationContext());
        bluetoothList.setAdapter(bluetoothListAdapter);
    }

    void findBluetooth(){
        BroadcastReceiver mBluetoothSearchReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                switch(action){
                    //블루투스 디바이스 검색 종료
                    case BluetoothAdapter.ACTION_DISCOVERY_STARTED:
                        dataDevice.clear();
                        Toast.makeText(MainActivity.this, "블루투스 검색 시작", Toast.LENGTH_SHORT).show();
                        break;
                    //블루투스 디바이스 찾음
                    case BluetoothDevice.ACTION_FOUND:
                        //검색한 블루투스 디바이스의 객체를 구한다
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        //데이터 저장
                        Map map = new HashMap();
                        map.put("name", device.getName()); //device.getName() : 블루투스 디바이스의 이름
                        map.put("address", device.getAddress()); //device.getAddress() : 블루투스 디바이스의 MAC 주소
                        dataDevice.add(map);
                        //리스트 목록갱신
                        break;
                    //블루투스 디바이스 검색 종료
                    case BluetoothAdapter.ACTION_DISCOVERY_FINISHED:
                        Toast.makeText(MainActivity.this, "블루투스 검색 종료", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
    }
}
