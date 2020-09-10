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
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.database.DatabaseHelper;
import com.example.CONVID19News.http.Url;
import com.example.CONVID19News.http.httpurl;
import com.example.CONVID19News.http.json.NewsListJson;
import com.example.CONVID19News.myData;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends Activity {

    private static int SPLASH_DISPLAY_LENGHT= 3000;    //延迟2秒

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_NO_TITLE);//去掉标题
        setContentView(R.layout.activity_splash);

        SQLiteOpenHelper dbHelper = new DatabaseHelper(this,"mydatabase",null,1);
        final SQLiteDatabase sqliteDatabase = dbHelper.getWritableDatabase();

        new Thread(){
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
                    NewslistModel newsInsert=newslist.get(i);
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

//        for(int i=0;i<20;i++){
//
//            ContentValues values = new ContentValues();
//            values.put("title", "title"+i);
//            values.put("date", "date"+i);
//            values.put("ffrom", "from"+i);
//            values.put("content", "content"+i);
//            sqliteDatabase.insert("news", null, values);
//        }

//        Intent intent = new Intent(this, MainActivity.class);	//第二个参数即为执行完跳转后的Activity
//        startActivity(intent);
//        SplashActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面


        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);	//第二个参数即为执行完跳转后的Activity
                startActivity(intent);
                SplashActivity.this.finish();   //关闭splashActivity，将其回收，否则按返回键会返回此界面
            }
        }, SPLASH_DISPLAY_LENGHT);
    }
}

