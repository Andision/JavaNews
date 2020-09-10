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

public class RelationAdapter extends RecyclerView.Adapter<RelationAdapter.ViewHolder> {

    private List<Fruit> mRelationList;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView fruitName;

        public ViewHolder(View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.relationname);
        }

    }

    public RelationAdapter(List<Fruit> fruitList) {
        mRelationList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_relation, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;

//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


            Fruit fruit = mRelationList.get(position);
            holder.fruitName.setText(fruit.getName());

            RelationAdapter relationAdapter=new RelationAdapter(mRelationList);

//            holder.fruitName.setText(Html.fromHtml("<p>" + fruit.getTitle() + "</p>\n" +
//                    "<span><small>" + fruit.getDate() + "</small></span>\n" +
//                    "<span><small>" + fruit.getFrom() + "</small></span>"));

    }

    @Override
    public int getItemCount() {
        return mRelationList.size();
    }
}
