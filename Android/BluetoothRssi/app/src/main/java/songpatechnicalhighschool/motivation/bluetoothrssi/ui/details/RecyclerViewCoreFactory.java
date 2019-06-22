package songpatechnicalhighschool.motivation.bluetoothrssi.ui.details;

import android.content.Context;

import songpatechnicalhighschool.motivation.bluetoothrssi.R;
import songpatechnicalhighschool.motivation.bluetoothrssi.ui.common.recyclerview.RecyclerViewBinderCore;

/*protected*/ final class RecyclerViewCoreFactory {

    public static RecyclerViewBinderCore create(final Context context) {
        final RecyclerViewBinderCore core = new RecyclerViewBinderCore();

        core.add(new TextBinder(context), TextHolder.class, R.layout.list_item_view_textview);
        core.add(new HeaderBinder(context), HeaderHolder.class, R.layout.list_item_view_header);
        core.add(new AdRecordBinder(context), AdRecordHolder.class, R.layout.list_item_view_adrecord);
        core.add(new RssiBinder(context), RssiInfoHolder.class, R.layout.list_item_view_rssi_info);
        core.add(new DeviceInfoBinder(context), DeviceInfoHolder.class, R.layout.list_item_view_device_info);
        core.add(new IBeaconBinder(context), IBeaconHolder.class, R.layout.list_item_view_ibeacon_details);

        return core;
    }

}
