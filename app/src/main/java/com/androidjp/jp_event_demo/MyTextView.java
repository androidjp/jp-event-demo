package com.androidjp.jp_event_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by androidjp on 16-7-6.
 */
public class MyTextView extends TextView{


    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e("MyTextView", "没有clickable, onTouchEvent依然会执行");

        return super.onTouchEvent(event);
    }
}
