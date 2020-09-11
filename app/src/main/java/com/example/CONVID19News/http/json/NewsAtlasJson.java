package com.example.CONVID19News.http.json;


import com.example.CONVID19News.bean.AtlasModel;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.bean.Properties;
import com.example.CONVID19News.bean.Relations;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.json.JSONException;
public class NewsAtlasJson {
    public List<AtlasModel> jxAtlas(String json)throws JSONException{
        List<AtlasModel> atlaslist=new ArrayList<AtlasModel>();
        try{
            if (json==null||json.equals(""))
            {return null;}
            JSONObject jsonObject= new JSONObject(json);
            JSONArray dataJson=jsonObject.getJSONArray("data");
            for (int i=0;i<dataJson.length();i++)
            {
                JSONObject tmp=dataJson.getJSONObject(i);
                AtlasModel nm=new AtlasModel();
                nm.setLabel(tmp.getString("label"));
                nm.setData_url(tmp.getString("url"));
                JSONObject abst=tmp.getJSONObject("abstractInfo");
                nm.setEnwiki(abst.getString("enwiki"));
                nm.setBaidu(abst.getString("baidu"));
                nm.setZhwiki(abst.getString("zhwiki"));
                JSONObject covid=abst.getJSONObject("COVID");

               // nm.setProperty(covid.getString("properties"));
                JSONObject pp=covid.getJSONObject("properties");
                if(pp.length()!=0){
                JSONArray pplist=pp.names();
                List<Properties> pre=new ArrayList<Properties>();
                for (int k = 0; k <pplist.length() ; k++) {
                    Properties tppd=new Properties();
                    tppd.setSxmc(pplist.getString(k));
                    tppd.setSxz(pp.getString(pplist.getString(k)));
                    pre.add(tppd);
                }
                nm.setProperties(pre);
                }
                else {
                    List<Properties> pre=new ArrayList<Properties>();
                    Properties tppd=new Properties();
                    tppd.setSxmc("null");
                    tppd.setSxz("null");
                    pre.add(tppd);
                    nm.setProperties(pre);

                }
                JSONArray tat=covid.getJSONArray("relations");
                List<Relations> rea=new ArrayList<Relations>();
                for (int j = 0; j <tat.length() ; j++) {
                    JSONObject xasx=tat.getJSONObject(j);
                    Relations tto=new Relations();
                    tto.setRelation(xasx.getString("relation"));
                    tto.setDt_url(xasx.getString("url"));
                    tto.setDt_label(xasx.getString("label"));
                    tto.setForward(xasx.getString("forward"));
                    rea.add(tto);
                }
                nm.setRelations(rea);
                atlaslist.add(nm);
            }
            return atlaslist;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

