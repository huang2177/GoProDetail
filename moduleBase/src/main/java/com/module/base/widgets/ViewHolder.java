package com.module.base.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Huangshuang  2018/5/10 0010
 */

public class ViewHolder {
    /**
     * 用来缓存item,复用；
     */
    private SparseArray<View> items;

    private View convertView;

    public ViewHolder(Context context, int layoutId, ViewGroup parent, int position) {
        items = new SparseArray<View>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    /**
     * 获取一个ViewHolder
     *
     * @param context
     * @param layoutId
     * @param convertView
     * @param parent
     * @param position
     * @return
     */
    public static ViewHolder getHolder(Context context, int layoutId, View convertView, ViewGroup parent, int position) {
        if (convertView == null) {
            return new ViewHolder(context, layoutId, parent, position);
        }
        return (ViewHolder) convertView.getTag();
    }


    /**
     * 获取一个Item
     *
     * @return
     */
    public View getCovertView() {
        return convertView;
    }

    /**
     * 为TextView赋值
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getItemView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 获取一个View
     *
     * @param viewId
     * @param <T>
     * @return
     */
    public <T extends View> T getItemView(int viewId) {
        View item = items.get(viewId);
        if (item == null) {
            item = convertView.findViewById(viewId);
            items.put(viewId, item);
        }
        return (T) item;

    }

    /**
     * 为ImageView赋值——drawableId
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getItemView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

}
