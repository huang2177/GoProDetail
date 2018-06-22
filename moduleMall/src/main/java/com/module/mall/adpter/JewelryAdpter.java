package com.module.mall.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.pouduct.ProductBean;
import com.module.base.utils.Logger;
import com.module.mall.R;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class JewelryAdpter extends RecyclerView.Adapter {

    private Context context;
    public OnItemClickListener listener;
    private List<ProductBean.DataBean> list;

    public JewelryAdpter(Context context, List<ProductBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.jewelry_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        GlideManager.loadImage(context, Constant.IMAGE_HOST + list.get(position).getImgurl()
                , viewHolder.ivPro);
        viewHolder.tvName.setText(list.get(position).getTitle());
        viewHolder.tvPirce.setText("押金：￥" + list.get(position).getDeposit());


    }


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
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
                    listener.onItemClick(viewType, -1);
                }
            });
        }
    }
}
