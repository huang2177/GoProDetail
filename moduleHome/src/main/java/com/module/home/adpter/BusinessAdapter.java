package com.module.home.adpter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.utils.TextUtil;
import com.module.home.R;
import com.module.home.bean.BusinBean;

import java.util.List;

/**
 * Created by shibing on 18/6/10.
 */

public class BusinessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Activity mActivity;
    private List<BusinBean.DataBean> list;
    private OnItemClickListener listener, listener1;

    public BusinessAdapter(Activity mActivity, List<BusinBean.DataBean> list) {
        this.mActivity = mActivity;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mActivity).inflate(R.layout.item_business_item, null);
        return new ViewHodler(view);
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

        GlideManager.loadImage(mActivity
                , Constant.IMAGE_HOST + list.get(position).getImgurl()
                , ((ViewHodler) holder).imageView);
        ((ViewHodler) holder).tvName.setText(list.get(position).getCity()
                + "." + list.get(position).getShopName());
        ((ViewHodler) holder).tvDistance.setText((int) TextUtil.getDistance(
                list.get(position).getLat()
                , list.get(position).getLat()
                , list.get(position).getLng()
                , list.get(position).getLat()
        ) + "km");
        ((ViewHodler) holder).tvAdderss.setText(list.get(position).getAddress());
        ((ViewHodler) holder).tvTel.setText(list.get(position).getTel());
        ((ViewHodler) holder).tvTel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_telephonecall, 0, 0, 0);

        ((ViewHodler) holder).tvTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener1.onItemClick(position);
                }
            }
        });

    }


    public void TelOnItemClickListener(OnItemClickListener listener) {
        this.listener1 = listener;
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


    public class ViewHodler extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName, tvDistance, tvAdderss, tvTel, tvLoc;


        public ViewHodler(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.busin_image_item);
            tvName = itemView.findViewById(R.id.busin_name_item);
            tvDistance = itemView.findViewById(R.id.busin_distance_item);
            tvAdderss = itemView.findViewById(R.id.bisin_adderss_item);
            tvTel = itemView.findViewById(R.id.busin_tel_item);
            tvLoc = itemView.findViewById(R.id.busin_loc_item);
        }
    }
}
