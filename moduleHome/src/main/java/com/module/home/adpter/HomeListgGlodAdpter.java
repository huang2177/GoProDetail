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
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });

        ViewHolder viewHolder = (ViewHolder) holder;

        if (list.get(position).getCatagory().equals("2")) {
            viewHolder.tvPirce.setVisibility(View.VISIBLE);
            viewHolder.tvName.setVisibility(View.VISIBLE);
            viewHolder.ivPro.setVisibility(View.VISIBLE);
            viewHolder.tvOldPirce.setVisibility(View.VISIBLE);
            GlideManager.loadImage(context,
                    Constant.IMAGE_HOST + list.get(position).getImgurl()
                    , viewHolder.ivPro);
            viewHolder.tvName.setText(list.get(position).getTitle());
            viewHolder.tvPirce.setText(list.get(position).getAmount() + "");
        }
        //viewHolder.ivPro.setImageResource(list.get(position));
        /*if (position == 0 || position == 6) {
            viewHolder.ivPro.setPadding(0, 0, 0, 20);
        } else if (position == 5 || position == 11) {
            viewHolder.ivPro.setPadding(0, 20, 0, 0);
        } else {
            viewHolder.tvPirce.setText("￥0元购");
            viewHolder.tvPirce.setVisibility(View.VISIBLE);
            viewHolder.tvName.setVisibility(View.VISIBLE);
            viewHolder.tvName.setText("Apple iPhone X 256G");
            viewHolder.tvOldPirce.setText("￥7467");
            viewHolder.tvOldPirce.setVisibility(View.VISIBLE);
            viewHolder.ivPro.setPadding(0, 20, 0, 0);
        }*/
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


    public void addOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


   /* @Override
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
    }*/

    /**
     * @return
     */
   /* private int getSpanSize(int position) {
        switch (position) {
            case 0:
            case 5:
            case 6:
            case 11:
                return 2;
            default:
                return 1;
        }
    }*/

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPro;
        TextView tvName, tvPirce, tvOldPirce;

        ViewHolder(View view) {
            super(view);
            ivPro = view.findViewById(R.id.item_img_pro);
            tvName = view.findViewById(R.id.item_tv_name);
            tvPirce = view.findViewById(R.id.item_tv_pirce);
            tvOldPirce = view.findViewById(R.id.item_tv_old_pirce);
            // tvOldPirce.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
