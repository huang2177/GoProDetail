package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.mine.R;
import com.module.mine.bean.AddersBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class AddressListAdapter extends BaseAdapter {

    private Activity activity;
    List<AddersBean.DataBean> list;


    public AddressListAdapter(Activity activity, List<AddersBean.DataBean> list) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_address_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvName.setText(list.get(position).getName());
        viewHolder.tvPhone.setText(list.get(position).getMobile());
        if (list.get(position).isIsDefault()) {
            viewHolder.tvDefault.setText("默认地址     ");
        } else {
            viewHolder.tvDefault.setVisibility(View.GONE);
        }
        viewHolder.tvAdderss.setText(list.get(position).getProvince() + list.get(position).getCity()
                + list.get(position).getArea() + list.get(position).getDetail());
        return convertView;
    }

    class ViewHolder {

        TextView tvName, tvPhone, tvDefault, tvAdderss;

        public ViewHolder(View view) {

            tvName = view.findViewById(R.id.address_item_naem_tv);
            tvPhone = view.findViewById(R.id.address_item_phone_tv);
            tvDefault = view.findViewById(R.id.address_item_default_tv);
            tvAdderss = view.findViewById(R.id.address_item_tv);
        }
    }
}
