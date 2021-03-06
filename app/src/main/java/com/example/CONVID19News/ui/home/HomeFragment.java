package com.example.CONVID19News.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.CONVID19News.R;
import com.example.CONVID19News.myData;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
//    private static String[] strings = new String[]{"A","B","C","D"};
    private static String[] strings =myData.getTabStrings().toArray(new String[myData.getTabStrings().size()]);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //set viewpager---------------------------------------------
//        fragmentList.add(new ListFragment("1"));
//        fragmentList.add(new ListFragment("2"));
//        fragmentList.add(new ListFragment("3"));
//        fragmentList.add(new ListFragment("4"));
        strings =myData.getTabStrings().toArray(new String[myData.getTabStrings().size()]);
        for(int i=0;i<strings.length;i++){
            fragmentList.add(new ListFragment(strings[i]));
        }

        ViewPager viewPager = root.findViewById(R.id.vp);
        final MyFragmentAdapter fragmentAdapter = new MyFragmentAdapter(getChildFragmentManager());
        viewPager.setAdapter(fragmentAdapter);

        final TabLayout tab_layout = root.findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(viewPager);
        //set viewpager*********************************************





        //set SearchView--------------------------------------------

        TextView textView=root.findViewById(R.id.view_search);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "实现点击TextView事件", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent();
                intent.setClass(getActivity(), SearchActivity.class);
                startActivity(intent);
//                startActivityForResult(intent,100);
            }
        });


//        searchView=root.findViewById(R.id.view_search);
////        searchView.setQueryHint("Search");
////        searchView.setIconified(false);
//        searchView.setIconifiedByDefault(true);
////        searchView.setFocusable(false);
////        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            //单机搜索按钮时激发该方法
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                //实际应用中应该在该方法内执行实际查询，此处仅使用Toast显示用户输入的查询内容
//                Toast.makeText(getActivity(), "Your Input: " + query,Toast.LENGTH_SHORT).show();
//                searchView.clearFocus();
//                return false;
//            }
//
//            //用户输入字符时激发该方法
//            @Override
//            public boolean onQueryTextChange(String newText) {
////                //如果newText不是长度为0的字符串
////                if (TextUtils.isEmpty(newText)) {
////                    //清除ListView的过滤
////                    listView.clearTextFilter();
////                } else {
////                    //使用用户输入的内容对ListView的列表项进行过滤
////                    listView.setFilterText(newText);
////                }
//                return true;
//            }
//        });


        //set SearchView**********************************************


        //set TabEditButton--------------------------------------------
        Button tabEditButton=root.findViewById(R.id.button_tabedit);
        tabEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(), "TABEDITBTN", Toast.LENGTH_LONG).show();

//                tab_layout.removeTabAt(1);
//                fragmentList.remove(1);
//                fragmentAdapter.notifyDataSetChanged();
//                tab_layout.removeTabAt(1);
//                System.out.println(tab_layout.getScrollBarSize());
//                myData.deleteTabStringsItem(1);



                Intent intent = new Intent();
                intent.setClass(getActivity(), TabEditActivity.class);
//                startActivity(intent);
                startActivityForResult(intent,100);
            }
        });


        //set TabEditButton********************************************



        return root;
    }


    public class MyFragmentAdapter extends FragmentStatePagerAdapter {
        private long baseId = 0;

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return strings.length;
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


//        @Override
//        public int getItemPosition(Object object) {
//            // refresh all fragments when data set changed
//            return PagerAdapter.POSITION_NONE;
//        }

//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            ((ViewPager)container).removeView( (View) object);
//        }

    }



}