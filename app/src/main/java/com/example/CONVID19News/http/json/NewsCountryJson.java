package com.example.CONVID19News.http.json;

import com.example.CONVID19News.bean.CountryModel;
import com.example.CONVID19News.bean.timedata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import org.json.JSONException;
public class NewsCountryJson {
    public List<CountryModel> jxCountry(String json) throws JSONException{
        List<CountryModel> countryModelList=new ArrayList<CountryModel>();
        try {
            if (json==null||json.equals(""))
            {return null;}
            JSONObject jsonObject= new JSONObject(json);
            JSONArray dd=jsonObject.names();
            for (int i = 0; i <dd.length() ; i++) {
                String tmp=dd.getString(i);
                CountryModel cc=new CountryModel();
                cc.setArea(tmp);
                JSONObject ttt=jsonObject.getJSONObject(tmp);
                cc.setBegintime(ttt.getString("begin"));
                JSONArray tpp=ttt.getJSONArray("data");
                List<timedata> mm = new ArrayList<timedata>();

                for (int j = tpp.length()-20; j <tpp.length() ; j++) {
                    JSONArray ttp=tpp.getJSONArray(j);
                    timedata xx = new timedata();
                    xx.setConfirmed(ttp.getString(0));
                    xx.setSuspected(ttp.getString(1));
                    xx.setCured(ttp.getString(2));
                    xx.setDead(ttp.getString(3));
                    mm.add(xx);
                }
                cc.setTimedataList(mm);
                countryModelList.add(cc);
        }
            return countryModelList;
    } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}