package com.example.CONVID19News.http.json;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.bean.PaperlistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.json.JSONException;

public class PaperListJson {
    public List<PaperlistModel>jxPaperlist(String json)throws JSONException{
        List<PaperlistModel> paperlist=new ArrayList<PaperlistModel>();
        try {
            if (json==null||json.equals(""))
            {return null;}
            JSONObject jsonObject= new JSONObject(json);
            JSONArray dataJson=jsonObject.getJSONArray("data");
            for (int i=0;i<10&&i<dataJson.length();i++)
            {
                JSONObject tmp=dataJson.getJSONObject(i);
                PaperlistModel nm=new PaperlistModel();
                nm.setContent(tmp.getString("content"));
                JSONArray aut=tmp.getJSONArray("authors");
                String attr=null;
                for (int j=0;j<aut.length();j++)
                {
                    JSONObject tmo=aut.getJSONObject(j);
                    attr+=tmo.getString("name");
                }
                nm.setAuthors(attr);
            //    nm.setAuthors(tmp.getString("source"));
                nm.setDate(tmp.getString("date"));
                nm.setTitle(tmp.getString("title"));
                paperlist.add(nm);
            }
            return paperlist;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
        }
    }
