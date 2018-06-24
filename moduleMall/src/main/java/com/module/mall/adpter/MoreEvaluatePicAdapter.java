package com.module.mall.adpter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.base.widgets.RoundImageView;
import com.module.base.widgets.XGridView;
import com.module.mall.R;
import com.module.mall.bean.ProductEvaBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shibing on 18/5/30.
 */

public class MoreEvaluatePicAdapter extends BaseAdapter {


    private Activity activity;
    private List<ProductEvaBean.DataBean> list;
    private List<String> listEvaPic;

    public MoreEvaluatePicAdapter(Activity activity, List<ProductEvaBean.DataBean> list) {
        this.activity = activity;
        this.list = list;
        listEvaPic = new ArrayList<>();
    }

    @Override
    public int getCount() {
        if (listEvaPic.size() > 2) {
            return 3;
        } else {
            return list.size();
        }
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_evaluate_image, null);
            viewHodler = new ViewHodler(convertView);
            convertView.setTag(viewHodler);
        } else {
            viewHodler = (ViewHodler) convertView.getTag();
        }

        String str[] = list.get(position).getImgurls().split(",");
        listEvaPic = Arrays.asList(str);
        for (int i = 0; i < listEvaPic.size(); i++) {
            GlideManager.loadImage(activity, Constant.IMAGE_HOST + listEvaPic.get(i), viewHodler.imageView);
        }


        return convertView;
    }


    public class ViewHodler {


        private ImageView imageView;


        public ViewHodler(View view) {
            imageView = view.findViewById(R.id.item_evaluate_image);

        }
    }
}
