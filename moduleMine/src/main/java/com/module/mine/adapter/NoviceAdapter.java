package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.app.Constant;
import com.module.base.manager.GlideManager;
import com.module.mine.R;
import com.module.mine.bean.HelpBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class NoviceAdapter extends BaseAdapter {

    private Activity activity;
    List<HelpBean.DataBean> list;


    public NoviceAdapter(Activity activity, List<HelpBean.DataBean> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
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
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_novice_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        GlideManager.loadImage(activity, Constant.IMAGEURL + list.get(position).getImgurl(), viewHolder.imageView);
        viewHolder.title.setText(list.get(position).getTitle());
        if (list.get(position).getType() == 0) {
            viewHolder.type.setText("新手帮助");
        }
        viewHolder.time.setText(list.get(position).getCreateTime());
        return convertView;
    }

    class ViewHolder {


        ImageView imageView;

        TextView title, type, time;

        public ViewHolder(View view) {
            imageView = view.findViewById(R.id.novice_item_image);
            title = view.findViewById(R.id.novice_item_title);
            type = view.findViewById(R.id.novice_item_type);
            time = view.findViewById(R.id.novice_item_time);
        }
    }
}
