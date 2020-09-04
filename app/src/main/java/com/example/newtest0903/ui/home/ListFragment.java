package com.example.newtest0903.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newtest0903.R;
import com.example.newtest0903.news.NewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private String mFrom;
    private List<Fruit> fruitList = new ArrayList<>();

    public ListFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String from){
        HomeFragment homeFragment = new HomeFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from",from);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            mFrom = (String) getArguments().get("from");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //set newslist------------------------------------------------------
        initFruits();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.newslist);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);


//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                getActivity(), android.R.layout.simple_list_item_1, getData());
//        ListView listView = (ListView) view.findViewById(R.id.newslist);
//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Bundle bundle=new Bundle();
//                bundle.putInt("name",i);
//                Intent intent = new Intent();
//                intent.putExtras(bundle);
//                intent.setClass(getActivity(),NewsActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager();
//
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            private int lastVisibleItem;
//
//
//            @Override
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//                Toast.makeText(getActivity(), "SCROLL"+lastVisibleItem,
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//                lastVisibleItem=linearLayoutManager.findLastVisibleItemPosition();
//            }
//        });
        //set newslist********************************************************

        //set swiprefresh----------------------------------------------------
        final SwipeRefreshLayout swiprefresh=view.findViewById(R.id.swiperefresh);
        swiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "Refresh Finish!!",
                                Toast.LENGTH_SHORT).show();
                        swiprefresh.setRefreshing(false);
                    }
                }, 3000);
            }
        });

        //set swiprefresh*****************************************************


//        //set btn test-----------
//        Button button=view.findViewById(R.id.btnOpen);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //textView.setText("Welcome!!");
//                Intent intent = new Intent();
//                intent.setClass(getActivity(),NewsActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //set btn test*************

        return view;
    }

    private void initFruits() {
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit("Apple");
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana");
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange");
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon");
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear");
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape");
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple");
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry");
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry");
            fruitList.add(cherry);
            Fruit mango = new Fruit("Mango");
            fruitList.add(mango);

        }
    }
}
//
//    private List<String> getData(){
//        List<String> data = new ArrayList<String>();
//        for(int i = 0;i <20;i++) {
//            data.add(i+"");
//        }
//        return data;
//    }




