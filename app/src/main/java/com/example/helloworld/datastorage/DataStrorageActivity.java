package com.example.helloworld.datastorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class DataStrorageActivity extends AppCompatActivity {

    private Button mBtnSharedPreferences;
    private Button mBtnFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_strorage);
        mBtnSharedPreferences=findViewById(R.id.btn_sharepredferences);
        mBtnFile=findViewById(R.id.btn_file);
        mBtnSharedPreferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataStrorageActivity.this,SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });

        mBtnFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DataStrorageActivity.this,FileActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v){
        Intent intent=null;
        switch (v.getId()){
            case R.id.btn_sharepredferences:

                break;
        }
    }
}