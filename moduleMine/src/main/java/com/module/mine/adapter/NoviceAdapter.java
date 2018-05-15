package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.mine.R;

/**
 * Created by shibing on 18/5/5.
 */

public class NoviceAdapter extends BaseAdapter {

    private Activity activity;


    public NoviceAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_novice_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {


        ImageView imageView;

        TextView title, type, time;

        public ViewHolder(View view) {
            imageView = view.findViewById(R.id.novice_item_image);
            title = view.findViewById(R.id.novice_item_title);
            type = view.findViewById(R.id.novice_item_type);
            time = view.findViewById(R.id.novice_item_time);
        }
    }
}
