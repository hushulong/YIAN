package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.fragments.MedicineTransitionFragment;
import com.graduatedesign.hsl.yian.fragments.XingWeiTrasitionFragment;

/**
 * Created by Mesogene on 3/27/16.
 */
public class ChineseMedicineActivity extends FragmentActivity implements View.OnClickListener{
    public static final String TAG = ChineseMedicineActivity.class.getName();
    private ImageView img_back;
    private ImageView img_search;
    private Button bt_xing_wei;
    private Button bt_effect;
    private Button bt_san_pin;
    private RelativeLayout re_search_string;
    private TextView tv_search_string;
    private ImageView img_search_clear;
    public String search_string = "";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chinese_medicine_activity);
        img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        img_search = (ImageView)findViewById(R.id.img_search);
        img_search.setOnClickListener(this);
        bt_xing_wei = (Button)findViewById(R.id.xing_wei);
        bt_xing_wei.setOnClickListener(this);
        bt_effect = (Button)findViewById(R.id.gongxiao);
        bt_effect.setOnClickListener(this);
        bt_san_pin = (Button)findViewById(R.id.san_pin);
        bt_san_pin.setOnClickListener(this);
        re_search_string = (RelativeLayout)findViewById(R.id.search_string);
        tv_search_string = (TextView)findViewById(R.id.tv_search_string);
        img_search_clear = (ImageView)findViewById(R.id.search_clear);
        img_search_clear.setOnClickListener(this);
        if(savedInstanceState == null){
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            MedicineTransitionFragment fragment = new MedicineTransitionFragment();
            transition.replace(R.id.list_fragment,fragment);
            transition.commit();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                ChineseMedicineActivity.this.finish();
                break;
            case R.id.img_search:
                break;
            case R.id.xing_wei:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                XingWeiTrasitionFragment fragment = new XingWeiTrasitionFragment();
                transaction.replace(R.id.list_fragment,fragment);
                transaction.commit();
                break;
            case R.id.gongxiao:
                break;
            case R.id.san_pin:
                break;
            case R.id.search_clear:
                tv_search_string.setText("");
                re_search_string.setVisibility(View.GONE);
                break;
        }
    }
}
