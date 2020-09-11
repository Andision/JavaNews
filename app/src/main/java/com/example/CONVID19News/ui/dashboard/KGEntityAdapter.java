package com.example.CONVID19News.ui.dashboard;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.background.bean.AtlasModel;
import com.example.CONVID19News.background.bean.http.httpurl;

import java.io.IOException;
import java.util.List;

public class KGEntityAdapter extends RecyclerView.Adapter<KGEntityAdapter.ViewHolder> {

    private List<AtlasModel> mFruitList;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;
        TextView entityWiki;
        TextView property_title;
        LinearLayout relationContainer;
        LinearLayout propertyContainer;
        ImageView entityimg;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.entityname);
            entityWiki = (TextView) view.findViewById(R.id.entitywiki);
            relationContainer = view.findViewById(R.id.relation_container);
            propertyContainer = view.findViewById(R.id.property_container);
            entityimg= view.findViewById(R.id.entityimage);
            property_title=view.findViewById(R.id.title_property);
        }

    }

    public KGEntityAdapter(List<AtlasModel> fruitList) {
        mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kgsearch_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final AtlasModel fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getLabel());

        holder.entityWiki.setText(fruit.getBaidu());

        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            holder.entityimg.setImageResource(R.drawable.unfinish);
                        }
                    });

                    final Bitmap bm=httpurl.getBitmap(fruit.getImg());


                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            holder.entityimg.setImageBitmap(bm);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();



        for (int i = 0; i < fruit.getRelations().size(); i++) {
            LinearLayout linearLayout = new LinearLayout(holder.relationContainer.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            TextView child = new TextView(holder.relationContainer.getContext());
            child.setWidth(400);
            child.setTextSize(20);
            String currentTime = fruit.getRelations().get(i).getRelation();
            child.setText(currentTime);
            linearLayout.addView(child);

            ImageView imageView = new ImageView(holder.relationContainer.getContext());
//            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
//                    android.widget.Gallery.LayoutParams.WRAP_CONTENT, android.widget.Gallery.LayoutParams.WRAP_CONTENT));
            imageView.setLayoutParams(new ImageSwitcher.LayoutParams(100,100));
            if (fruit.getRelations().get(i).getForward().equals("true"))
                imageView.setImageResource(R.drawable.subof);
            else
                imageView.setImageResource(R.drawable.belongto);
            linearLayout.addView(imageView);

            child = new TextView(holder.relationContainer.getContext());
            child.setWidth(800);
            child.setTextSize(20);
            currentTime = fruit.getRelations().get(i).getDt_label();
            child.setText(currentTime);
            linearLayout.addView(child);


            holder.relationContainer.addView(linearLayout);
        }


        for (int i = 0; i < fruit.getProperties().size(); i++) {
            LinearLayout linearLayout1 = new LinearLayout(holder.relationContainer.getContext());
            linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout1.setPadding(10,0,10,0);


            TextView child = new TextView(holder.relationContainer.getContext());
            child.setGravity(Gravity.CENTER);
            child.setTextSize(20);
            child.setWidth(300);
            child.setBackgroundColor(Color.parseColor("#F6CEEC"));

            String fs = fruit.getProperties().get(i).getSxmc();
            if (fs == "null") continue;
            holder.property_title.setText("PROPERTY");

            String currentTime = fs;
            child.setText(currentTime);
            linearLayout1.addView(child);


            child = new TextView(holder.relationContainer.getContext());
            child.setGravity(Gravity.LEFT);
            child.setGravity(1);
            child.setTextSize(20);
            currentTime = fruit.getProperties().get(i).getSxz();
            child.setText(currentTime);
            linearLayout1.addView(child);

            holder.propertyContainer.addView(linearLayout1);
        }


//            holder.fruitName.setText(Html.fromHtml("<p>" + fruit.getTitle() + "</p>\n" +
//                    "<span><small>" + fruit.getDate() + "</small></span>\n" +
//                    "<span><small>" + fruit.getFrom() + "</small></span>"));

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public void insertClear() {
        mFruitList.clear();
    }

    public void insertNew(AtlasModel am) {
        mFruitList.add(am);
    }

    public void insertFinish() {

        for (int i = 0; i < mFruitList.size(); i++)
            System.out.println(mFruitList.get(i).getLabel());


        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }
}
