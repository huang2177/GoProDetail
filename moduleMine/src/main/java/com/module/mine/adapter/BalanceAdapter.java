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

public class BalanceAdapter extends BaseAdapter {

    private Activity activity;


    public BalanceAdapter(Activity activity) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_balance_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {

        TextView title, money, time;

        public ViewHolder(View view) {

            title = view.findViewById(R.id.balance_title_item);
            money = view.findViewById(R.id.balance_money_item);
            time = view.findViewById(R.id.balance_time_item);
        }
    }
}
