package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.base.listener.OnItemClickListener;
import com.module.mine.R;
import com.module.mine.bean.AddersBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class AdmAddressListAdapter extends BaseAdapter {

    private Activity activity;
    private List<AddersBean.DataBean> list;
    private OnItemClickListener listener;

    public AdmAddressListAdapter(Activity activity, List<AddersBean.DataBean> list) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_admaddress_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });

        viewHolder.tvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
        viewHolder.tvDet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });

        viewHolder.tvName.setText(list.get(position).getName());
        viewHolder.tvPhone.setText(list.get(position).getMobile());
        viewHolder.tvAdderss.setText(list.get(position).getProvince() +
                list.get(position).getCity() +
                list.get(position).getArea());
        if (list.get(position).isIsDefault()) {
            viewHolder.tvDefault.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_checked_solid, 0, 0, 0);
            viewHolder.tvDefault.setText("默认地址");
        } else {
            viewHolder.tvDefault.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_blank, 0, 0, 0);
            viewHolder.tvDefault.setText("设为默认");
        }

        return convertView;
    }


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
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
