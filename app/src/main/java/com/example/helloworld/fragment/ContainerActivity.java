package com.example.helloworld.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.IOnMessageClick {
    private AFragment aFragment;
    private TextView mTvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mTvTitle=findViewById(R.id.tv_title);
        //实例化AFragment
        aFragment = AFragment.newInstance("我是参数");
        //把AFrament添加到Activity中,记得调用commit
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, aFragment,"a").commitAllowingStateLoss();

    }

    public void sendData(String text){
        mTvTitle.setText(text);
    };

    @Override
    public void onClick(String text) {
        mTvTitle.setText(text);
    }

}