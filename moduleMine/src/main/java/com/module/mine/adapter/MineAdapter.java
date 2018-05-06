package com.module.mine.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.listener.AParamListener;
import com.module.mine.FragmentMine;
import com.module.mine.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class MineAdapter extends BaseAdapter {

    private AParamListener listener;
    private Activity activity;

    private List<String> names;
    private List<Integer> resId;

    public MineAdapter(Activity activity, AParamListener listener) {

        this.activity = activity;
        this.listener = listener;

        initList();
    }

    private void initList() {
        names = Arrays.asList("我的团队"
                , "拼团返现"
                , "我的开团卷"
                , "我的订单"
                , "我的押金"
                , "收货信息管理"
                , "我的收藏"
                , "新手帮助"
                , "客服电话"
                , "投诉建议"
                , "系统设置"
                , null);

        resId = Arrays.asList(
                R.drawable.ic_mine_team
                , R.drawable.ic_mine_achi
                , R.drawable.ic_mine_voucher
                , R.drawable.ic_mine_achi
                , R.drawable.ic_mine_order
                , R.drawable.ic_mine_deposit
                , R.drawable.ic_mine_logistics
                , R.drawable.ic_mine_heart
                , R.drawable.ic_mine_problem
                , R.drawable.ic_mine_telephone
                , R.drawable.ic_mine_complaint
                , R.drawable.ic_mine_set
                , 0);
    }

    @Override
    public int getCount() {
        return names.size();
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_mine_grid, null);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        initView(position, viewHolder);
        return convertView;
    }

    private void initView(int position, ViewHolder viewHolder) {
        if (TextUtils.isEmpty(names.get(position))) {
            return;
        }
        viewHolder.tv.setText(names.get(position));
        viewHolder.tv.setCompoundDrawablesWithIntrinsicBounds(0
                , resId.get(position)
                , 0
                , 0);

        if (position == 3 || position == 4 || position == 5) {
            viewHolder.divider.setVisibility(View.VISIBLE);
        }
    }

    class ViewHolder {

        TextView tv;
        View divider;

        ViewHolder(View view) {
            tv = view.findViewById(R.id.mine_tv_item);
            divider = view.findViewById(R.id.mine_divider);
        }
    }
}
