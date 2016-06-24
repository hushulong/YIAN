package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 3/30/16.
 */
public class DownloadActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_integration);
        TextView textView = (TextView)findViewById(R.id.text);
        ImageView img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                DownloadActivity.this.finish();
                break;
        }
    }
}
