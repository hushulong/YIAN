package com.graduatedesign.hsl.yian.activitys;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.CaseRecord;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesogene on 4/24/16.
 */
public class PatientCardActivity extends FragmentActivity implements View.OnClickListener,TextWatcher{
    MyApplication myApplication;
    private ImageView img_cancel;
    private ImageView img_delete;
    private ImageView img_save;
    private Button bt_return_visit;
    private EditText edit_patient_name;
    private EditText edit_disease_name;
    private EditText edit_treatment_date;
    private EditText edit_complaint_and_history;
    private EditText edit_diagnosis_and_prescription;
    private EditText edit_diagnosis_and_treatment_effect;
    private EditText edit_experience;
    private static int changed = 1;//状态码，默认为1是没有修改
    final int SINGLE_DIALOG = 0x113;//dialog提示框，退出提示
    final int DELETE_DIALOG = 0x114;//dialog提示框，删除提示
    Integer caseid;
    private List<CaseRecord> caseRecord = new ArrayList<CaseRecord>();
    private List<CaseRecord> case_record = new ArrayList<CaseRecord>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<CaseRecord>> call = requestClient.getCaseRecordByCaseId(caseid);
                caseRecord = call.execute().body();
                handler.sendEmptyMessage(1);
            }catch (Exception e){
                Log.d("PatientCardActivity","病案信息请求出错"+e.getMessage());
            }
        }
    };
    Handler handler = new Handler(){
      @Override
    public void handleMessage(Message msg){
          super.handleMessage(msg);
          switch (msg.what){
              case 1:
                  edit_patient_name.setText(caseRecord.get(0).getTempPatientId().toString());
                  edit_disease_name.setText(caseRecord.get(0).getTempDiseaseId().toString());
                  edit_treatment_date.setText(caseRecord.get(0).getCaseDate().toString());
                  edit_complaint_and_history.setText(caseRecord.get(0).getPatientTalk()+caseRecord.get(0).getDiagnosis());
                  edit_diagnosis_and_prescription.setText(caseRecord.get(0).getDiagnosis()+caseRecord.get(0).getTempDoctorPrescriptionId());
                  edit_diagnosis_and_treatment_effect.setText(caseRecord.get(0).getCurativeEffect());
                  edit_experience.setText(caseRecord.get(0).getTipsContent());
                  changed = 1;
                  break;
          }
      }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_card);
        myApplication = (MyApplication)getApplication();
        Bundle bundle = getIntent().getExtras();
        caseid = bundle.getInt("caseId");
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(this);
        img_delete = (ImageView)findViewById(R.id.img_delete);
        img_delete.setOnClickListener(this);
        img_save = (ImageView)findViewById(R.id.img_save);
        img_save.setOnClickListener(this);
        bt_return_visit = (Button)findViewById(R.id.bt_return_visit);
        bt_return_visit.setOnClickListener(this);
        edit_patient_name = (EditText)findViewById(R.id.edit_patient_name);
        edit_disease_name = (EditText)findViewById(R.id.edit_disease_name);
        edit_treatment_date = (EditText)findViewById(R.id.edit_treatment_date);
        edit_complaint_and_history = (EditText)findViewById(R.id.edit_complaint_and_history);
        edit_complaint_and_history.addTextChangedListener(this);
        edit_diagnosis_and_prescription = (EditText)findViewById(R.id.edit_diagnosis_and_prescription);
        edit_diagnosis_and_prescription.addTextChangedListener(this);
        edit_diagnosis_and_treatment_effect = (EditText)findViewById(R.id.edit_diagnosis_and_treatment_effect);
        edit_diagnosis_and_treatment_effect.addTextChangedListener(this);
        edit_experience = (EditText)findViewById(R.id.edit_experience);
        edit_experience.addTextChangedListener(this);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/",gson);
        new Thread(getData).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_cancel:
                if(changed == 2){
                    showDialog(SINGLE_DIALOG);
                }else{
                    PatientCardActivity.this.finish();
                }
                break;
            case R.id.img_save:
                String complaint = edit_complaint_and_history.getText().toString();
                String effect = edit_diagnosis_and_treatment_effect.getText().toString();
                String experience = edit_experience.getText().toString();
                case_record.add(new CaseRecord(caseid,experience,complaint,effect));
                Call<List<CaseRecord>> call = requestClient.updateCaseRecord(case_record);
                try {
                    call.enqueue(new Callback<List<CaseRecord>>() {
                        @Override
                        public void onResponse(Call<List<CaseRecord>> call, Response<List<CaseRecord>> response) {

                        }

                        @Override
                        public void onFailure(Call<List<CaseRecord>> call, Throwable t) {

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                changed = 1;
                Toast toast = Toast.makeText(this, "修改已保存", Toast.LENGTH_SHORT);

                toast.show();
                break;
            case R.id.img_delete:
                showDialog(DELETE_DIALOG);
                break;

        }
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        changed = 2;
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    public Dialog onCreateDialog(int id,Bundle state){
        switch (id){
            case SINGLE_DIALOG:
                final AlertDialog.Builder back = new AlertDialog.Builder(this);
                back.setTitle("提示");
                back.setMessage("诊疗卡片已修改，是否保存？");
                back.setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                back.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PatientCardActivity.this.finish();
                    }
                });
                back.create().show();
                break;
            case DELETE_DIALOG:
                final AlertDialog.Builder delete = new AlertDialog.Builder(this);
                delete.setTitle("提示");
                delete.setMessage("确定删除本张诊疗卡片？");
                delete.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                delete.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                delete.create().show();
                break;
        }
        return null;
    }

}
