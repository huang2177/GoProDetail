package com.module.mall.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.listener.OnItemClickListener;
import com.module.base.manager.GlideManager;
import com.module.base.widgets.RoundImageView;
import com.module.mall.R;
import com.module.mall.bean.ProductTuanBean;

import java.util.List;

/**
 * Created by shibing on 18/6/3.
 */

public class ProductTuanAdapter extends BaseAdapter {


    private Context context;
    private List<ProductTuanBean.DataBean> list;
    private String from;
    private OnItemClickListener listener;

    public ProductTuanAdapter(Context context, List<ProductTuanBean.DataBean> list, String from) {
        this.list = list;
        this.from = from;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (list != null) {
            if ("".equals(from)) {
                return 2;
            } else {
                return list.size();
            }
        }
        return 0;
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
        ViewHodler viewHodler = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_product_tuan, null);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);

        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }

        GlideManager.loadImage(context
                , Constant.IMAGE_HOST + list.get(position).getImgurl()
                , viewHodler.imageView);
        viewHodler.tvName.setText(list.get(position).getNickname());
        viewHodler.tvNumer.setText("剩余" + list.get(position).getNeedOrderNum() + "个名额成团");
        viewHodler.tvTime.setText("剩余时间：" + list.get(position).getEndTime());
        return convertView;
    }


    public class ViewHodler {
        RoundImageView imageView;
        TextView tvName, tvNumer, tvTime;

        public ViewHodler(View view) {
            imageView = view.findViewById(R.id.item_tuan_head);
            tvName = view.findViewById(R.id.item_tuan_name);
            tvNumer = view.findViewById(R.id.item_tuan_numer);
            tvTime = view.findViewById(R.id.item_tuan_time);
            imageView.setShapeType(1);
        }

    }
}
