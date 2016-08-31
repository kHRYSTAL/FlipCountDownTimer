package me.khrystal.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.util.List;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/31
 * update time:
 * email: 723526676@qq.com
 */
public class FlipCountDownView extends LinearLayout{

    private int[] mNumberArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    private List<Integer> mSecondDigit;
    private List<Integer> mSecondTens;
    private List<Integer> mMinuteDigit;
    private List<Integer> mMinuteTens;
    private List<Integer> mHourDigit;
    private List<Integer> mHourTens;




    public FlipCountDownView(Context context) {
        this(context, null);
    }

    public FlipCountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlipCountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlipCountDownView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {

    }
}
