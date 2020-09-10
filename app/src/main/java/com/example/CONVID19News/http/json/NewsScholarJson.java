package com.example.CONVID19News.http.json;
import com.example.CONVID19News.bean.NewslistModel;
import com.example.CONVID19News.bean.ScholarModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.json.JSONException;
public class NewsScholarJson {
    public List<ScholarModel> jxScholar(String json) throws JSONException {
        List<ScholarModel> schloar=new ArrayList<ScholarModel>();
        try{
            if (json==null||json.equals(""))
            {return null;}

            JSONObject jsonObject= new JSONObject(json);
            JSONArray dataJson=jsonObject.getJSONArray("data");
            for (int i=0;i<10&&i<dataJson.length();i++)
            {
                JSONObject tmp=dataJson.getJSONObject(i);
                ScholarModel sm=new ScholarModel();
                sm.setActivity(tmp.getString("activity"));
                sm.setAvator(tmp.getString("avator"));
                sm.setCitations(tmp.getString("citations"));
                sm.setDiversity(tmp.getString("diversity"));
                sm.setGindex(tmp.getString("gindex"));
                sm.setHindex(tmp.getString("hindex"));
                sm.setId(tmp.getString("id"));
                sm.setNewStar(tmp.getString("newStar"));
                sm.setRisingStar(tmp.getString("risingStar"));
                sm.setSociability(tmp.getString("sociability"));
                sm.setIs_passedaway(tmp.getString("is_passedaway"));
                sm.setName(tmp.getString("name"));
                sm.setName_zh(tmp.getString("name_zh"));
                schloar.add(sm);
            }
            return schloar;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
