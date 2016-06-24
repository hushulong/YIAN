package com.graduatedesign.hsl.yian.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.NetHelper;
import com.graduatedesign.hsl.yian.utils.RequestClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesogene on 4/13/16.
 */
public class AddPatientRecordsActivity extends FragmentActivity implements View.OnClickListener {
    MyApplication myApplication;
    private ImageView img_cancel;
    private ImageView img_save;
    private TextView tv_title;
    private EditText edit_name;
    private RadioGroup radioGroup;
    private RadioButton radio_man;
    private RadioButton radio_woman;
    private EditText edit_age;
    private EditText edit_phone_num;
    private EditText edit_remark;

    private List<PatientInfo> patientInfos = new ArrayList<PatientInfo>();
    RequestClient requestClient;
    String patientsex;
    String patientname;
    Integer patientage;
    String patient_phone_num;
    String patient_remark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_record);
        myApplication = (MyApplication)getApplication();
        img_cancel = (ImageView) findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(this);
        img_save = (ImageView) findViewById(R.id.img_save);
        img_save.setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        edit_name = (EditText) findViewById(R.id.edit_name);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnClickListener(this);
        radio_man = (RadioButton) findViewById(R.id.radio_man);
        radio_woman = (RadioButton) findViewById(R.id.radio_woman);
        edit_age = (EditText) findViewById(R.id.edit_age);
        edit_phone_num = (EditText) findViewById(R.id.edit_phone_num);
        edit_remark = (EditText) findViewById(R.id.edit_remark);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_man:
                        patientsex = "男";
                        break;
                    case R.id.radio_woman:
                        patientsex = "女";
                        break;
                }
            }
        });
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl+"/patientinfo/", gson);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_cancel:
                AddPatientRecordsActivity.this.finish();
                break;
            case R.id.img_save:
                if (edit_name.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "姓名为必填", Toast.LENGTH_SHORT).show();
                }
                else if(patientsex == null){
                    Toast.makeText(getApplicationContext(), "请选择性别", Toast.LENGTH_SHORT).show();

                }

                else {
                    if(edit_age.getText().toString().isEmpty()){
                        patientage = null;
                    }else {
                        patientage = Integer.parseInt(edit_age.getText().toString());
                    }
                    patientname = edit_name.getText().toString();
                    patient_phone_num = edit_phone_num.getText().toString();
                    patient_remark = edit_remark.getText().toString();
                    patientInfos.add(new PatientInfo(patientname, patientsex, patientage, patient_phone_num, patient_remark));
                    Call<List<PatientInfo>> call = requestClient.addPatientinfo(patientInfos);
                    call.enqueue(new Callback<List<PatientInfo>>() {
                        @Override
                        public void onResponse(Call<List<PatientInfo>> call, Response<List<PatientInfo>> response) {
                            System.out.println(response.body());
                        }
                        @Override
                        public void onFailure(Call<List<PatientInfo>> call, Throwable t) {
                        }
                    });

                    Intent intent = new Intent(AddPatientRecordsActivity.this, PatientRecordActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("str_name", patientname);
                    bundle.putString("str_sex", patientsex);
                    bundle.putString("str_age", edit_age.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    AddPatientRecordsActivity.this.finish();
                    break;

                }
        }
    }
}
