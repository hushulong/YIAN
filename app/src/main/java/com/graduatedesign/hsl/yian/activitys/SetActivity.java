package com.graduatedesign.hsl.yian.activitys;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 3/30/16.
 */
public class SetActivity extends FragmentActivity {
    MyApplication myApplication;
    TextView changeIp;
    TextView showIP;
    EditText newIP;
    ImageView img_cancel;
    ImageView img_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this,AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        myApplication = (MyApplication)getApplication();

        changeIp = (TextView)findViewById(R.id.change_ip);
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_save = (ImageView)findViewById(R.id.img_save);
        changeIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("修改IP地址");
                LinearLayout ChangeIp = (LinearLayout)getLayoutInflater().inflate(R.layout.change_ip,null);
                builder.setView(ChangeIp);
                newIP = (EditText)ChangeIp.findViewById(R.id.new_ip);
                builder.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String str = newIP.getText().toString();
                        Log.d("url", str);
                        //此处可执行修改ip处理
                        myApplication.setMyUrl(str);
                        myApplication.restartApplication();
                        SetActivity.this.finish();
                    }
                });
                builder.setNegativeButton("取消",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //取消修改，不做任何事情
                    }
                });
                builder.create().show();
            }
        });
        showIP = (TextView)findViewById(R.id.show_ip);
        showIP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = (TextView)findViewById(R.id.ip);
                textView.setText(MyApplication.myUrl);
                textView.setVisibility(View.VISIBLE);
            }
        });
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetActivity.this.finish();
            }
        });
    }

}

