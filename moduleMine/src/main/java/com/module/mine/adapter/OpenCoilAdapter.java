package com.module.mine.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.mine.R;
import com.module.mine.bean.TuanCouponBean;
import com.module.mine.ui.GiveOpenCoilActivity;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class OpenCoilAdapter extends BaseAdapter {

    private Activity activity;
    private List<TuanCouponBean.DataBean> list;

    public OpenCoilAdapter(Activity activity, List<TuanCouponBean.DataBean> list) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_myopencoil_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tvTitle.setText(list.get(position).getTitle());
        viewHolder.tvNumber.setText(list.get(position).getTuanNum());
        viewHolder.tvPople.setText(list.get(position).getFromName());
        viewHolder.tvTime.setText(list.get(position).getFromTime());

        if (list.get(position).isIsSend()) {
            viewHolder.tvGift.setText("已赠送");
            viewHolder.tvGift.setBackgroundResource(R.drawable.bg_btn_brown1);
        } else {
            viewHolder.tvGift.setText("赠送");
            viewHolder.tvGift.setBackgroundResource(R.drawable.bg_btn_brown1);
        }

        viewHolder.tvGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //赠送监听事件
                activity.startActivity(new Intent(activity, GiveOpenCoilActivity.class));
            }
        });
        return convertView;
    }

    class ViewHolder {

        TextView tvTitle, tvNumber, tvPople, tvTime, tvGift;

        public ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.opencoil_item_title);
            tvNumber = view.findViewById(R.id.opencoil_item_numbe);
            tvPople = view.findViewById(R.id.opencoil_item_giftpople);
            tvTime = view.findViewById(R.id.opencoil_item_time);
            tvGift = view.findViewById(R.id.opencoil_item_gift);

        }
    }
}
