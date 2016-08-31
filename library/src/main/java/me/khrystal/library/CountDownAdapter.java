package me.khrystal.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/31
 * update time:
 * email: 723526676@qq.com
 */
public class CountDownAdapter extends BaseAdapter{

    private List<Integer> mNumberList;
    private LayoutInflater mInflater;
    private int mLayoutId;

    public CountDownAdapter(Context context, List<Integer> numberList, int layoutId) {
        mInflater = LayoutInflater.from(context);
        mNumberList = numberList;
        mLayoutId = layoutId;
    }


    @Override
    public int getCount() {
        return mNumberList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
