package com.example.CONVID19News.http;

import com.example.CONVID19News.bean.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class deal {
    public List<CountryModel> deal_Split(List<CountryModel> x,int y){
        //y为进行什么操作(也代表要含有几个|的数据)  y=0：世界   y=1：省   y=2：市
        List<CountryModel>  retlist=new ArrayList<CountryModel>();
        if(y==0)
        {
            for (int i = 0; i <x.size(); i++) {
                if(!x.get(i).getArea().contains("|"))
                {
                    retlist.add(x.get(i));
                }
            }
            return retlist;

        }
        else if(y==1)
        {
            for (int i = 0; i <x.size(); i++) {
                if(x.get(i).getArea().contains("|"))
                {
                    x.get(i).getArea().split("\\|");
                    String[] ads=x.get(i).getArea().split("|");
                    if(x.get(i).getArea().split("\\|").length==2)
                    {
                        x.get(i).setArea(x.get(i).getArea().split("\\|")[1]);
                        retlist.add(x.get(i));
                    }
                }
            }
            return retlist;
        }
        else {
            for (int i = 0; i <x.size(); i++) {
                if(x.get(i).getArea().contains("|"))
                {
                    if(x.get(i).getArea().split("\\|").length==3)
                    {
                        x.get(i).setArea(x.get(i).getArea().split("\\|")[1]+" "+x.get(i).getArea().split("\\|")[2]);
                        retlist.add(x.get(i));
                    }
                }
            }
            return retlist;
        }
    }
}
