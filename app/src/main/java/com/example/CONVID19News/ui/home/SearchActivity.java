package com.example.CONVID19News.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.CONVID19News.R;
import com.example.CONVID19News.myData;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_searchhistroy);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final SearchHistoryAdapter adapter = new SearchHistoryAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit("SearchHistory:" + i);
            fruitList.add(apple);
        }
    }
}





