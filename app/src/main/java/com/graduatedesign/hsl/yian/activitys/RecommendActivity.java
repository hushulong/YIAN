package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 3/30/16.
 */
public class RecommendActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integration);
        TextView textView = (TextView) findViewById(R.id.text);
        TextView textView1 = (TextView)findViewById(R.id.title);
        textView1.setText("推荐");
        textView.setText("推荐页面");
    }
}
