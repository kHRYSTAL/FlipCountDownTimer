package me.khrystal.countdowndemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.khrystal.library.FlipCountDownView;

public class MainActivity extends AppCompatActivity {

    FlipCountDownView mFlipCountDownView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlipCountDownView = (FlipCountDownView) findViewById(R.id.flip_count_down);
        mFlipCountDownView.setCountDownTimeMillons(1800000);
        mFlipCountDownView.start();
    }
}
