package com.example.CONVID19News.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
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


        SearchView searchView=findViewById(R.id.view_search);
//        searchView.setQueryHint("Search");
//        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);
        searchView.setFocusable(true);
//        searchView.setFocusable(false);
//        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单机搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法内执行实际查询，此处仅使用Toast显示用户输入的查询内容
//                Toast.makeText(getActivity(), "Your Input: " + query,Toast.LENGTH_SHORT).show();
                return false;
            }

            //用户输入字符时激发该方法
            @Override
            public boolean onQueryTextChange(String newText) {
//                //如果newText不是长度为0的字符串
//                if (TextUtils.isEmpty(newText)) {
//                    //清除ListView的过滤
//                    listView.clearTextFilter();
//                } else {
//                    //使用用户输入的内容对ListView的列表项进行过滤
//                    listView.setFilterText(newText);
//                }
                return true;
            }
        });


    }

    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit("SearchHistory:" + i);
            fruitList.add(apple);
        }
    }
}





