package me.khrystal.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.List;

import me.khrystal.widget.R;
import se.emilsjolander.flipview.FlipView;

/**
 * usage:
 * author: kHRYSTAL
 * create time: 16/8/31
 * update time:
 * email: 723526676@qq.com
 */
public class FlipCountDownView extends RelativeLayout{

    private Integer[] mNumberArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    private List<Integer> mSecondDigit;
    private List<Integer> mSecondTens;
    private List<Integer> mMinuteDigit;
    private List<Integer> mMinuteTens;
    private List<Integer> mHourDigit;
    private List<Integer> mHourTens;

    private FlipView mSecondDigitView;
    private FlipView mSecondTensView;
    private FlipView mMinuteDigitView;
    private FlipView mMinuteTensView;
    private FlipView mHourDigitView;
    private FlipView mHourTensView;

    private long mCountDownTimeMillons;
    private long mCurrentTimeMillons;

    private CountDownAdapter mSecondDigitAdapter;
    private CountDownAdapter mSecondTensAdapter;
    private CountDownAdapter mMinuteDigitAdapter;
    private CountDownAdapter mMinuteTensAdapter;
    private CountDownAdapter mHourDigitAdapter;
    private CountDownAdapter mHourTensAdapter;

    private CustomCountDownTimer mCustomCountDownTimer;
    private OnCountdownEndListener mOnCountdownEndListener;





    public FlipCountDownView(Context context) {
        this(context, null);
    }

    public FlipCountDownView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlipCountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public FlipCountDownView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public void setCountDownTimeMillons(long timeMillons) {
        mCountDownTimeMillons = timeMillons;
    }



    private void init(Context context, AttributeSet attrs) {
        List<Integer> arrays = Arrays.asList(mNumberArray);

        mSecondDigit = arrays;
        mSecondTens = arrays.subList(0, 7);

        mMinuteDigit = arrays;
        mMinuteTens = arrays.subList(0, 7);

        mHourDigit = arrays;
        mHourTens = arrays;

        View inflate = inflate(context, R.layout.layout_container, this);

        mSecondDigitView = (FlipView) inflate.findViewById(R.id.second_digit);
        mSecondTensView = (FlipView) inflate.findViewById(R.id.second_tens);
        mMinuteDigitView = (FlipView) inflate.findViewById(R.id.minute_digit);
        mMinuteTensView = (FlipView) inflate.findViewById(R.id.minute_tens);
        mHourDigitView = (FlipView) inflate.findViewById(R.id.hour_digit);
        mHourTensView = (FlipView) inflate.findViewById(R.id.hour_tens);

        mSecondDigitAdapter = new CountDownAdapter(context, mSecondDigit, -1);
        mSecondTensAdapter = new CountDownAdapter(context, mSecondTens, -1);
        mMinuteDigitAdapter = new CountDownAdapter(context, mMinuteDigit, -1);
        mMinuteTensAdapter = new CountDownAdapter(context, mMinuteTens, -1);
        mHourDigitAdapter = new CountDownAdapter(context, mHourDigit, -1);
        mHourTensAdapter = new CountDownAdapter(context, mHourTens, -1);


        mSecondDigitView.setAdapter(mSecondDigitAdapter);
        mSecondTensView.setAdapter(mSecondTensAdapter);
        mMinuteDigitView.setAdapter(mMinuteDigitAdapter);
        mMinuteTensView.setAdapter(mMinuteTensAdapter);
        mHourDigitView.setAdapter(mHourDigitAdapter);
        mHourTensView.setAdapter(mHourTensAdapter);
    }


    public void start() {
        if (mCountDownTimeMillons <= 0) return;


        if (null != mCustomCountDownTimer) {
            mCustomCountDownTimer.stop();
            mCustomCountDownTimer = null;
        }


        long countDownInterval = 1000;


        mCustomCountDownTimer = new CustomCountDownTimer(mCountDownTimeMillons, countDownInterval) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateShow(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                if (null != mOnCountdownEndListener) {
                    mOnCountdownEndListener.onEnd(FlipCountDownView.this);
                }
            }
        };
        mCustomCountDownTimer.start();
    }

    public void updateShow(long ms) {
        this.mCountDownTimeMillons = ms;

        int hour = (int)((ms % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60)) * (int)(ms / (1000 * 60 * 60 * 24));
        int minute = (int)((ms % (1000 * 60 * 60)) / (1000 * 60));
        int second = (int)((ms % (1000 * 60)) / 1000);
        if (second % 10 == 9)
            mSecondDigitView.flipTo(second % 10);
        else
            mSecondDigitView.smoothFlipTo(second % 10);
        if ((second / 10) % 10 == 5 || (second / 10) % 10 == 6)
            mSecondTensView.flipTo((second / 10) % 10);
        else
            mSecondTensView.smoothFlipTo((second / 10) % 10);

        if (minute % 10 == 9)
            mMinuteDigitView.flipTo(minute % 10);
        else
            mMinuteDigitView.smoothFlipTo(minute % 10);
        if ((minute / 10) % 10 == 6 || (minute / 10) % 10 == 5)
            mMinuteTensView.flipTo((minute / 10) % 10);
        else
            mMinuteTensView.smoothFlipTo((minute / 10) % 10);

        if (hour % 10 == 9)
            mHourDigitView.flipTo(hour % 10);
        else
            mHourDigitView.smoothFlipTo(hour % 10);
        if ((hour / 10) % 10 == 9)
            mHourTensView.flipTo(hour / 10);
        else
            mMinuteTensView.smoothFlipTo(hour / 10);


    }

    /**
     * stop countdown
     */
    public void stop() {
        if (null != mCustomCountDownTimer) mCustomCountDownTimer.stop();
    }

    /**
     * pause countdown
     */
    public void pause() {
        if (null != mCustomCountDownTimer) mCustomCountDownTimer.pause();
    }

    /**
     * pause countdown
     */
    public void restart() {
        if (null != mCustomCountDownTimer) mCustomCountDownTimer.restart();
    }

    /**
     * set countdown end callback listener
     * @param onCountdownEndListener OnCountdownEndListener
     */
    public void setOnCountdownEndListener(OnCountdownEndListener onCountdownEndListener) {
        mOnCountdownEndListener = onCountdownEndListener;
    }


    public interface OnCountdownEndListener {
        void onEnd(FlipCountDownView fcd);
    }

}
