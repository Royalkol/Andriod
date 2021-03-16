package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.util.ToastUtil;
import com.example.helloworld.widget.CustomDialog;

public class CustomDialogActivity extends AppCompatActivity {

    private Button mBtnDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        mBtnDialog=findViewById(R.id.btn_custom_dialog);
        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog=new CustomDialog(CustomDialogActivity.this,R.style.CustomDialog);
                customDialog.setTitle("提示");
                customDialog.setMessage("确认删除此项？");
                customDialog.setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(Dialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"cancel....");
                    }
                });
                customDialog.setConfirm("确认", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onCanfirm(Dialog dialog) {
                        ToastUtil.showMsg(CustomDialogActivity.this,"confirm....");

                    }
                });
                customDialog.show();
             }
        });
    }
}