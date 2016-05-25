package com.pythoncat.styleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_v);
        // 设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置adapter
        ArrayList<Bean> been = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            Bean obj = new Bean();
            obj.name = "我是第: " + i + " 个Item";
            ///////////////////////////
            been.add(obj);
        }

        HomeAdapter adapter = new HomeAdapter(this, been);
        adapter.setmRecyclerView(mRecyclerView);
        mRecyclerView.setAdapter(adapter);
        // 设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
