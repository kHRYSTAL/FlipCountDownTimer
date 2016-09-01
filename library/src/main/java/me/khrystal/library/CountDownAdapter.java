package me.khrystal.library;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import me.khrystal.widget.R;

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
    public static final int DEFAULTID = R.layout.default_holder;

    public CountDownAdapter(Context context, List<Integer> numberList, int layoutId) {
        mInflater = LayoutInflater.from(context);
        mNumberList = numberList;
        mLayoutId = (layoutId == -1) ? DEFAULTID : layoutId;
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
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(mLayoutId, parent, false);
            holder.countDownItemText = (TextView) convertView.findViewById(R.id.countdown_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.countDownItemText.setText(mNumberList.get(position).toString());

        return convertView;
    }

    static class ViewHolder{
        TextView countDownItemText;
    }
}
