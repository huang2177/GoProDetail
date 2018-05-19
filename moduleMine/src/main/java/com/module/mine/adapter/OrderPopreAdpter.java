package com.module.mine.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.listener.OnItemClickListener;
import com.module.base.widgets.RoundImageView;
import com.module.mine.R;

import java.util.List;

/**
 * Created by 黄双 on 2018/5/5.
 */

public class OrderPopreAdpter extends BaseAdapter {

    private Context context;
    private List<Integer> list;

    private OnItemClickListener listener;

    public OrderPopreAdpter(Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 12;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_poper_girdview, null);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);

        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        return convertView;
    }


    public class ViewHodler {
        RoundImageView imageView;

        public ViewHodler(View view) {

            imageView = view.findViewById(R.id.pople_image);
        }

    }
}
