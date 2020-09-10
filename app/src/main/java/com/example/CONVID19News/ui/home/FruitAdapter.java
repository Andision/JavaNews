package com.example.CONVID19News.ui.home;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import com.example.CONVID19News.R;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.database.DatabaseHelper;
import com.example.CONVID19News.news.NewsActivity;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;
    SQLiteDatabase sqLiteDatabase;
//    private List<Fruit> newFruitList;

    private int normalType = 0;     // 第一种ViewType，正常的item
    private int footType = 1;       // 第二种ViewType，底部的提示View
    String myType;

    private boolean hasMore = false;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.fruitname);
        }

    }

    public FruitAdapter(List<Fruit> fruitList,SQLiteDatabase db,String mt) {
        mFruitList = fruitList;
        sqLiteDatabase=db;
        myType=mt;
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
//            holder.fruitName.setText(fruit.getName());

            holder.fruitName.setText(Html.fromHtml("<p>"+fruit.getTitle()+"</p>\n" +
                    "<span><small>"+fruit.getDate()+"</small></span>\n" +
                    "<span><small>"+fruit.getFrom()+"</small></span>"));

            if (fruit.isRead()==true){
                holder.fruitName.setTextColor(Color.parseColor("#BDBDBD"));
            }
            else{
                holder.fruitName.setTextColor(Color.parseColor("#000000"));
            }




//            holder.fruitName.setGravity(Gravity.CENTER);
//        holder.fruitName.setWidth(get);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Toast.makeText(holder.fruitName.getContext(), "我被点击了", Toast.LENGTH_SHORT).show();


                    mFruitList.get(position).setIsRead();

                    ContentValues values = new ContentValues();
                    values.put("isread", 1);

                    // b. 调用update方法修改数据库：将id=1 修改成 name = zhangsan
                    sqLiteDatabase.update(myType, values, "title=?", new String[] { mFruitList.get(position).getTitle() });
//                    sqliteDatabase.update("user", values, "id=?", new String[] { "1" });
                    // 参数1：表名(String)
                    // 参数2：需修改的ContentValues对象
                    // 参数3：WHERE表达式（String），需数据更新的行； 若该参数为 null, 就会修改所有行；？号是占位符
                    // 参数4：WHERE选择语句的参数(String[]), 逐个替换 WHERE表达式中 的“？”占位符;

                    // 注：调用完upgrate（）后，则会回调 数据库子类的onUpgrade()

                    // 注：也可采用SQL语句修改


                    Bundle bundle=new Bundle();
                    bundle.putString("title",mFruitList.get(position).getTitle());
                    bundle.putString("date",mFruitList.get(position).getDate());
                    bundle.putString("from",mFruitList.get(position).getFrom());
                    bundle.putString("content",mFruitList.get(position).getContent());
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    intent.setClass(holder.fruitName.getContext(), NewsActivity.class);
//                startActivity(intent);
//                    holder.fruitName.getContext().startActivity(intent);
                    ((Activity)holder.fruitName.getContext()).startActivityForResult(intent,100);
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
                    holder.fruitName.setText("Loading...");

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

    public void appendNewsList(SQLiteDatabase db) {
        mFruitList.clear();
//        SQLiteOpenHelper dbHelper = new DatabaseHelper(a,"mydatabase",null,1);
//        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor result=db.rawQuery("select * from news",new String[]{});
        result.moveToFirst();
        while (!result.isAfterLast()) {
            int id=result.getInt(0);
            String title=result.getString(1);
            String date =result.getString(2);
            String ffrom =result.getString(3);
            String ccontent =result.getString(4);
//            System.out.println(title+date+ffrom);
            // do something useful with these
            Fruit myInsert = new Fruit(title,date,ffrom,ccontent,result.getInt(5));
            mFruitList.add(myInsert);

            result.moveToNext();
        }
        result.close();

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });

//        notifyDataSetChanged();


//        for (int i = 0; i < 3; i++) {
//            Fruit apple = new Fruit("NNN");
//            mFruitList.add(apple);
//        }
    }

    public void appendNewsListFirst(List<NewslistModel> nl, final SwipeRefreshLayout swiprefresh) {

        for (int i = 0; i < nl.size(); i++) {
            NewslistModel newsInsert=nl.get(i);

            Fruit apple = new Fruit(newsInsert.getTitle(),newsInsert.getDate(),newsInsert.getFrom(),newsInsert.getContent(),0);
            mFruitList.add(0,apple);

        }

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
                swiprefresh.setRefreshing(false);
            }
        });




//        for (int i = 0; i < 3; i++) {
//            Fruit apple = new Fruit("NNN");
//            mFruitList.add(0,apple);
//        }
    }
}
