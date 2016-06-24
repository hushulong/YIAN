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
 * Created by Mesogene on 4/13/16.
 */
public class UserIdentityActivity extends FragmentActivity {
    private ImageView img_cancel;
    private ImageView img_save;
    private TextView tv_title;
    private RadioButton bt_one;
    private RadioButton bt_two;
    private RadioButton bt_three;
    private RadioButton bt_four;
    private RadioButton bt_five;
    private RadioGroup radioGroup;
    private String user_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_identity);
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_save = (ImageView)findViewById(R.id.img_save);
        tv_title = (TextView)findViewById(R.id.tv_title);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        bt_one = (RadioButton)findViewById(R.id.bt_one);
        bt_two = (RadioButton)findViewById(R.id.bt_two);
        bt_three = (RadioButton)findViewById(R.id.bt_three);
        bt_four = (RadioButton)findViewById(R.id.bt_four);
        bt_five = (RadioButton)findViewById(R.id.bt_five);
        Bundle bundle = getIntent().getExtras();
        final String str = bundle.getString("str").trim();
        if(str.equals("职业医师")){
            bt_one.setChecked(true);
            user_identity = bt_one.getText().toString();
        }else if(str.equals("中医从业者")){
            bt_two.setChecked(true);
            user_identity = bt_two.getText().toString();
        }else if(str.equals("医学院师生")){
            bt_three.setChecked(true);
            user_identity = bt_three.getText().toString();
        }else if(str.equals("中医爱好者")){
            bt_four.setChecked(true);
            user_identity = bt_four.getText().toString();
        }else if(str.equals("民间中医")){
            bt_five.setChecked(true);
            user_identity = bt_five.getText().toString();
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.bt_one:
                        user_identity = bt_one.getText().toString();
                        break;
                    case R.id.bt_two:
                        user_identity = bt_two.getText().toString();
                        break;
                    case R.id.bt_three:
                        user_identity = bt_three.getText().toString();
                        break;
                    case R.id.bt_four:
                        user_identity = bt_four.getText().toString();
                        break;
                    case R.id.bt_five:
                        user_identity = bt_five.getText().toString();
                        break;
                    default:
                        break;
                }
            }
        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserIdentityActivity.this.finish();
            }
        });
        img_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.equals(user_identity)){
                    Toast.makeText(getApplicationContext(), "请修改身份", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(UserIdentityActivity.this, UserInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("str", user_identity);
                    intent.putExtras(bundle);
                    UserIdentityActivity.this.setResult(9, intent);
                    UserIdentityActivity.this.finish();
                }
            }
        });
    }
}
