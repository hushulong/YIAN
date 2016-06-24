package com.graduatedesign.hsl.yian.activitys.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.UserInfoActivity;
import com.graduatedesign.hsl.yian.domain.DoctorInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistActivity extends FragmentActivity implements View.OnClickListener {

    MyApplication myApplication;
    RequestClient registerRequestClient;
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    RelativeLayout rl_registerSuccess;
    RelativeLayout rl_registerModel;
    BootstrapButton bbtn_loginNow;
    Button btn_UserRegister;
    EditText edt_userName;
    EditText edt_userPasswd;
    EditText edt_userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        myApplication = (MyApplication)getApplication();
        btn_UserRegister = (Button) findViewById(R.id.register_btnok);
        edt_userEmail = (EditText) findViewById(R.id.edt_email);
        edt_userName = (EditText) findViewById(R.id.edt_login);
        edt_userPasswd = (EditText) findViewById(R.id.edt_pass);
        rl_registerSuccess = (RelativeLayout) findViewById(R.id.rl_register_success);
        rl_registerModel = (RelativeLayout) findViewById(R.id.rl_register_model);
        bbtn_loginNow = (BootstrapButton) findViewById(R.id.bbtn_login_now);
        bbtn_loginNow.setOnClickListener(this);
        btn_UserRegister.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.register_btnok:
                try {
                    myApplication = (MyApplication) getApplication();
                    List<DoctorInfo> registerUser = new ArrayList<DoctorInfo>();
                    String name = edt_userName.getText().toString().trim();
                    String password = edt_userPasswd.getText().toString().trim();
                    registerUser.add(new DoctorInfo(name,password));
                    registerRequestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl+"/doctorinfo/", gson);
                    Call<List<DoctorInfo>> call = registerRequestClient.addDoctorinfo(registerUser);
                    call.enqueue(new Callback<List<DoctorInfo>>() {
                        @Override
                        public void onResponse(Call<List<DoctorInfo>> call, Response<List<DoctorInfo>> response) {
                            if (response.isSuccessful()) {
                                Intent intent = new Intent();
                                intent.setClass(RegistActivity.this, UserLoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(intent);
                                RegistActivity.this.finish();
                            }
                        }

                        @Override
                        public void onFailure(Call<List<DoctorInfo>> call, Throwable t) {

//                            edt_userName.clearFocus();
//                            edt_userPasswd.clearFocus();
//                            edt_userEmail.clearFocus();
//                            edt_userEmail.setText("");
//                            edt_userName.setText("");
//                            edt_userPasswd.setText("");
//                            edt_userName.setHint(R.string.register_username);
//                            edt_userPasswd.setHint(R.string.register_password);
//                            edt_userEmail.setHint(R.string.register_email);
                            Intent intent = new Intent();
                            intent.setClass(RegistActivity.this, UserLoginActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                            RegistActivity.this.finish();
                        }
                    });

                } catch (Exception e) {
                    Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bbtn_login_now:
                Intent intent = new Intent();
                intent.setClass(this, UserLoginActivity.class);
                startActivity(intent);
        }

    }
}
