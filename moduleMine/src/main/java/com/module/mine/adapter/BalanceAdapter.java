package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.mine.R;
import com.module.mine.bean.BlankNumBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class BalanceAdapter extends BaseAdapter {

    private Activity activity;
    List<BlankNumBean.DataBean> list;


    public BalanceAdapter(Activity activity, List<BlankNumBean.DataBean> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {

        if (list != null) {
            return list.size();

        }
        return 0;

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

        viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.time.setText(list.get(position).getCreateTime());
        viewHolder.money.setText(list.get(position).getAmount());
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
