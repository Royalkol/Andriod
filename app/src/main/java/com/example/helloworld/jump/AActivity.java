package com.example.helloworld.jump;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;
import com.example.helloworld.util.ToastUtil;

public class AActivity extends AppCompatActivity {

    private Button mbtnJump,mbtnJump2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
        Log.d("AActivity","---onNewIntent---");
        Log.d("AActivtiy","taskid"+getTaskId()+"  ,hash"+hashCode());
        logtaskname();
        mbtnJump = findViewById(R.id.Jump);
        mbtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                显示1
                Intent intent = new Intent(AActivity.this, BActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name","美男");
                bundle.putInt("age",18);
                intent.putExtras(bundle);
                startActivity(intent);
                //回调数据
//                startActivityForResult(intent,0);

                //显示 2
//                Intent intent =new Intent();
//                intent.setClass(AActivity.this,BActivity.class);
//                startActivity(intent);

                //显示3
//                Intent intent =new Intent();
//                intent.setClassName(AActivity.this,"com.example.helloworld.jump.BActivity");
//                startActivity(intent);

//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(AActivity.this,"com.example.helloworld.jump.BActivity"));
//                startActivity(intent);

                //隐式调用
//                Intent intent = new Intent();
//                intent.setAction("com.royal.test.BActivity");
//                startActivity(intent);
            }
        });

        mbtnJump2=findViewById(R.id.jump_2);
        mbtnJump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(AActivity.this,AActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ToastUtil.showMsg(AActivity.this,data.getExtras().getString("title"));
    }

    @Override
    protected void  onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("AActivity","---oncreate---");
        Log.d("AActivtiy","taskid"+getTaskId()+"  ,hash"+hashCode());
        logtaskname();
    }

    private void logtaskname(){
        try {
            ActivityInfo info =getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("AActivity",info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}