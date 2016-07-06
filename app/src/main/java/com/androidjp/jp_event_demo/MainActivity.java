package com.androidjp.jp_event_demo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements View.OnTouchListener{

    @Bind(R.id.layout_root)
    MyRelativeLayout rootLayout;
    @Bind(R.id.layout_a)
    MyRelativeLayout layoutA;
    @Bind(R.id.layout_b_1)
    MyRelativeLayout layoutB1;
    @Bind(R.id.layout_b_2)
    MyRelativeLayout layoutB2;
    @Bind(R.id.btn_a)
    MyButton btn_a;
    @Bind(R.id.view_b1)
    MyTextView view_b1;
    @Bind(R.id.view_b2)
    TextView view_b2;
    @Bind(R.id.view_b3)
    TextView view_b3;
    @Bind(R.id.view_b4)
    TextView view_b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //测试所有形式的触摸事件

        initView();
        initEvent();

    }

    private void initView() {
        btn_a.setTag("btn_a");
        rootLayout.setTag("rootLayout");
        layoutA.setTag("layoutA");
        layoutB1.setTag("layoutB1");
        layoutB2.setTag("layoutB2");
    }



    private void initEvent() {
        rootLayout.setOnTouchListener(this);
        layoutA.setOnTouchListener(this);
        layoutB1.setOnTouchListener(this);
        layoutB2.setOnTouchListener(this);
        btn_a.setOnTouchListener(this);
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this ,"btn.onClick", Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.class.getSimpleName(), "btn.onClick");
            }
        });
        btn_a.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this ,"btn.onLongClick", Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.class.getSimpleName(), "btn.onLongClick");
                return false;
            }
        });

        view_b1.setOnTouchListener(this);
        view_b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"view_b1.onClick()方法执行",Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.class.getSimpleName(), "view_b1.onClick()");
            }
        });
        view_b1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this,"view_b1.onLongClick()方法执行",Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.class.getSimpleName(), "view_b1.onLongClick()");
                return false;
            }
        });
//        view_b1.setEnabled(false);
        view_b2.setOnTouchListener(this);
        view_b3.setOnTouchListener(this);
        view_b4.setOnTouchListener(this);

    }







    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //Toast.makeText(MainActivity.this ,"MainActivity.onTouchEvent", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getName(), "MainActivity.onTouchEvent");
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {



        if (view.equals(rootLayout)){
            onTouchEventLog("rootLayout");
            return false;
        }
        if (view.equals(layoutA)){
            onTouchEventLog("layoutA");
            return false;
        }
        if (view.equals(layoutB1)){
            onTouchEventLog("layoutB1");
            return false;
        }
        if (view.equals(btn_a)){
            onTouchEventLog("btn_a");
            Toast.makeText(MainActivity.this, "onTouch方法返回true,此时，btn内部的onTouchEvent不触发",Toast.LENGTH_SHORT).show();
            return true;
        }
        if (view.equals(view_b1)){
            onTouchEventLog("view_b1");
            return false;
        }
        if (view.equals(view_b2)){
            onTouchEventLog("view_b2");
            return false;
        }
        if (view.equals(view_b3)){
            onTouchEventLog("view_b3");
            return false;
        }
        if (view.equals(view_b4)){
            onTouchEventLog("view_b4");
            if (motionEvent.getAction() == MotionEvent.ACTION_MOVE){
                Toast.makeText(MainActivity.this ,"view_b4被拖动了", Toast.LENGTH_SHORT).show();
                Log.d(MainActivity.class.getSimpleName(), "view_b4被拖动了");
                return true;
            }
            return false;
        }

        return false;
    }


    private void onTouchEventLog(String tag){
        Toast.makeText(MainActivity.this ,tag+": OnTouchListener.onTouch()", Toast.LENGTH_SHORT).show();
        Log.d(MainActivity.class.getSimpleName(), tag+": OnTouchListener.onTouch()");
    }
}
