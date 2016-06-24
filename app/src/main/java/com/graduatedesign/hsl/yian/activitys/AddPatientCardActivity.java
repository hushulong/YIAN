package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.CaseRecord;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesogene on 4/20/16.
 */
public class AddPatientCardActivity extends FragmentActivity implements View.OnClickListener {
    MyApplication myApplication;
    private EditText edit_patient_name;
    private EditText edit_disease_name;
    private EditText edit_treatment_date;
    private EditText edit_complaint_and_history;
    private EditText edit_diagnosis_and_prescription;
    private EditText edit_diagnosis_and_treatment_effect;
    private EditText edit_experience;
    private ImageView img_cancel;
    private ImageView img_save;
    private CaseRecord caseRecord = new CaseRecord();
    RequestClient requestClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_card);
        myApplication = (MyApplication)getApplication();
        edit_patient_name = (EditText)findViewById(R.id.edit_patient_name);
        edit_patient_name.setOnClickListener(this);
        edit_disease_name = (EditText)findViewById(R.id.edit_disease_name);
        edit_disease_name.setOnClickListener(this);
        edit_treatment_date = (EditText)findViewById(R.id.edit_treatment_date);
        edit_treatment_date.setOnClickListener(this);
        edit_complaint_and_history = (EditText)findViewById(R.id.edit_complaint_and_history);
        edit_complaint_and_history.setOnClickListener(this);
        edit_diagnosis_and_prescription = (EditText)findViewById(R.id.edit_diagnosis_and_prescription);
        edit_diagnosis_and_prescription.setOnClickListener(this);
        edit_diagnosis_and_treatment_effect = (EditText)findViewById(R.id.edit_diagnosis_and_treatment_effect);
        edit_experience = (EditText)findViewById(R.id.edit_experience);
        edit_diagnosis_and_treatment_effect.setOnClickListener(this);
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(this);
        img_save = (ImageView)findViewById(R.id.img_save);
        img_save.setOnClickListener(this);
//        Bundle bundle = getIntent().getExtras();
//        String str_name1 = bundle.getString("str_name1");
//        edit_patient_name.setText(str_name1);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/caserecord/",gson);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit_patient_name:
                break;
            case R.id.edit_disease_name:
                break;
            case R.id.edit_treatment_date:
                break;
            case R.id.edit_complaint_and_history:
                break;
            case R.id.edit_diagnosis_and_prescription:
                break;
            case R.id.edit_diagnosis_and_treatment_effect:
                break;
            case R.id.img_cancel:
                AddPatientCardActivity.this.finish();
                break;
            case R.id.img_save:
                //保存数据，跳到档案记录页面
                String patient_name = edit_patient_name.getText().toString();
                String disease_name = edit_disease_name.getText().toString();
                String complaint_and_history = edit_complaint_and_history.getText().toString();
                String diagnosis_and_prescription = edit_diagnosis_and_prescription.getText().toString();
                String treatment_effect = edit_diagnosis_and_treatment_effect.getText().toString();
                String experience = edit_experience.getText().toString();
                caseRecord.setPatientTalk(complaint_and_history);
                caseRecord.setCurativeEffect(treatment_effect);
                caseRecord.setTipsContent(experience);
                caseRecord.setDiagnosis(diagnosis_and_prescription);
                Call<CaseRecord> call = requestClient.addCaserecord(caseRecord);
                call.enqueue(new Callback<CaseRecord>() {
                    @Override
                    public void onResponse(Call<CaseRecord> call, Response<CaseRecord> response) {

                    }

                    @Override
                    public void onFailure(Call<CaseRecord> call, Throwable t) {

                    }
                });
                break;
        }
    }
}
