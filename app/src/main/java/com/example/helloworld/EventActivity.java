package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.MyButton;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEvent,mbtnHandler;
    private MyButton btnMy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        //内部类的实现方式
        mBtnEvent = findViewById(R.id.btn_event);
        mbtnHandler=findViewById(R.id.btn_handler);
        mbtnHandler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent = new Intent(EventActivity.this, HandlerActivity.class);
              startActivity(intent);
            }
        });
//        mBtnEvent.setOnClickListener(new OnClick());

        //匿名内部类实现
//        mBtnEvent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ToastUtil.showMsg(EventActivity.this,"click.....");
//            }
//        });

        //通过事件源所在的类实现
//        mBtnEvent.setOnClickListener(EventActivity.this);

        //通过外部实现
        mBtnEvent.setOnClickListener(new MyClickListener(EventActivity.this));

        btnMy = findViewById(R.id.btn_my);
        btnMy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.d("listener", "---onTouch---");
                }
                return false;
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("listener", "---onClick---");
            }
        });

        btnMy.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_event:
                ToastUtil.showMsg(EventActivity.this, "click.....");
                break;
        }
    }


    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_event:
                    Log.d("内部类", "onclick...");
                    ToastUtil.showMsg(EventActivity.this, "click.....");
                    break;
            }
        }
    }

//    public void  show(View v){
//        switch (v.getId()){
//            case R.id.btn_event:
//                ToastUtil.showMsg(EventActivity.this, "click.....");
//                break;
//        }
//    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("MyButton", "---dispatchTouchEvent---");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("Activity", "---onTouch---");
                break;
        }
        return false;
    }
}