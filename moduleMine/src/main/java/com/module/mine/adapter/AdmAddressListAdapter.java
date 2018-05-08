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

public class AdmAddressListAdapter extends BaseAdapter {

    private Activity activity;


    public AdmAddressListAdapter(Activity activity) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_admaddress_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }

    class ViewHolder {

        TextView tvName, tvPhone, tvDefault, tvAdderss, tvEdit, tvDet;

        public ViewHolder(View view) {

            tvName = view.findViewById(R.id.admress_item_naem_tv);
            tvPhone = view.findViewById(R.id.admress_item_phone_tv);
            tvAdderss = view.findViewById(R.id.admress_item_xx_tv);
            tvDefault = view.findViewById(R.id.admarss_default_tv);
            tvEdit = view.findViewById(R.id.admress_item_edit_tv);
            tvDet = view.findViewById(R.id.admress_item_det_tv);
        }
    }
}
