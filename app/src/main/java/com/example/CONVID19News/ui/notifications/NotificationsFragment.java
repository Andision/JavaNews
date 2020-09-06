package com.example.CONVID19News.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.CONVID19News.R;
import com.example.CONVID19News.ui.home.ListFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private List<Fragment> fragmentList = new ArrayList<Fragment>();
    private String[] strings = new String[]{"A","B","C","D"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

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