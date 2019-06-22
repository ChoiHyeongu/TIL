package songpatechnicalhighschool.motivation.bluetoothrssi.ui.model;

import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.recyclerview.RecyclerViewItem;
import uk.co.alt236.bluetoothlelib.device.beacon.ibeacon.IBeaconDevice;

public class IBeaconItem implements RecyclerViewItem {

    private final IBeaconDevice device;

    public IBeaconItem(final IBeaconDevice device) {
        this.device = device;
    }

    public IBeaconDevice getDevice() {
        return device;
    }

}
