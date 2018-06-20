package com.module.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.listener.OnItemClickListener;
import com.module.mine.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class OrderListAdpter extends RecyclerView.Adapter {

    private Context context;
    private List<Integer> list;

    private OnItemClickListener listener;

    public OrderListAdpter(Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*资源文件在base中*/
        View view = LayoutInflater.from(context).inflate(R.layout.item_order_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
//        viewHolder.ivPro.setImageResource(list.get(position));
//
//        viewHolder.tvPirce.setText("￥0元购");
//        viewHolder.tvPirce.setVisibility(View.VISIBLE);
//
        viewHolder.tvMoney.setText(Html.fromHtml(getHtmlStr(position)));

    }

    private String getHtmlStr(int position) {
        return "实付    <font color='#a0563c'>$9688（运费：$0）</font>";
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        TextView tvName, tvPirce, tvProName, tvColor, tvMoney, tvType, tvState;

        ViewHolder(View view, final int viewType) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_order);
            tvName = view.findViewById(R.id.item_tv_order_name);
            tvPirce = view.findViewById(R.id.item_order_tv_pirce);
            tvColor = view.findViewById(R.id.item_order_tv_color);
            tvProName = view.findViewById(R.id.item_tv_pro_name);
            tvMoney = view.findViewById(R.id.item_order_money_tv);
            tvType = view.findViewById(R.id.order_type_tv);
            tvState = view.findViewById(R.id.order_state_tv);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(viewType, -1);
                }
            });
        }
    }
}
