package com.example.CONVID19News.ui.home;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.background.bean.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends Activity {

    private List<Fruit> fruitList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        fruitList = new ArrayList<>();

        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_searchhistroy);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SearchView searchView=findViewById(R.id.view_search);

        final SearchHistoryAdapter adapter = new SearchHistoryAdapter(fruitList,searchView);
        recyclerView.setAdapter(adapter);



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
                Bundle bundle = new Bundle();
                bundle.putString("s", query);


//                bundle.putString("date", mFruitList.get(position).getDate());
//                bundle.putString("from", mFruitList.get(position).getFrom());
//                bundle.putString("content", mFruitList.get(position).getContent());
//                intent.putExtras(bundle);
//                startActivity(intent);

                getSearchResult(bundle,query);

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

    private synchronized void initFruits() {

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this, "mydatabase", null, 1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();

        Cursor result=sqliteDatabase.rawQuery("select * from searchhistory", new String[]{});

        result.moveToFirst();
        while (!result.isAfterLast()) {
            int id = result.getInt(0);
            String title = result.getString(1);

//            System.out.println(title+date+ffrom);
            // do something useful with these
            Fruit apple = new Fruit(title);
            fruitList.add(apple);

            result.moveToNext();
        }
        result.close();


//        for (int i = 0; i < 20; i++) {
//            Fruit apple = new Fruit("SearchHistory:" + i);
//            fruitList.add(apple);
//        }
    }

    synchronized void getSearchResult(Bundle bun,String s){

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this, "mydatabase", null, 1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", s);
        sqliteDatabase.insert("searchhistory", null, values);



        Intent intent = new Intent();
        intent.putExtras(bun);
        intent.setClass(this, SearchResultActivity.class);
        startActivityForResult(intent,200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onCreate(null);
    }
}





