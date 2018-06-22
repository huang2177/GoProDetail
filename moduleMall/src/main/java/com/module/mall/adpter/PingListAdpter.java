package com.module.mall.adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.widgets.RoundImageView;
import com.module.mall.R;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class PingListAdpter extends RecyclerView.Adapter {

    private Context context;
    private List<ProductTuanBean.DataBean> list;
    private OnItemClickListener listener;

    public PingListAdpter(Context context, List<ProductTuanBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ping_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;


        GlideManager.loadImage(context, Constant.IMAGE_HOST + list.get(position).getImgurl()
                , viewHolder.ivHead);


        viewHolder.tvName.setText(Html.fromHtml(getHtmlStr(position)));
        viewHolder.tvTime.setText("剩余时间：" + list.get(position).getEndTime());
        GlideManager.loadImage(context, Constant.IMAGE_HOST + list.get(position).getProduct().getImgurl()
                , viewHolder.ivPro);
        viewHolder.tvProName.setText(list.get(position).getProduct().getTitle());
        viewHolder.tvColor.setText(list.get(position).getNormstr());
        viewHolder.tvPirce.setText("￥" + list.get(position).getAmount());
    }


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    private String getHtmlStr(int position) {

        return list.get(position).getNickname() + "<font color='#a0563c'>"
                +"      "
                + "剩余" + list.get(position).getNeedOrderNum() + "个名额成团"
                + "</font>";
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
        RoundImageView ivHead;
        TextView tvName, tvPirce, tvProName, tvTime, tvPing, tvColor;

        ViewHolder(View view, final int viewType) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPing = view.findViewById(R.id.item_tv_ping);
            tvTime = view.findViewById(R.id.item_tv_time);
            ivHead = view.findViewById(R.id.item_img_head);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvColor = view.findViewById(R.id.item_tv_color);
            tvProName = view.findViewById(R.id.item_tv_pro_name);

            ivHead.setShapeType(1);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(viewType, -1);
                    }
                }
            });
        }
    }
}
