package com.example.CONVID19News.ui.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.CONVID19News.R;
import com.example.CONVID19News.background.bean.AtlasModel;
import com.example.CONVID19News.background.bean.http.Url;
import com.example.CONVID19News.background.bean.http.httpurl;
import com.example.CONVID19News.background.bean.http.json.NewsAtlasJson;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class KGSearchFragment extends Fragment{
    private List<AtlasModel> fruitList = new ArrayList<>();

    String myType;
    KGEntityAdapter adapter;
    RecyclerView recyclerView;
    View view;

    public KGSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public synchronized View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_kgsearch, container, false);


        SearchView searchView=view.findViewById(R.id.searchview_kg);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                Toast.makeText(getActivity(), "Your Input: " + s, Toast.LENGTH_SHORT).show();

                addNewEntity(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        //set newslist------------------------------------------------------
//        initFruits();
        recyclerView = (RecyclerView) view.findViewById(R.id.entitylist);
        recyclerView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setAutoMeasureEnabled(true);

//        SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
//        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
        adapter = new KGEntityAdapter(fruitList);
        recyclerView.setAdapter(adapter);
//
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            private int lastVisibleItem;
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//            }
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem == adapter.getItemCount() - 1) {
////                    && mAdapter.isShowFooter() && !mPresenter.isLoading()
//
//
////                    adapter.appendNewsList();
//
//                    SQLiteOpenHelper dbHelper = new DatabaseHelper(getActivity(), "mydatabase", null, 1);
//                    final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
//                    new Thread() {
//                        @Override
//                        public void run() {
////线程要执行的任务
//                            super.run();
//                            if (myType == "NEWS") {
//
//
//                                //新闻列表
//                                Url tt = new Url();
//                                String x = tt.getUrl("news", myData.getNewsURLPage());
//
//                                httpurl xx = new httpurl();
//                                String data = xx.pub(x);
//                                List<NewslistModel> newslist = new ArrayList<NewslistModel>();
//                                NewsListJson cc = new NewsListJson();
//                                try {
//                                    newslist = cc.jxNewslist(data);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                                for (int i = 0; i < newslist.size(); i++) {
//                                    NewslistModel newsInsert = newslist.get(i);
////                    System.out.println(newslist.get(i).toString());
//                                    ContentValues values = new ContentValues();
//                                    values.put("title", newsInsert.getTitle());
//                                    values.put("date", newsInsert.getDate());
//                                    values.put("ffrom", newsInsert.getFrom());
//                                    values.put("content", newsInsert.getContent());
//                                    sqliteDatabase.insert("news", null, values);
//
//                                }
//                            }
//                            else{
//                                //论文列表
//                                Url tt=new Url();
//                                String xp=tt.getUrl("paper",myData.getPaperURLPage());
//                                httpurl xpp=new httpurl();
//                                String datap= xpp.pub(xp);
//                                List<PaperlistModel> paperlist=new ArrayList <PaperlistModel>();
//                                PaperListJson pp=new PaperListJson();
//                                try {
//                                    paperlist=pp.jxPaperlist(datap);
//                                } catch (JSONException e) {
//                                    e.printStackTrace();
//                                }
//                                for (int i=0;i<paperlist.size();i++)
//                                {
//                                    PaperlistModel paperInsert=paperlist.get(i);
//
//                                    ContentValues values = new ContentValues();
//                                    values.put("title", paperInsert.getTitle());
//                                    values.put("date", paperInsert.getDate());
//                                    values.put("ffrom", paperInsert.getAuthors());
//                                    values.put("content", paperInsert.getContent());
//                                    sqliteDatabase.insert("paper", null, values);
////                                    System.out.println(paperlist.get(i).toString());
//                                }
//                            }
//                            adapter.appendNewsList(sqliteDatabase);
//
//                        }
//                    }.start();
//
////                    adapter.notifyDataSetChanged();
//
////                    Toast.makeText(getActivity(), "SCROLL"+lastVisibleItem+"Total"+adapter.getItemCount(),Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

        return view;
    }

    private void addNewEntity(final String sw) {
        fruitList = new ArrayList<AtlasModel>();
        adapter = new KGEntityAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        new Thread() {
            @Override
            public void run() {
                super.run();
//新闻图谱
                Url aa=new Url();
                String xa=aa.getAtlasUrl(sw);
                httpurl xaa=new httpurl();
                String dataa=xaa.pub(xa);
                List<AtlasModel> atlasModelslist=new ArrayList <AtlasModel>();
                NewsAtlasJson ay=new NewsAtlasJson();
                try {
                    atlasModelslist=ay.jxAtlas(dataa);
                    if(atlasModelslist.size()==0){
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                TextView tw=view.findViewById(R.id.noresult);
                                tw.setText("No Result");
                            }
                        });
                    }
                    for (int i=0;i<atlasModelslist.size();i++)
                    {
                        AtlasModel am=atlasModelslist.get(i);
                        System.out.println(atlasModelslist.get(i).toString());

                        adapter.insertNew(am);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter.insertFinish();
            }
        }.start();



    }

}
