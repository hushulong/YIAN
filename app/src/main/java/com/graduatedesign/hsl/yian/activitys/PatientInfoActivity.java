package com.graduatedesign.hsl.yian.activitys;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.os.Handler;
import java.util.logging.LogRecord;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mesogene on 4/20/16.
 */
public class PatientInfoActivity extends FragmentActivity implements View.OnClickListener {
    MyApplication myApplication;
    private ImageView img_cancel;
    private ImageView img_save;
    private EditText edit_name;
    private RadioGroup radioGroup;
    private RadioButton radio_man;
    private RadioButton radio_woman;
    private EditText edit_age;
    private EditText edit_phone_num;
    private EditText edit_remark;
    private EditText edit_height;
    private EditText edit_weight;
    private EditText edit_figure;
    private EditText edit_profession;
    private EditText edit_card;
    private EditText edit_address;
    private Button bt_delete;
    private Calendar calendar;
    private List<PatientInfo> patientInfos = new ArrayList<PatientInfo>();
    private List<PatientInfo> patientInfo = new ArrayList<PatientInfo>();
    private Call<PatientInfo>call1;
    final int DELETE_DIALOG = 0x114;//dialog提示框，删除提示
    RequestClient requestClient;
    String patientsex;
    String str_name;
    String str_sex;
    Integer str_age;
    String phone_number;
    String remark;
    String posture;
    String professional;
    String identityCard;
    String address;
    Integer height;
    Double weight;
    Integer patientId;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<PatientInfo>> call = requestClient.getPatientinfo("findbyname",str_name);
                patientInfos = call.execute().body();
                handler.sendEmptyMessage(1);
            }catch (Exception e){
                Log.d("MedicalRecordsFragment", "病人信息表请求出错" + e.getMessage());
            }
        }
    };
    Handler handler = new Handler() {
       @Override
       public void handleMessage(Message msg){
           super.handleMessage(msg);
           switch (msg.what){
               case 1:
                    height = patientInfos.get(0).getpatientHeight();
                    weight = patientInfos.get(0).getpatientWeight();
                   str_sex = patientInfos.get(0).getpatientSex();
                   str_age = patientInfos.get(0).getpatientAge();
                    if(height != null){
                        edit_height.setText(height.toString());
                    }
                   if(weight != null){
                       edit_weight.setText(weight.toString());
                   }
                    if(str_age != null){
                        edit_age.setText(str_age.toString());
                    }
                   if(str_sex.equals("男")){
                       radio_man.setChecked(true);
                       patientsex = radio_man.getText().toString();
                   }else if (str_sex.equals("女")) {
                       radio_woman.setChecked(true);
                       patientsex = radio_woman.getText().toString();
                   }
                    edit_phone_num.setText(patientInfos.get(0).getpatientPhoneNumber());
                    edit_remark.setText(patientInfos.get(0).getpatientRemark());
                    edit_figure.setText(patientInfos.get(0).getpatientPosture());
                    edit_profession.setText(patientInfos.get(0).getpatientProfessional());
                    edit_card.setText(patientInfos.get(0).getpatientIdentityCard());
                    edit_address.setText(patientInfos.get(0).getpatientAddress());
                    patientId = patientInfos.get(0).getpatientId();
                   break;
           }
       }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        Bundle bundle = getIntent().getExtras();
        str_name = bundle.getString("str_name");
//        str_sex = bundle.getString("str_sex");
//        str_age = bundle.getString("str_age");
        img_cancel = (ImageView)findViewById(R.id.img_cancel);
        img_cancel.setOnClickListener(this);
        img_save = (ImageView)findViewById(R.id.img_save);
        img_save.setOnClickListener(this);
        edit_name = (EditText)findViewById(R.id.edit_name);
        edit_name.setText(str_name);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        radio_man = (RadioButton)findViewById(R.id.radio_man);
        radio_woman = (RadioButton)findViewById(R.id.radio_woman);
        edit_age = (EditText)findViewById(R.id.edit_age);
        edit_phone_num = (EditText)findViewById(R.id.edit_phone_num);
        edit_remark = (EditText)findViewById(R.id.edit_remark);
        edit_height = (EditText)findViewById(R.id.edit_height);
        edit_weight = (EditText)findViewById(R.id.edit_weight);
        edit_figure = (EditText)findViewById(R.id.edit_figure);
        edit_figure.setOnClickListener(this);
        edit_profession = (EditText)findViewById(R.id.edit_profession);
        edit_card = (EditText)findViewById(R.id.edit_card);
        edit_address = (EditText)findViewById(R.id.edit_address);
        bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_man:
                        patientsex = radio_man.getText().toString();
                        break;
                    case R.id.radio_woman:
                        patientsex = radio_woman.getText().toString();
                        break;
                }
            }
        });
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl+"/patientinfo/", gson);

        new Thread(getData).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_cancel:
                PatientInfoActivity.this.finish();
                break;

            case R.id.img_save:
                //保存病人个人信息，提交到数据库，并把性别，年龄传到医案记录页面
                Intent intent = new Intent(PatientInfoActivity.this,PatientRecordActivity.class);
                String str_name = edit_name.getText().toString();
                String str_sex = patientsex;

                String phone_number = edit_phone_num.getText().toString();
                String remark = edit_remark.getText().toString();
                if(edit_height.getText().toString().isEmpty()){
                     height = null;
                }else {
                     height = Integer.parseInt(edit_height.getText().toString());
                }
                if(edit_weight.getText().toString().isEmpty()){
                    weight = null;
                }else {
                    weight = Double.parseDouble(edit_weight.getText().toString());
                }
                if(edit_age.getText().toString().isEmpty()){
                    str_age = null;
                }else {
                    str_age = Integer.parseInt(edit_age.getText().toString());
                }

                String posture = edit_figure.getText().toString();
                String profession = edit_profession.getText().toString();
                String card = edit_card.getText().toString();
                String address = edit_address.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("str_name",str_name);
                bundle.putString("str_sex",str_sex);
                bundle.putString("str_age", str_age.toString());
                intent.putExtras(bundle);
                PatientInfoActivity.this.setResult(1, intent);
                PatientInfoActivity.this.finish();
                patientInfo.add(new PatientInfo(patientId,str_name,str_sex,str_age,phone_number,remark,height,weight,posture,profession,card,address));
                Call<List<PatientInfo>> call = requestClient.updatePatientinfo(patientInfo);
                try {
                    call.enqueue(new Callback<List<PatientInfo>>() {
                        @Override
                        public void onResponse(Call<List<PatientInfo>> call, Response<List<PatientInfo>> response) {

                        }

                        @Override
                        public void onFailure(Call<List<PatientInfo>> call, Throwable t) {

                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.edit_figure:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                builder.setTitle("体态");
                final String[] figure = {"偏瘦", "正常", "偏胖"};
                builder.setSingleChoiceItems(figure, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edit_figure.setText(figure[which]);

                    }
                });
                Dialog dialog = builder.create();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                builder.show();
                break;

            case R.id.bt_delete:
                //删除此档案，返回到档案列表页面
                showDialog(DELETE_DIALOG);
                System.out.print(patientId);
                break;
        }
    }
    public Dialog onCreateDialog(int id,Bundle state){
        switch (id){

            case DELETE_DIALOG:
                final AlertDialog.Builder delete = new AlertDialog.Builder(this);
                delete.setTitle("提示");
                delete.setMessage("确定删除病人和所有Ta的诊疗卡片？");
                delete.setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        call1 = requestClient.deletePatient(patientId);
                        call1.enqueue(new Callback<PatientInfo>() {
                            @Override
                            public void onResponse(Call<PatientInfo> call, Response<PatientInfo> response) {

                            }

                            @Override
                            public void onFailure(Call<PatientInfo> call, Throwable t) {

                            }
                        });
                        PatientInfoActivity.this.finish();

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
