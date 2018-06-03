package com.module.mall.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.module.base.listener.OnItemClickListener;
import com.module.base.widgets.RoundImageView;
import com.module.mall.R;

import java.util.List;

/**
 * Created by shibing on 18/6/3.
 */

public class PingPopleAdapter extends BaseAdapter {


    private Context context;
    private List<Integer> list;

    private OnItemClickListener listener;

    public PingPopleAdapter(Context context, List<Integer> list) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.child_poper_girdview, null);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);

        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }
        viewHodler.imageView.setImageResource(list.get(position));
        return convertView;
    }


    public class ViewHodler {
        RoundImageView imageView;

        public ViewHodler(View view) {
            imageView = view.findViewById(R.id.pople_image);
            imageView.setShapeType(1);
        }

    }
}
