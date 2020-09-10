package com.example.CONVID19News.ui.notifications;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.ui.home.Fruit;

import java.util.List;

public class KGEntityAdapter extends RecyclerView.Adapter<KGEntityAdapter.ViewHolder> {

    private List<KGEntity> mFruitList;
    private List<Fruit> mRelationList;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;
        RecyclerView relationRecycler;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.entityname);
            relationRecycler=view.findViewById(R.id.relationlist);
        }

    }

    public KGEntityAdapter(List<KGEntity> fruitList) {
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


            KGEntity fruit = mFruitList.get(position);
            holder.fruitName.setText(fruit.getName());

        RelationAdapter adapter = new RelationAdapter(mRelationList);
        holder.relationRecycler.setAdapter(adapter);

//            holder.fruitName.setText(Html.fromHtml("<p>" + fruit.getTitle() + "</p>\n" +
//                    "<span><small>" + fruit.getDate() + "</small></span>\n" +
//                    "<span><small>" + fruit.getFrom() + "</small></span>"));

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }
}
