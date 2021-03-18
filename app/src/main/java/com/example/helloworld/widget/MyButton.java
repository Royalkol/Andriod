package com.example.helloworld.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by Royal on 2021/3/18.
 * Describle:
 */
public class MyButton extends androidx.appcompat.widget.AppCompatButton {
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       super.onTouchEvent(event);
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
       }
        Log.d("MyButton","---onTouch---");
        return false;
    }
}
