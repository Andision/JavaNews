package com.example.CONVID19News.http;

public class Url {
    //新闻和论文列表
    //private String type="news";
    //private int page=1;
    public static final String host_newslist="https://covid-dashboard.aminer.cn/api/events/list";
    public String  getUrl(String ty,int pa){
        String xp=host_newslist+"?type="+ty+"&page="+pa+"&size=15";
        return xp;
    }





    //新闻知疫学者
    public static final String host_newsscholar="https://innovaapi.aminer.cn/predictor/api/v1/valhalla/highlight/get_ncov_expers_list";


    //图谱实体搜索
    public static final String host_newsatlas="https://innovaapi.aminer.cn/covid/api/v1/pneumonia/entityquery";

}
