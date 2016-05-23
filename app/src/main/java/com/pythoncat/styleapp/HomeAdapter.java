package com.pythoncat.styleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pythonCat on 2016/5/23.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private final Context context;
    private final List<Bean> mDatas;
    private RecyclerView mRecyclerView;

    public HomeAdapter(Context c, List<Bean> data) {
        this.context = c;
        this.mDatas = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Bean bean = mDatas.get(position);
        holder.tv.setText(bean.name);
        holder.toggleLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现方式一（效果非常好！ 顶部，底部都拉到屏幕可见区域了）
                for (int i = 0; i < mDatas.size(); i++) {
                    Bean b = mDatas.get(i);
                    if (b.check) {
                        //收起来
                        b.check = false;
                        mRecyclerView.smoothScrollToPosition(position);
                        notifyItemChanged(i);
                    } else if (b.equals(bean)) {
                        b.check = !b.check;
                        mRecyclerView.smoothScrollToPosition(position);
                        notifyItemChanged(i);
                    }
                }
//                //实现方式二 (顶部效果不佳，顶部的没有拉下来)
//                for (int i = 0; i < mDatas.size(); i++) {
//                    Bean b = mDatas.get(i);
//                    if (b.check) {
//                        //收起来
//                        b.check = false;
//                        mRecyclerView.smoothScrollToPosition(i);
//                        notifyItemChanged(i);
//                    } else if (b.equals(bean)) {
//                        b.check = !b.check;
//                        mRecyclerView.smoothScrollToPosition(i);
//                        notifyItemChanged(i);
//                    }
//                }
//                //实现方式三 (不可行！该方式不能隐藏没有被点击的Item)
//                for (int i = 0; i < mDatas.size(); i++) {
//                    Bean b = mDatas.get(i);
//                    if (b.check) {
//                        //收起来
//                        b.check = false;
//                        mRecyclerView.smoothScrollToPosition(position);
//                        notifyItemChanged(position);
//                    } else if (b.equals(bean)) {
//                        b.check = !b.check;
//                        mRecyclerView.smoothScrollToPosition(position);
//                        notifyItemChanged(position);
//                    }
//                }
            }
        });
        holder.showLayout.setVisibility(bean.check ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setmRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ViewGroup toggleLayout;
        ViewGroup showLayout;
        View v;

        public MyViewHolder(View view) {
            super(view);
            v = view;
            tv = (TextView) view.findViewById(R.id.tv_item_title);
            toggleLayout = (ViewGroup) view.findViewById(R.id.item_layout_1);
            showLayout = (ViewGroup) view.findViewById(R.id.item_layout_2);
        }
    }
}
