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
            for (int i=0;i<dataJson.length();i++)
            {
                JSONObject tmp=dataJson.getJSONObject(i);
                ScholarModel sm=new ScholarModel();
                sm.setAvator(tmp.optString("avatar",""));
                sm.setId(tmp.optString("id",""));
                sm.setName(tmp.optString("name",""));
                sm.setName_zh(tmp.optString("name_zh",""));
                sm.setIs_passedaway(tmp.optString("is_passedaway",""));
                JSONObject indices=tmp.getJSONObject("indices");
                sm.setActivity(indices.optString("activity",""));
                sm.setCitations(indices.optString("citations",""));
                sm.setDiversity(indices.optString("diversity",""));
                sm.setGindex(indices.optString("gindex",""));
                sm.setHindex(indices.optString("hindex",""));
                sm.setNewStar(indices.optString("newStar",""));
                sm.setRisingStar(indices.optString("risingStar",""));
                sm.setSociability(indices.optString("sociability",""));
                JSONObject profile=tmp.getJSONObject("profile");
                sm.setPosition(profile.optString("position",""));
                sm.setBio(profile.optString("bio",""));
                sm.setEdu(profile.optString("edu",""));
                sm.setAffiliation(profile.optString("affiliation",""));
                schloar.add(sm);
            }
            return schloar;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
