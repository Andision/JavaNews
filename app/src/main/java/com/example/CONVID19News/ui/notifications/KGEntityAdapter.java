package com.example.CONVID19News.ui.notifications;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.bean.AtlasModel;
import com.example.CONVID19News.ui.home.Fruit;

import java.util.List;

public class KGEntityAdapter extends RecyclerView.Adapter<KGEntityAdapter.ViewHolder> {

    private List<AtlasModel> mFruitList;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;
        TextView entityWiki;
        LinearLayout relationContainer;
        LinearLayout propertyContainer;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.entityname);
            entityWiki = (TextView) view.findViewById(R.id.entitywiki);
            relationContainer = view.findViewById(R.id.relation_container);
            propertyContainer = view.findViewById(R.id.property_container);
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


        AtlasModel fruit = mFruitList.get(position);
        holder.fruitName.setText(fruit.getLabel());

        holder.entityWiki.setText(fruit.getBaidu());

        LinearLayout linearLayout = new LinearLayout(holder.relationContainer.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        for (int i = 0; i < fruit.getRelations().size(); i++) {


            TextView child = new TextView(holder.relationContainer.getContext());
            child.setTextSize(20);
//        child.setTextColor(getResources().getColor(R.color.colorAccent));
            // 获取当前的时间并转换为时间戳格式, 并设置给TextView
            String currentTime = fruit.getRelations().get(i).getRelation()+"         "+fruit.getRelations().get(i).getDt_label();
            child.setText(currentTime);
            // 调用一个参数的addView方法

            linearLayout.addView(child);
        }
        holder.relationContainer.addView(linearLayout);



        LinearLayout linearLayout1 = new LinearLayout(holder.relationContainer.getContext());
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        for (int i = 0; i < fruit.getProperties().size(); i++) {


            TextView child = new TextView(holder.relationContainer.getContext());
            child.setTextSize(20);
//        child.setTextColor(getResources().getColor(R.color.colorAccent));
            // 获取当前的时间并转换为时间戳格式, 并设置给TextView

            String fs=fruit.getProperties().get(i).getSxmc();
            if(fs=="null")continue;
            String currentTime = fs+"         "+fruit.getProperties().get(i).getSxz();
            child.setText(currentTime);
            // 调用一个参数的addView方法

            linearLayout1.addView(child);
        }
        holder.propertyContainer.addView(linearLayout1);




//            holder.fruitName.setText(Html.fromHtml("<p>" + fruit.getTitle() + "</p>\n" +
//                    "<span><small>" + fruit.getDate() + "</small></span>\n" +
//                    "<span><small>" + fruit.getFrom() + "</small></span>"));

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public void insertClear(){
        mFruitList.clear();
    }

    public void insertNew(AtlasModel am){
        mFruitList.add(am);
    }

    public void insertFinish(){

        for(int i=0;i<mFruitList.size();i++)
            System.out.println(mFruitList.get(i).getLabel());


        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                notifyDataSetChanged();
            }
        });
    }
}
