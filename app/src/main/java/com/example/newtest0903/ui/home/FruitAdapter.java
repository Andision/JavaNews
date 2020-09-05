package com.example.newtest0903.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.newtest0903.R;
import com.example.newtest0903.news.NewsActivity;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;
//    private List<Fruit> newFruitList;

    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View

    private boolean hasMore = false;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }

    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return footType;
        } else {
            return normalType;
        }
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == normalType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.foot_view, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        if(holder.getItemViewType()==normalType){

            Fruit fruit = mFruitList.get(position);
            holder.fruitName.setText(fruit.getName());
            holder.fruitName.setGravity(Gravity.CENTER);
//        holder.fruitName.setWidth(get);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(holder.fruitName.getContext(), "我被点击了", Toast.LENGTH_SHORT).show();
                    Bundle bundle=new Bundle();
                    bundle.putInt("id",position);
                    bundle.putString("name",mFruitList.get(position).getName());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(holder.fruitName.getContext(), NewsActivity.class);
//                startActivity(intent);
                    holder.fruitName.getContext().startActivity(intent);
                }
            });
        }
        else{
            // 之所以要设置可见，是因为我在没有更多数据时会隐藏了这个footView
            holder.fruitName.setVisibility(View.VISIBLE);
//            holder.fruitName.setText("EENNDD");
            // 只有获取数据为空时，hasMore为false，所以当我们拉到底部时基本都会首先显示“正在加载更多...”
            if (hasMore == true) {
                // 不隐藏footView提示
//                fadeTips = false;
                if (mFruitList.size() > 0) {
                    // 如果查询数据发现增加之后，就显示正在加载更多
                    holder.fruitName.setText("Loading...");
                }
            }
            else {
                if (mFruitList.size() > 0) {
                    // 如果查询数据发现并没有增加时，就显示没有更多数据了
                    holder.fruitName.setText("Loading... No more");

                    // 然后通过延时加载模拟网络请求的时间，在500ms后执行
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // 隐藏提示条
//                            ((FootHolder) holder).tips.setVisibility(View.GONE);
                            holder.fruitName.setVisibility(View.GONE);
                            // 将fadeTips设置true
//                            fadeTips = true;
                            // hasMore设为true是为了让再次拉到底时，会先显示正在加载更多
                            hasMore = true;
                        }
                    }, 500);
                }
            }

        }
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
