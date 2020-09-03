package com.example.newtest0903.ui.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newtest0903.R;

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

        return view;
    }

}


