package com.example.CONVID19News.ui.home;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.database.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class SearchResultActivity extends Activity {

    private List<Fruit> fruitList = new ArrayList<>();
    String SearchWord="%";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_news);

        Bundle bundle=this.getIntent().getExtras();
        SearchWord+=bundle.getString("s")+"%";

        initFruits();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.newslist);
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new SimplePaddingDecoration(getActivity()));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this, "mydatabase", null, 1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        final FruitAdapter adapter = new FruitAdapter(fruitList, sqliteDatabase, "NEWS");
        recyclerView.setAdapter(adapter);


//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_searchhistroy);
//        recyclerView.setHasFixedSize(true);
//
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        final SearchHistoryAdapter adapter = new SearchHistoryAdapter(fruitList);
//        recyclerView.setAdapter(adapter);


    }

    private void initFruits() {

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this, "mydatabase", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor result;

            result = db.rawQuery("select * from news where content like ?",new String[]{SearchWord});
//            result = db.rawQuery("select * from paper", new String[]{});


        result.moveToLast();
        while (!result.isBeforeFirst()) {
            int id = result.getInt(0);
            String title = result.getString(1);
            String date = result.getString(2);
            String ffrom = result.getString(3);
            String ccontent = result.getString(4);
//            System.out.println(title+date+ffrom);
            // do something useful with these
            Fruit myInsert = new Fruit(title, date, ffrom, ccontent, result.getInt(5));
            fruitList.add(myInsert);

            result.moveToPrevious();
        }
        result.close();




//        for (int i = 0; i < 20; i++) {
//            Fruit apple = new Fruit("SearchHistory:" + i);
//            fruitList.add(apple);
//        }
    }
}





