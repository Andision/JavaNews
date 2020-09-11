package com.example.CONVID19News.background.bean.http;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpurl {

    public  String pub(String urlStr)
    {
        String result;
        URL url = null;
        HttpURLConnection connection = null;
        //System.out.println("request:"+urlStr+"?"+param);
        try {
            /*建立连接对象*/
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            /*设置连接超时时间*/
            connection.setConnectTimeout(6000);
            connection.setRequestMethod("GET");// 设置URL请求方式
            InputStream in=connection.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(in,"UTF-8"));
            result=br.readLine();
            return  result;
            //result="iiii";
            //System.out.println("response:"+result);
            //}
            /*断开连接*/
           // connection.disconnect();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

        }
    return null;
    }

    public static Bitmap getBitmap(String path) throws IOException{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setConnectTimeout(6000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == 200){
            InputStream inputStream = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }
        return null;
    }

}
