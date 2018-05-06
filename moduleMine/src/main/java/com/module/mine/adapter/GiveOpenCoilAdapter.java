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

public class GiveOpenCoilAdapter extends BaseAdapter {

    private Activity activity;


    public GiveOpenCoilAdapter(Activity activity) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_giveopencoil_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {

        TextView tvName, tv_Phone, give;

        ImageView imageHead;

        public ViewHolder(View view) {

            tvName = view.findViewById(R.id.give_item_name_tv);
            tv_Phone = view.findViewById(R.id.give_item_phone_tv);
            imageHead = view.findViewById(R.id.give_item_head_img);
            give = view.findViewById(R.id.give_item_tv);

        }
    }
}
