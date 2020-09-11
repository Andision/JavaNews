package com.example.CONVID19News.background.bean.http.json;
import com.example.CONVID19News.background.bean.PaperlistModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

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
                String attr=" ";
                for (int j=0;j<aut.length();j++)
                {
                    JSONObject tmo=aut.getJSONObject(j);
                    attr+="  ";
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
