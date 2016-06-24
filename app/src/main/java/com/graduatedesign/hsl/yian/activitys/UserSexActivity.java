package com.graduatedesign.hsl.yian.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 4/9/16.
 */
public class UserSexActivity extends FragmentActivity{
    private ImageView img_cancel;
    private ImageView img_save;
    private TextView tv_title;
    private RadioButton bt_man;
    private RadioButton bt_woman;
    private RadioGroup radioGroup;
    private String usersex;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sex);
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_save = (ImageView)findViewById(R.id.img_save);
        tv_title = (TextView)findViewById(R.id.tv_title);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        bt_man = (RadioButton)findViewById(R.id.bt_man);
        bt_woman = (RadioButton)findViewById(R.id.bt_woman);
        Bundle bundle = getIntent().getExtras();
        final String str = bundle.getString("str").trim();
        if(str.equals("男")){
            bt_man.setChecked(true);
            usersex = bt_man.getText().toString();
        }else if (str.equals("女")) {
            bt_woman.setChecked(true);
            usersex = bt_woman.getText().toString();
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt_man:
                        usersex = bt_man.getText().toString();
                        break;
                    case R.id.bt_woman:
                        usersex = bt_woman.getText().toString();
                        break;
                }
            }
        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSexActivity.this.finish();
            }
        });
        img_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.equals(usersex)){
                    Toast.makeText(getApplicationContext(),"请修改性别",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(UserSexActivity.this, UserInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("str", usersex);
                    intent.putExtras(bundle);
                    UserSexActivity.this.setResult(5, intent);
                    UserSexActivity.this.finish();
                }
            }
        });
    }
}
