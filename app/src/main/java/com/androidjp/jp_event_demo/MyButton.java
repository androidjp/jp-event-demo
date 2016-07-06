package com.androidjp.jp_event_demo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by androidjp on 16-7-6.
 */
public class MyButton extends Button {


    Context context;

    private String tag;

    @Override
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public MyButton(Context context) {
        super(context);
        this.context = context;
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Toast.makeText(context,"MyButton.dispatchTouchEvent" , Toast.LENGTH_SHORT).show();

        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                onLog("dispatchTouchEvent ACTION_DOWN 按下");
                break;
            case MotionEvent.ACTION_MOVE:
                onLog("dispatchTouchEvent ACTION_MOVE 滑动");
                break;
            case MotionEvent.ACTION_UP:
                onLog("dispatchTouchEvent ACTION_UP 松开");
                break;

            default:
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                onLog("onTouchEvent ACTION_DOWN 按下");
                break;
            case MotionEvent.ACTION_MOVE:
                onLog("onTouchEvent ACTION_MOVE 滑动");
                break;
            case MotionEvent.ACTION_UP:
                onLog("onTouchEvent ACTION_UP 松开");
                break;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }



    private void onLog(String msg){
        Toast.makeText(context,getTag()+" : "+msg , Toast.LENGTH_SHORT).show();
        Log.d(getTag(), msg);
    }


}
