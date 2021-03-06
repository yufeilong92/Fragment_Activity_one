package com.xuechuan.mvc.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xuechuan.mvc.R;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: MyApplication
 * @Package com.xuechuan.mvc.Adapter
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/8 15:59
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class TitleAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> mData;

    public TitleAdapter(Context mContext, List<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            viewholder = new ViewHolder(convertView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        viewholder.mTv.setText(mData.get(position));
        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView mTv;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.mTv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
