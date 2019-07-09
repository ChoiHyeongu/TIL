package songpatechnicalhighschool.motivation.diaryapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Diary> diaryArrayList;
    private Context mContext = null;
    private DBHelper dbHelper;

    public CustomAdapter() {
    }

    public CustomAdapter(ArrayList<Diary> diaryArrayList, Context mContext) {
        this.diaryArrayList = diaryArrayList;
        this.mContext = mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public int getCount() {
        return diaryArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return diaryArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (position >= getCount())
            return (convertView);

        final ViewHolder holder;
        final LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dbHelper = new DBHelper(mContext, "Diary.db", null, 1);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_diary, parent, false);
            holder = new ViewHolder();
            holder.titleText= convertView.findViewById(R.id.item_title);
            holder.dateText = convertView.findViewById(R.id.item_date);
            holder.layout = convertView.findViewById(R.id.item_layout);
            holder.deleteButton = convertView.findViewById(R.id.item_deleteButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.titleText.setText(diaryArrayList.get(position).getTitle());
        holder.dateText.setText(diaryArrayList.get(position).getDate());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("Title", diaryArrayList.get(position).getTitle());
                intent.putExtra("Content", diaryArrayList.get(position).getContent());
                mContext.startActivity(intent);
            }
        });

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.delete(diaryArrayList.get(position).getTitle());
                diaryArrayList.remove(position);
                updateItemList(diaryArrayList);
            }
        });

        return convertView;
    }

    public void updateItemList(ArrayList<Diary> diaryArrayList){
        this.diaryArrayList = diaryArrayList;
        notifyDataSetChanged();
    }

    private class ViewHolder {
        TextView titleText;
        TextView dateText;
        ImageButton deleteButton;
        View layout;
    }
}