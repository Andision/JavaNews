package com.example.CONVID19News.ui.home.news;

import android.webkit.JavascriptInterface;

/**
 * Created by loonggg on 2017/5/11.
 */
public class NewsItem {
    private String name="name";
    private String age;
    private String sex;

    @JavascriptInterface
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @JavascriptInterface
    public String getSex() {
        return sex;
    }

    @JavascriptInterface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


