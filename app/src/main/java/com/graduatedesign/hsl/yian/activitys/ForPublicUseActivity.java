package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 6/6/16.
 */
public class ForPublicUseActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public);
        ImageView img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                ForPublicUseActivity.this.finish();
                break;
        }
    }
}
