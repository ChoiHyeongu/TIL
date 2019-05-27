package songpatechnicalhighschool.motivation.bluetoothex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BluetoothListAdapter extends RecyclerView.Adapter<BluetoothListAdapter.ViewHolder> {

    private ArrayList<String> bluetoothList;
    private Context context;

    public BluetoothListAdapter(ArrayList<String> bluetoothList, Context context) {
        this.bluetoothList = bluetoothList;
        this.context = context;
    }

    @NonNull
    @Override
    public BluetoothListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View view = LayoutInflater.from(context).inflate(R.layout.item_bluetooth,viewGroup, false);
         return new BluetoothListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BluetoothListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bluetoothItem.setText(bluetoothList.get(i));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView bluetoothItem;

        public ViewHolder(View itemView) {
            super(itemView);
            bluetoothItem = itemView.findViewById(R.id.item_bluetooth);
        }
    }
}
