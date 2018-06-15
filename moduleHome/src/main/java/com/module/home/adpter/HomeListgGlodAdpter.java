package com.module.home.adpter;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
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
import com.module.home.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class HomeListgGlodAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ProductBean.DataBean> list;
    private OnItemClickListener listener;

    public HomeListgGlodAdpter(Context context, List<ProductBean.DataBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_list, null);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if (list.get(position).getCatagory().equals("2")) {
            viewHolder.tvPirce.setVisibility(View.VISIBLE);
            viewHolder.tvName.setVisibility(View.VISIBLE);
            viewHolder.ivPro.setVisibility(View.VISIBLE);
            viewHolder.tvOldPirce.setVisibility(View.VISIBLE);
            viewHolder.ivPro.setPadding(0, 20, 0, 0);
            GlideManager.loadImage(context,
                    Constant.IMAGE_HOST + list.get(position).getImgurl()
                    , viewHolder.ivPro);
            viewHolder.tvPirce.setText("¥0元购");
            viewHolder.tvName.setText(list.get(position).getTitle());
            viewHolder.tvOldPirce.setText("¥" + list.get(position).getAmount());
        }
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


    public void addHoldOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int type = getItemViewType(position);
                    return HomeListgGlodAdpter.this.getSpanSize(position);
                }
            });
        }
    }

    /**
     * @return
     */
    private int getSpanSize(int position) {
        return 1;

    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        TextView tvName, tvPirce, tvOldPirce;

        ViewHolder(View view, final int postion) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvOldPirce = view.findViewById(R.id.item_tv_old_pirce);
            tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(postion);
                    }
                }
            });
        }
    }
}
