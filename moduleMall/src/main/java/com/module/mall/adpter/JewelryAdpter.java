package com.module.mall.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.listener.OnItemClickListener;
import com.module.base.widgets.RoundImageView;
import com.module.mall.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class JewelryAdpter extends RecyclerView.Adapter {

    private Context context;
    public OnItemClickListener listener;

    public JewelryAdpter(Context context) {
        this.context = context;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*资源文件在base中*/
        View view = LayoutInflater.from(context).inflate(R.layout.jewelry_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        // viewHolder.tvName.setText(Html.fromHtml(getHtmlStr(position)));

    }


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
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
        TextView tvName, tvPirce;

        ViewHolder(View view, final int viewType) {
            super(view);
            ivPro = view.findViewById(R.id.ssh_img_item);
            tvName = view.findViewById(R.id.ssh_name_tv);
            tvPirce = view.findViewById(R.id.ssh_yj_tv);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(viewType);
                }
            });
        }
    }
}
