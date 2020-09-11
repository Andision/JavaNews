package com.example.CONVID19News.ui.dashboard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.bean.AtlasModel;
import com.example.CONVID19News.bean.ScholarModel;
import com.example.CONVID19News.http.httpurl;
import com.example.CONVID19News.news.NewsActivity;

import java.io.IOException;
import java.util.List;

public class ScholarAdapter extends RecyclerView.Adapter<ScholarAdapter.ViewHolder> {

    private List<ScholarModel> mFruitList;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView scholarname;
        TextView scholartitle;
        TextView scholarwordplace;
        ImageView scholarimg;


        public ViewHolder(View view) {
            super(view);
            scholarname = (TextView) view.findViewById(R.id.scholarname);
            scholartitle = (TextView) view.findViewById(R.id.scholartitle);
            scholarwordplace = (TextView) view.findViewById(R.id.scholarworkplace);
            scholarimg=view.findViewById(R.id.scholarimage);
        }

    }

    public ScholarAdapter(List<ScholarModel> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_scholar, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final ScholarModel fruit = mFruitList.get(position);


        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            holder.scholarimg.setImageResource(R.drawable.unfinish);
                        }
                    });

                    final Bitmap bm= httpurl.getBitmap(fruit.getAvator());


                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            holder.scholarimg.setImageBitmap(bm);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        holder.scholarname.setText(fruit.getName()+"  "+fruit.getName_zh());
        holder.scholartitle.setText(fruit.getPosition());
        holder.scholarwordplace.setText(fruit.getAffiliation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("name", fruit.getName()+"  "+fruit.getName_zh());
                bundle.putString("title", fruit.getPosition());
                bundle.putString("workplace", fruit.getAffiliation());
                bundle.putString("img", fruit.getAvator());
                bundle.putString("bio", fruit.getBio());
                bundle.putString("edu", fruit.getEdu());

                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(holder.scholarimg.getContext(), ScholarDetailsActivity.class);
                holder.scholarimg.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public void insertClear() {
        mFruitList.clear();
    }

    public void insertNew(ScholarModel am) {
        mFruitList.add(am);
    }

    public void insertFinish() {

        for (int i = 0; i < mFruitList.size(); i++)
//            System.out.println(mFruitList.get(i).getLabel());


        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }
}
