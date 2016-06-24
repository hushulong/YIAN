package com.graduatedesign.hsl.yian.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 4/9/16.
 */
public class UserNameActivity extends FragmentActivity {
    private ImageView img_cancel;
    private ImageView img_save;
    private TextView tv_title;
    private EditText edit_name;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name);
        Bundle bundle = getIntent().getExtras();
        final String str = bundle.getString("str");
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_save = (ImageView)findViewById(R.id.img_save);
        tv_title = (TextView)findViewById(R.id.tv_title);
        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_name.setText(str);
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserNameActivity.this.finish();
            }
        });
        img_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str.equals(edit_name.getText().toString())){
                    Toast.makeText(getApplicationContext(), "请修改姓名", Toast.LENGTH_SHORT).show();
                }else {
                    String username = edit_name.getText().toString();
                    Intent intent = new Intent(UserNameActivity.this, UserInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("str", username);
                    intent.putExtras(bundle);
                    UserNameActivity.this.setResult(3, intent);
                    UserNameActivity.this.finish();
                }
            }

        });
    }
}
