package com.module.mall.adpter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.base.widgets.RoundImageView;
import com.module.base.widgets.XGridView;
import com.module.mall.R;

/**
 * Created by shibing on 18/5/30.
 */

public class MoreEvaluateAdapter extends BaseAdapter {


    private Activity activity;
    private MoreEvaluatePicAdapter adapter;

    public MoreEvaluateAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 8;
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_evaluate, null);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }

        //添加图片
        adapter = new MoreEvaluatePicAdapter(activity);
        viewHodler.gridView.setAdapter(adapter);
        return convertView;
    }


    public class ViewHodler {


        private RoundImageView imageView;
        private TextView tvName, tvTime, tvDetalis;
        private XGridView gridView;


        public ViewHodler(View view) {
            imageView = view.findViewById(R.id.evaluate_head);
            tvName = view.findViewById(R.id.evaluate_name);
            tvTime = view.findViewById(R.id.evaluate_time);
            tvDetalis = view.findViewById(R.id.evaluate_detail);
            gridView = view.findViewById(R.id.evaluate_gridview);
            imageView.setShapeType(1);
        }
    }
}