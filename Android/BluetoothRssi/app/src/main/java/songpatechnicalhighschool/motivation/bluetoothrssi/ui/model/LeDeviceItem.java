package songpatechnicalhighschool.motivation.bluetoothrssi.ui.model;

import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.recyclerview.RecyclerViewItem;
import uk.co.alt236.bluetoothlelib.device.BluetoothLeDevice;

public class LeDeviceItem implements RecyclerViewItem {

    private final BluetoothLeDevice device;

    public LeDeviceItem(final BluetoothLeDevice device) {
        this.device = device;
    }

    public BluetoothLeDevice getDevice() {
        return device;
    }
}
