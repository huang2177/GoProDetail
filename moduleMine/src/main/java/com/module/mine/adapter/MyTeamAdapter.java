package com.module.mine.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.module.base.manager.GlideManager;
import com.module.base.widgets.RoundImageView;
import com.module.mine.R;
import com.module.mine.bean.TeamBean;

import java.util.List;

/**
 * Created by shibing on 18/5/5.
 */

public class MyTeamAdapter extends BaseAdapter {

    private Activity activity;
    private List<TeamBean.DataBean.TeamsBean> list;

    public MyTeamAdapter(Activity activity, List<TeamBean.DataBean.TeamsBean> list) {
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
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_myteam_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvName.setText(list.get(position).getNickname());
        viewHolder.tv_Phone.setText(list.get(position).getMobile());
        GlideManager.loadImage(activity
                , list.get(position).getImgurl()
                , viewHolder.imageHead);
        return convertView;
    }

    class ViewHolder {

        TextView tvName, tv_Phone;

        RoundImageView imageHead;

        public ViewHolder(View view) {

            tvName = view.findViewById(R.id.myteam_item_name_tv);
            tv_Phone = view.findViewById(R.id.myteam_item_phone_tv);
            imageHead = view.findViewById(R.id.myteam_item_head_img);


            imageHead.setShapeType(1);
        }
    }
}
