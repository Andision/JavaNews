package com.example.newtest0903.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.newtest0903.R;
import com.example.newtest0903.news.NewsItem;

public class TabEditActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_notifications);

//        WebView webView=findViewById(R.id.webView);

//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setBlockNetworkImage(false);
//        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//
//        final NewsItem newsItem=new NewsItem();
//        newsItem.setName("TABEDITBTN");
//        webView.addJavascriptInterface(newsItem,"ads");
//
//        webView.loadUrl("file:///android_asset/index.html");
//
//        webView.setWebViewClient(new WebViewClient(){
////            @Override
////            public boolean shouldOverrideUrlLoading(WebView view, String url) {
////                view.loadUrl(url);
////                return true;
////            }
//            @Override
//            public void onPageFinished(WebView webView, String url) {
//
//                //执行代码
//
//                webView.loadUrl("javascript:callJS()");
//
//            }
//        });

    }

}
