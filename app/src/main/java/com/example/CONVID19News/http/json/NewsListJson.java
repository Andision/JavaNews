package com.example.CONVID19News.http.json;
import com.example.CONVID19News.bean.NewslistModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.json.JSONException;

public class NewsListJson
{
  public List<NewslistModel> jxNewslist(String json) throws JSONException {
      List<NewslistModel> newslist=new ArrayList<NewslistModel>();
try{
    if (json==null||json.equals(""))
    {return null;}

    JSONObject jsonObject= new JSONObject(json);
    JSONArray dataJson=jsonObject.getJSONArray("data");
    for (int i=0;i<10&&i<dataJson.length();i++)
    {
        JSONObject tmp=dataJson.getJSONObject(i);
        NewslistModel nm=new NewslistModel();
        nm.setContent(tmp.getString("content"));
        nm.setFrom(tmp.getString("source"));
        nm.setDate(tmp.getString("date"));
        nm.setTitle(tmp.getString("title"));
        newslist.add(nm);
    }
    return newslist;
}catch (JSONException e){
    e.printStackTrace();
}
return null;
  }
}
