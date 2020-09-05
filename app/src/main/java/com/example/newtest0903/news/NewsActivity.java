package com.example.newtest0903.news;

import android.app.Activity;
import android.app.Person;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.newtest0903.R;

public class NewsActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);

        WebView webView=findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        final NewsItem newsItem=new NewsItem();
        newsItem.setName("ANDROID SUCCESS");
        webView.addJavascriptInterface(newsItem,"ads");

        webView.loadUrl("file:///android_asset/index.html");

        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
            @Override
            public void onPageFinished(WebView webView, String url) {

                //执行代码

                webView.loadUrl("javascript:callJS()");

            }
        });

//        webView.loadUrl("http://andision.xyz");





//
//        webView.evaluateJavascript("callJS()",null);


//        Bundle bundle=this.getIntent().getExtras();
//        int id=bundle.getInt("id");
//        String name=bundle.getString("name");
//        TextView textView=findViewById(R.id.textview);
//        textView.setText("显示NEWS"+id+':'+name);

    }

}
