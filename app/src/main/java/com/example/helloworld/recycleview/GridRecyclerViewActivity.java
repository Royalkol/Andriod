package com.example.helloworld.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRvGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        mRvGrid = findViewById(R.id.rv_grid);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(GridRecyclerViewActivity.this, 3);
        gridLayoutManager.setOrientation(gridLayoutManager.HORIZONTAL);
        mRvGrid.setLayoutManager(gridLayoutManager);
        mRvGrid.setAdapter(new GrirdAdapter(GridRecyclerViewActivity.this, new GrirdAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this, "click" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}