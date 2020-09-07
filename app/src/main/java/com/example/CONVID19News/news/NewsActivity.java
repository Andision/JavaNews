package com.example.CONVID19News.news;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.CONVID19News.R;

public class NewsActivity extends AppCompatActivity {


    //重写此方法在Activity中使用菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //第一个参数用于指定通过哪一个资源文件来创建菜单，第二个参数用于指定我们的菜单项将添加到哪一个Menu对象中
        getMenuInflater().inflate(R.menu.option_menu, menu);
        //返回true表示允许显示创建的菜单
        return true;
    }


    //重写此方法来定义菜单的响应事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //通过item.getItemId()来判断我们点击的是哪一个菜单项
        Toast.makeText(this, "You Click Menu", Toast.LENGTH_SHORT).show();

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        TextView news_title = findViewById(R.id.news_title);
        news_title.setText("显示NEWS_TITLE");

        TextView news_info = findViewById(R.id.news_info);
        news_info.setText("显示NEWS_INFO");

        TextView news_text = findViewById(R.id.news_text);
        news_text.setText("显示NEWS_TEXT");


//        ActionBar actionBar=getSupportActionBar();
//        actionBar.set


//
//        webView.evaluateJavascript("callJS()",null);


//        Bundle bundle=this.getIntent().getExtras();
//        int id=bundle.getInt("id");
//        String name=bundle.getString("name");
//        TextView textView=findViewById(R.id.textview);
//        textView.setText("显示NEWS"+id+':'+name);

    }

}
