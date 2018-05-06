package com.module.mall.adpter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.module.mall.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class MallListAdpter extends RecyclerView.Adapter {

    private Context context;
    private List<Integer> list;

    public MallListAdpter(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mall_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.ivPro.setImageResource(list.get(position));

        viewHolder.tvPirce.setText("￥0元购");
        viewHolder.tvPirce.setVisibility(View.VISIBLE);

        viewHolder.tvName.setVisibility(View.VISIBLE);
        viewHolder.tvName.setText("Apple iPhone X 256G");

        viewHolder.tvOldPirce.setText("￥7467");
        viewHolder.tvOldPirce.setVisibility(View.VISIBLE);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        TextView tvName, tvPirce, tvOldPirce;

        ViewHolder(View view) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvOldPirce = view.findViewById(R.id.item_tv_old_pirce);

            tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
