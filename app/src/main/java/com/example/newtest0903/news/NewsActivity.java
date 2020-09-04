package com.example.newtest0903.news;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.newtest0903.R;

public class NewsActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news);

        Bundle bundle=this.getIntent().getExtras();
        int name=bundle.getInt("name");
        TextView textView=findViewById(R.id.textview);
        textView.setText("显示NEWS"+name);

    }

}
