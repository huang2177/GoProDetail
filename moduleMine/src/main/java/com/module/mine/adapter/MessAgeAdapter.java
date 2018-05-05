package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.mine.R;

/**
 * Created by shibing on 18/5/5.
 */

public class MessAgeAdapter extends BaseAdapter {

    private Activity activity;


    public MessAgeAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 6;
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_message_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {

        TextView title, content, time;

        public ViewHolder(View view) {

            title = view.findViewById(R.id.message_title_tv);
            content = view.findViewById(R.id.message_content_tv);
            time = view.findViewById(R.id.message_time_tv);
        }
    }
}
