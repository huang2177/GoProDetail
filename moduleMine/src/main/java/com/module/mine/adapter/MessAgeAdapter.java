package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module.mine.R;
import com.module.mine.bean.MessAgeBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class MessAgeAdapter extends BaseAdapter {

    private Activity activity;

    private List<MessAgeBean.DataBean> list;


    public MessAgeAdapter(Activity activity, List<MessAgeBean.DataBean> list) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_message_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(list.get(position).getTitle());
        viewHolder.content.setText(list.get(position).getContent());
        viewHolder.time.setText(list.get(position).getCreateTime());


        return convertView;
    }

    class ViewHolder {

        TextView title, content, time;

        public ViewHolder(View view) {
            title = view.findViewById(R.id.message_title_tv);
            content = view.findViewById(R.id.message_content_tv);
            time = view.findViewById(R.id.message_time_tv);
        }
    }
}
