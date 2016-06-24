package com.graduatedesign.hsl.yian.activitys.user;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.util.Log;
import android.view.KeyEvent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.UserInfoActivity;
import com.graduatedesign.hsl.yian.domain.DoctorInfo;
import com.graduatedesign.hsl.yian.fragments.PersonalFragment;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserLoginActivity extends FragmentActivity implements View.OnClickListener {
    MyApplication myApplication; //为了修改IP
    Button btn_login;
    EditText et_login, et_password;
    List<DoctorInfo> user = new ArrayList<DoctorInfo>();
    TextView tv_regist;
    RequestClient loginRequestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login4);
    /*
        * 为了修改IP
        * */
        myApplication = (MyApplication) getApplication();
        tv_regist = (TextView) findViewById(R.id.tv_regist);
        tv_regist.setClickable(true);
        tv_regist.setFocusable(true);
        tv_regist.setOnClickListener(this);
        et_login = (EditText) findViewById(R.id.et_login);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        try {
            loginRequestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/doctorinfo/", gson);
        } catch (Exception e) {
            Log.d("errorinfo", e.getMessage());
        }
    }



//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            Intent homeintent = new Intent();
//            homeintent.setClass(this, PersonalFragment.class);
//            startActivity(homeintent);
//            return true;
//
//        } else return false;
//    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                return;
            case R.id.tv_regist:
                Intent intent = new Intent();
                intent.setClass(this, RegistActivity.class);
                startActivity(intent);
                return;


        }
    }

    private void login() {

        final String loginname = et_login.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        if(loginname.equals("test")){
            if(password.equals("test")){
                SharedPreferences sp = getSharedPreferences("user_config", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("login", loginname);
                editor.putString("password", password);
                //editor.putString("auth_token", JsonData.create(object).optString("auth_token"));
                editor.commit();
                myApplication.setLoginStatus("陈建明");
                myApplication.restartApplication();
                UserLoginActivity.this.finish();
            }
            else{
                Toast toast = Toast.makeText(this,"密码错误!",Toast.LENGTH_SHORT);
                toast.show();
            }
        }else {
            Toast toast = Toast.makeText(this,"用户名错误!",Toast.LENGTH_SHORT);
            toast.show();
        }

//        user.add(new DoctorInfo(loginname,password));
//
//        Call<List<DoctorInfo>> call = loginRequestClient.UserLogin(user);
//        call.enqueue(new Callback<List<DoctorInfo>>() {
//            @Override
//            public void onResponse(Call<List<DoctorInfo>> call, Response<List<DoctorInfo>> response) {
//
////                Toast.makeText(UserLoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
////                SharedPreferences sp = getSharedPreferences("user_config", Context.MODE_PRIVATE);
////                SharedPreferences.Editor editor = sp.edit();
////                editor.putString("login", loginname);
////                editor.putString("password", password);
////                //editor.putString("auth_token", JsonData.create(object).optString("auth_token"));
////                editor.commit();
////                Intent intent = new Intent();
////                intent.setClass(UserLoginActivity.this, UserInfoActivity.class);
////                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
////                startActivity(intent);
////                UserLoginActivity.this.finish();
//            }
//
//            @Override
//            public void onFailure(Call<List<DoctorInfo>> call, Throwable t) {
////
////                et_login.clearFocus();
////                et_password.clearFocus();
////                et_login.setText("");
////                et_password.setText("");
////                et_login.setHint(R.string.UserName);
////                et_password.setHint(R.string.UserPasswd);
//
//                Toast.makeText(UserLoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
//                SharedPreferences sp = getSharedPreferences("user_config", Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("login", loginname);
//                editor.putString("password", password);
//                //editor.putString("auth_token", JsonData.create(object).optString("auth_token"));
//                editor.commit();
//                Intent intent = new Intent();
//                intent.setClass(UserLoginActivity.this, PersonalFragment.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
//                Bundle bundle = new Bundle();
//                bundle.putString("name","许丹");
//                intent.putExtras(bundle);
//                UserLoginActivity.this.setResult(2,intent);
//                UserLoginActivity.this.finish();
//            }
//        });

    }
}
