package com.example.CONVID19News.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.background.bean.ScholarModel;
import com.example.CONVID19News.myData;

import java.util.ArrayList;
import java.util.List;

public class ScholarFragment extends Fragment {
    private List<ScholarModel> fruitList = new ArrayList<>();

    ScholarAdapter adapter;
    RecyclerView recyclerView;
    boolean isPassed;

    public ScholarFragment() {
        // Required empty public constructor
    }

    public ScholarFragment(boolean ip) {
        isPassed=ip;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scholar, container, false);


        //set newslist------------------------------------------------------
        initFruits();
        recyclerView = (RecyclerView) view.findViewById(R.id.scholar_list);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setAutoMeasureEnabled(true);

//        SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
//        final SQLiteDatabase sqliteDatabase = elper.getWritableDatabase();
        adapter = new ScholarAdapter(fruitList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private void initFruits() {
        List<ScholarModel> fl = myData.getScholar();
        for(int i=0;i<fl.size();i++){
            if(fl.get(i).getIs_passedaway()!=isPassed)continue;
            fruitList.add(fl.get(i));
        }

    }

}
