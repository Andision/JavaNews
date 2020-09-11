package com.example.CONVID19News.start;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.example.CONVID19News.MainActivity;
import com.example.CONVID19News.R;
import com.example.CONVID19News.bean.AtlasModel;
import com.example.CONVID19News.bean.CountryModel;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.bean.PaperlistModel;
import com.example.CONVID19News.bean.ScholarModel;
import com.example.CONVID19News.database.DatabaseHelper;
import com.example.CONVID19News.http.Url;
import com.example.CONVID19News.http.deal;
import com.example.CONVID19News.http.httpurl;
import com.example.CONVID19News.http.json.NewsAtlasJson;
import com.example.CONVID19News.http.json.NewsCountryJson;
import com.example.CONVID19News.http.json.NewsListJson;
import com.example.CONVID19News.http.json.NewsScholarJson;
import com.example.CONVID19News.http.json.PaperListJson;
import com.example.CONVID19News.myData;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends Activity {

    private static int SPLASH_DISPLAY_LENGHT = 3000;    //延迟2秒

    @Override
    protected synchronized void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_splash);

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this, "mydatabase", null, 1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();
//
        new Thread() {
            @Override
            public void run() {
//线程要执行的任务
                super.run();
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
        }.start();


        new Thread() {
            @Override
            public void run() {
                super.run();
                //论文列表
                Url tt = new Url();
                String xp = tt.getUrl("paper", myData.getPaperURLPage());
                httpurl xpp = new httpurl();
                String datap = xpp.pub(xp);
                List<PaperlistModel> paperlist = new ArrayList<PaperlistModel>();
                PaperListJson pp = new PaperListJson();
                try {
                    paperlist = pp.jxPaperlist(datap);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < paperlist.size(); i++) {
                    PaperlistModel paperInsert = paperlist.get(i);
//                    System.out.println(paperlist.get(i).toString());

                    ContentValues values = new ContentValues();
                    values.put("title", paperInsert.getTitle());
                    values.put("date", paperInsert.getDate());
                    values.put("ffrom", paperInsert.getAuthors());
                    values.put("content", paperInsert.getContent());
                    sqliteDatabase.insert("paper", null, values);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
//线程要执行的任务
                super.run();

                //各国各省数据
                Url cou = new Url();
                String xcou = cou.getCountryUrl();
                httpurl xxcou = new httpurl();
                String datacou = xxcou.pub(xcou);
                List<CountryModel> allModels = new ArrayList<CountryModel>();
                List<CountryModel> countryModels = new ArrayList<CountryModel>();
                List<CountryModel> provinceModels = new ArrayList<CountryModel>();
                List<CountryModel> cityModels = new ArrayList<CountryModel>();
                NewsCountryJson cy = new NewsCountryJson();
                try {
                    allModels = cy.jxCountry(datacou);
                    deal tr = new deal();
                    countryModels = tr.deal_Split(allModels, 0);
                    provinceModels = tr.deal_Split(allModels, 1);
                    cityModels = tr.deal_Split(allModels, 2);
//                    for (int i = 0; i <countryModels.size() ; i++) {
//                        System.out.println(countryModels.get(i).toString());
//                    }
//                    for (int i = 0; i < provinceModels.size(); i++) {
//                        System.out.println(provinceModels.get(i).toString());
//                    }
//                    for (int i = 0; i < cityModels.size(); i++) {
//                        System.out.println(cityModels.get(i).toString());
//                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                myData.setCountry(provinceModels);
                myData.setChina(countryModels);

            }
        }.start();
//
        new Thread() {
            @Override
            public void run() {
                super.run();
                //防疫学者
                Url ff=new Url();
                String xf=ff.getScholarUrl();
                httpurl xff=new httpurl();
                String dataf=xff.pub(xf);
                List<ScholarModel> scholarlist=new ArrayList <ScholarModel>();
                NewsScholarJson fy=new NewsScholarJson();
                try {
                    scholarlist=fy.jxScholar(dataf);
                    myData.setScholar(scholarlist);

//                    for(int i=0;i<scholarlist.size();i++)
//                        System.out.println(scholarlist.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();



        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);    //第二个参数即为执行完跳转后的Activity
                startActivity(intent);
                SplashActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}

