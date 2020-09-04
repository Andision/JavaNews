package com.example.newtest0903.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.newtest0903.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private String[] strings = new String[]{"A","B","C","D"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //set viewpager---------------------------------------------
        fragmentList.add(new ListFragment());
        fragmentList.add(new ListFragment());
        fragmentList.add(new ListFragment());
        fragmentList.add(new ListFragment());

        TabLayout tab_layout = root.findViewById(R.id.tab_layout);
        ViewPager viewPager = root.findViewById(R.id.vp);
        MyFragmentAdapter fragmentAdapter = new MyFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentAdapter);
        tab_layout.setupWithViewPager(viewPager);
        //set viewpager*********************************************





        //set SearchView--------------------------------------------
        SearchView searchView=root.findViewById(R.id.view_search);
//        searchView.setQueryHint("Search");
//        searchView.setIconified(false);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //单机搜索按钮时激发该方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在该方法内执行实际查询，此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(getActivity(), "Your Input: " + query,
                        Toast.LENGTH_SHORT).show();
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


        //set SearchView**********************************************






        return root;
    }


    public class MyFragmentAdapter extends FragmentPagerAdapter {
        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }



}