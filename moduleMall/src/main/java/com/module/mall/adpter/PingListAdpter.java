package com.module.mall.adpter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.widgets.RoundImageView;
import com.module.mall.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class PingListAdpter extends RecyclerView.Adapter {

    private Context context;
    private List<Integer> list;

    public PingListAdpter(Context context, List<Integer> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*资源文件在base中*/
        View view = LayoutInflater.from(context).inflate(R.layout.item_ping_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
//        viewHolder.ivPro.setImageResource(list.get(position));
//
//        viewHolder.tvPirce.setText("￥0元购");
//        viewHolder.tvPirce.setVisibility(View.VISIBLE);
//
        viewHolder.tvName.setText(Html.fromHtml(getHtmlStr(position)));

        viewHolder.tvPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private String getHtmlStr(int position) {
        return "莉莉安    <font color='#a0563c'>剩余3个名额成团</font>";
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        RoundImageView ivHead;
        TextView tvName, tvPirce, tvProName, tvTime, tvPing, tvColor;

        ViewHolder(View view) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPing = view.findViewById(R.id.item_tv_ping);
            tvTime = view.findViewById(R.id.item_tv_time);
            ivHead = view.findViewById(R.id.item_img_head);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvColor = view.findViewById(R.id.item_tv_color);
            tvProName = view.findViewById(R.id.item_tv_pro_name);
        }
    }
}
