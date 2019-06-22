package songpatechnicalhighschool.motivation.bluetoothrssi.ui.main;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import songpatechnicalhighschool.motivation.bluetoothrssi.R;
import songpatechnicalhighschool.motivation.bluetoothrssi.containers.BluetoothLeDeviceStore;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.Navigation;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.recyclerview.RecyclerViewBinderCore;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.recyclerview.RecyclerViewItem;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.details.DeviceRecyclerAdapter;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.details.RecyclerViewCoreFactory;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.model.IBeaconItem;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.model.LeDeviceItem;
import songpatechnicalhighschool.motivation.bluetoothrssi.util.BluetoothLeScanner;
import songpatechnicalhighschool.motivation.bluetoothrssi.util.BluetoothUtils;
import uk.co.alt236.bluetoothlelib.device.BluetoothLeDevice;
import uk.co.alt236.bluetoothlelib.device.beacon.BeaconType;
import uk.co.alt236.bluetoothlelib.device.beacon.BeaconUtils;
import uk.co.alt236.bluetoothlelib.device.beacon.ibeacon.IBeaconDevice;

public class MainActivity extends AppCompatActivity {


    private BluetoothLeDeviceStore mDeviceStore;
    private BluetoothUtils mBluetoothUtils;
    private DeviceRecyclerView mRecyclerAdapter;
    private BluetoothLeScanner mScanner;
    private RecyclerViewBinderCore mCore;
    private RecyclerView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCore = RecyclerViewCoreFactory.create(this, new Navigation(this));
        mList = findViewById(R.id.main_device_list);
    }

    private final BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {

            final BluetoothLeDevice deviceLe = new BluetoothLeDevice(device, rssi, scanRecord, System.currentTimeMillis());
            mDeviceStore.addDevice(deviceLe);
            final List<RecyclerViewItem> itemList = new ArrayList<>();

            for (final BluetoothLeDevice leDevice : mDeviceStore.getDeviceList()) {
                if (BeaconUtils.getBeaconType(leDevice) == BeaconType.IBEACON) {
                    itemList.add(new IBeaconItem(new IBeaconDevice(leDevice)));
                } else {
                    itemList.add(new LeDeviceItem(leDevice));
                }
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mRecyclerAdapter.setData(itemList);
                }
            });
        }
    };

    private void startScan() {
        final boolean isBluetoothOn = mBluetoothUtils.isBluetoothOn();
        final boolean isBluetoothLePresent = mBluetoothUtils.isBluetoothLeSupported();
        mDeviceStore.clear();

        mRecyclerAdapter = new DeviceRecyclerAdapter(mCore);
        mList.setAdapter(mRecyclerAdapter);

        mBluetoothUtils.askUserToEnableBluetoothIfNeeded();
        if (isBluetoothOn && isBluetoothLePresent) {
            mScanner.scanLeDevice(-1, true);
            invalidateOptionsMenu();
        }
    }
}
