package com.example.newtest0903.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newtest0903.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private String mFrom;

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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, getData());
        ListView listView = (ListView) view.findViewById(R.id.newslist);
        listView.setAdapter(arrayAdapter);
        //set newslist********************************************************
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
        //set swiprefresh----------------------------------------------------


        //set swiprefresh*****************************************************

        return view;
    }

    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        for(int i = 0;i <20;i++) {
            data.add(i+"");
        }
        return data;
    }

}


