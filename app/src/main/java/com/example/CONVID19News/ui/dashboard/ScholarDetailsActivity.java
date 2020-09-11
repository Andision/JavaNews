package com.example.CONVID19News.ui.dashboard;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.CONVID19News.R;
import com.example.CONVID19News.background.bean.http.httpurl;

import java.io.IOException;

public class ScholarDetailsActivity extends AppCompatActivity {

    private String shareText="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholardetails);

        final Bundle bundle=this.getIntent().getExtras();

        final ImageView imageView=findViewById(R.id.scholarimage);
        new Thread() {
            @Override
            public void run() {
                super.run();

                try {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageResource(R.drawable.unfinish);
                        }
                    });

                    final Bitmap bm= httpurl.getBitmap(bundle.getString("img"));

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageBitmap(bm);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        TextView sname = findViewById(R.id.scholarname);
        sname.setText(bundle.getString("name"));
        TextView stitle = findViewById(R.id.scholartitle);
        stitle.setText(bundle.getString("title"));
        TextView swp = findViewById(R.id.scholarworkplace);
        swp.setText(bundle.getString("workplace"));
        TextView sbio = findViewById(R.id.scholarprofile);
        sbio.setText(bundle.getString("bio").replace("<br>","\n\n"));
        TextView sedu = findViewById(R.id.scholaredu);
        sedu.setText(bundle.getString("edu").replace("<br>","\n\n"));
//        System.out.println(bundle.getString("bio"));
//
//
//        TextView news_info = findViewById(R.id.news_info);
//        news_info.setText("\n"+bundle.getString("date")+"    "+bundle.getString("from")+"\n");
//        shareText+=bundle.getString("date")+"    "+bundle.getString("from")+"\n";
//
//        TextView news_text = findViewById(R.id.news_text);
//        news_text.setText("    "+bundle.getString("content"));
//        shareText+="    "+bundle.getString("content")+"\n";



//        ActionBar actionBar=getSupportActionBar();
//        actionBar.set


//
//        webView.evaluateJavascript("callJS()",null);


//        Bundle bundle=this.getIntent().getExtras();
//        int id=bundle.getInt("id");
//        String name=bundle.getString("name");
//        TextView textView=findViewById(R.id.textview);
//        textView.setText("显示NEWS"+id+':'+name);

    }

}
