package com.module.base.widgets;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @author Huangshuang  2018/5/10 0010
 */

public abstract class CommonAdapter<T> extends BaseAdapter {

    private List<T> mData;
    private Context mContext;
    private int mLayoutId;
    private View convertView;
    private SparseArray<View> views;

    public CommonAdapter(Context context, List<T> data, int layoutId) {
        this.mData = data;
        this.mContext = context;
        this.mLayoutId = layoutId;
        views = new SparseArray<>();
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder(mContext, mLayoutId, parent, position);
        convert(position, holder, (T) getItem(position));
        return holder.getCovertView();
    }


    /**
     * 通过ViewHolder把View找到，通过Item设置值
     *
     * @param holder
     * @param data
     */
    public abstract void convert(int position, ViewHolder holder, T data);

}
