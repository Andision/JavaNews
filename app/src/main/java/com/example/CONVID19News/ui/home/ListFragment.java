package com.example.CONVID19News.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.CONVID19News.R;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.bean.PaperlistModel;
import com.example.CONVID19News.database.DatabaseHelper;
import com.example.CONVID19News.http.Url;
import com.example.CONVID19News.http.httpurl;
import com.example.CONVID19News.http.json.NewsListJson;
import com.example.CONVID19News.http.json.PaperListJson;
import com.example.CONVID19News.myData;
//import com.example.newtest0903.news.NewsActivity;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private String mFrom;
    private List<Fruit> fruitList = new ArrayList<>();

    String myType;

    public ListFragment() {
        // Required empty public constructor
    }

    public ListFragment(String t) {
        // Required empty public constructor
        myType = t;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFrom = (String) getArguments().get("from");
        }
    }

    @Override
    public synchronized View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //set newslist------------------------------------------------------
        initFruits();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.newslist);
        recyclerView.setHasFixedSize(true);
//        recyclerView.addItemDecoration(new SimplePaddingDecoration(getActivity()));

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        final FruitAdapter adapter = new FruitAdapter(fruitList, sqliteDatabase, myType);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int lastVisibleItem;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }

            @Override
            public synchronized void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == adapter.getItemCount() - 1) {
//                    && mAdapter.isShowFooter() && !mPresenter.isLoading()


//                    adapter.appendNewsList();

                    SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
                    final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
                    new Thread() {
                        @Override
                        public void run() {
//线程要执行的任务
                            super.run();
                            if (myType == "NEWS") {


                                //新闻列表
                                Url tt = new Url();
                                String x = tt.getUrl("news", myData.getNewsURLPage());

                                httpurl xx = new httpurl();
                                String data = xx.pub(x);
                                List<NewslistModel> newslist = new ArrayList<NewslistModel>();
                                NewsListJson cc = new NewsListJson();
                                try {
                                    newslist = cc.jxNewslist(data);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                for (int i = 0; i < newslist.size(); i++) {
                                    NewslistModel newsInsert = newslist.get(i);
//                    System.out.println(newslist.get(i).toString());
                                    ContentValues values = new ContentValues();
                                    values.put("title", newsInsert.getTitle());
                                    values.put("date", newsInsert.getDate());
                                    values.put("ffrom", newsInsert.getFrom());
                                    values.put("content", newsInsert.getContent());
                                    sqliteDatabase.insert("news", null, values);

                                }
                            }
                            else{
                                //论文列表
                                Url tt=new Url();
                                String xp=tt.getUrl("paper",myData.getPaperURLPage());
                                httpurl xpp=new httpurl();
                                String datap= xpp.pub(xp);
                                List<PaperlistModel> paperlist=new ArrayList <PaperlistModel>();
                                PaperListJson pp=new PaperListJson();
                                try {
                                    paperlist=pp.jxPaperlist(datap);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                for (int i=0;i<paperlist.size();i++)
                                {
                                    PaperlistModel paperInsert=paperlist.get(i);

                                    ContentValues values = new ContentValues();
                                    values.put("title", paperInsert.getTitle());
                                    values.put("date", paperInsert.getDate());
                                    values.put("ffrom", paperInsert.getAuthors());
                                    values.put("content", paperInsert.getContent());
                                    sqliteDatabase.insert("paper", null, values);
//                                    System.out.println(paperlist.get(i).toString());
                                }
                            }
                            adapter.appendNewsList(sqliteDatabase);

                        }
                    }.start();

//                    adapter.notifyDataSetChanged();

//                    Toast.makeText(getActivity(), "SCROLL"+lastVisibleItem+"Total"+adapter.getItemCount(),Toast.LENGTH_SHORT).show();
                }

            }
        });


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
        final SwipeRefreshLayout swiprefresh = view.findViewById(R.id.swiperefresh);
        swiprefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
                final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
                new Thread() {
                    @Override
                    public void run() {
//线程要执行的任务
                        super.run();

                        if (myType == "NEWS") {


                            //新闻列表
                            Url tt = new Url();
                            String x = tt.getUrl("news", myData.getNewsURLPage());

                            httpurl xx = new httpurl();
                            String data = xx.pub(x);
                            List<NewslistModel> newslist = new ArrayList<NewslistModel>();
                            NewsListJson cc = new NewsListJson();
                            try {
                                newslist = cc.jxNewslist(data);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            for (int i = 0; i < newslist.size(); i++) {
                                NewslistModel newsInsert = newslist.get(i);
//                    System.out.println(newslist.get(i).toString());
                                ContentValues values = new ContentValues();
                                values.put("title", newsInsert.getTitle());
                                values.put("date", newsInsert.getDate());
                                values.put("ffrom", newsInsert.getFrom());
                                values.put("content", newsInsert.getContent());
                                sqliteDatabase.insert("news", null, values);

                            }
                            adapter.appendNewsListFirst(newslist, swiprefresh);
                        }
                        else{
                            //论文列表
                            Url tt=new Url();
                            String xp=tt.getUrl("paper",myData.getPaperURLPage());
                            httpurl xpp=new httpurl();
                            String datap= xpp.pub(xp);
                            List<PaperlistModel> paperlist=new ArrayList <PaperlistModel>();
                            PaperListJson pp=new PaperListJson();
                            try {
                                paperlist=pp.jxPaperlist(datap);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            for (int i=0;i<paperlist.size();i++)
                            {
                                PaperlistModel paperInsert=paperlist.get(i);

                                ContentValues values = new ContentValues();
                                values.put("title", paperInsert.getTitle());
                                values.put("date", paperInsert.getDate());
                                values.put("ffrom", paperInsert.getAuthors());
                                values.put("content", paperInsert.getContent());
                                sqliteDatabase.insert("paper", null, values);
//                                    System.out.println(paperlist.get(i).toString());
                            }
                            adapter.appendPaperListFirst(paperlist, swiprefresh);
                        }

                    }
                }.start();


                //模拟网络请求需要3000毫秒，请求完成，设置setRefreshing 为false
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getActivity(), "Refresh Finish!!",
//                                Toast.LENGTH_SHORT).show();
//
//
//                        adapter.appendNewsListFirst();
//                        adapter.notifyDataSetChanged();
//
//
//
//
//                        swiprefresh.setRefreshing(false);
//                    }
//                }, 3000);
            }
        });

        //set swiprefresh*****************************************************

        return view;
    }

    void finishGet() {

    }

    private synchronized void initFruits() {
//        Fruit aaa = new Fruit(test);
//        fruitList.add(aaa);


        SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor result;

        if (myType == "NEWS") {
            result = db.rawQuery("select * from news", new String[]{});
        } else {
            result = db.rawQuery("select * from paper", new String[]{});
        }

        int num_count=0;


        result.moveToLast();
        while (!result.isBeforeFirst()) {
            num_count++;
            if(num_count>50)break;

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

    }

}