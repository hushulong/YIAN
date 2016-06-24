package com.graduatedesign.hsl.yian.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 4/12/16.
 */
public class UserMobileNumActivity extends FragmentActivity{
    private Button bt_post;
    private ImageView img_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_mobile);
        bt_post = (Button)findViewById(R.id.bt_post);
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserMobileNumActivity.this.finish();
            }
        });
        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserMobileNumActivity.this,UserInfoActivity.class);
                UserMobileNumActivity.this.setResult(7,intent);
                UserMobileNumActivity.this.finish();
            }
        });
    }
}
