package com.example.helloworld;

import android.app.Activity;
import android.view.View;

import com.example.helloworld.util.ToastUtil;

/**
 * Created by Royal on 2021/3/17.
 * Describle:
 */
public class MyClickListener implements View.OnClickListener{

    private Activity mActivity;
    public MyClickListener(Activity activity){
        this.mActivity=activity;
    };

    @Override
    public void onClick(View v) {
        ToastUtil.showMsg(mActivity, "click.....");

    }
}
