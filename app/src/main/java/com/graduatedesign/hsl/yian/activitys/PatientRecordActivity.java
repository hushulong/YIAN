package com.graduatedesign.hsl.yian.activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.domain.CaseRecord;
import com.graduatedesign.hsl.yian.fragments.Card;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.list.ListViewDataAdapter;
import in.srain.cube.views.list.ViewHolderBase;
import retrofit2.Call;

/**
 * Created by Mesogene on 4/20/16.
 */
public class PatientRecordActivity extends FragmentActivity implements View.OnClickListener {
    MyApplication myApplication;
    private RelativeLayout layout_patient_info;
    private ImageView img_back;
    private TextView tv_patient_name;
    private TextView tv_patient_sex;
    private TextView tv_patient_age;
    private ListView listView;
    private Button bt_add_card;
    private Context context;
    Integer patientid;
    private Button bt_send_questionnaire;
    private List<CaseRecord> caseRecords = new ArrayList<CaseRecord>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<CaseRecord>> call = requestClient.getCaseRecordsByPatientId(patientid);
                caseRecords = call.execute().body();
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                Log.d("病案请求出错" ,e.getMessage());
            }
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    listView.setAdapter(new MyListAdapter(context));
            }

        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_record);
        context = getApplicationContext();
        layout_patient_info = (RelativeLayout)findViewById(R.id.layout_patient_info);
        layout_patient_info.setOnClickListener(this);
        img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        tv_patient_name = (TextView)findViewById(R.id.tv_patient_name);
        tv_patient_sex = (TextView)findViewById(R.id.tv_patient_sex);
        tv_patient_age = (TextView)findViewById(R.id.tv_patient_age);
        listView = (ListView)findViewById(R.id.lv_patient_card);
        bt_send_questionnaire = (Button)findViewById(R.id.bt_send_questionnaire);
        bt_add_card = (Button)findViewById(R.id.bt_add_card);
        bt_add_card.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        String str_name = bundle.getString("str_name");
        String str_sex = bundle.getString("str_sex");
        String str_age = bundle.getString("str_age");
        patientid = bundle.getInt("id");
        tv_patient_name.setText(str_name);
        tv_patient_sex.setText(str_sex);
        tv_patient_age.setText(str_age);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PatientRecordActivity.this, PatientCardActivity.class);
                Bundle bundle = new Bundle();
                Integer caseId = caseRecords.get(position).getCaseId();
                bundle.putInt("caseId",caseId);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl + "/", gson);
        listView.deferNotifyDataSetChanged();
        new Thread(getData).start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_patient_info:
                Intent intent = new Intent(PatientRecordActivity.this,PatientInfoActivity.class);
                String str_name = tv_patient_name.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("str_name",str_name);

                intent.putExtras(bundle);
                startActivityForResult(intent, 0);

                break;
            case R.id.img_back:
                PatientRecordActivity.this.finish();
                break;
            case R.id.bt_add_card:
                Intent intent1 = new Intent(PatientRecordActivity.this,AddPatientCardActivity.class);
                String str_name1 = tv_patient_name.getText().toString();
                Bundle bundle1 = new Bundle();
                bundle1.putString("str_name1",str_name1);
                intent1.putExtras(bundle1);
                startActivity(intent1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode){
            case 1:
                Bundle bundle = data.getExtras();
                String str_name = bundle.getString("str_name");
                String str_sex = bundle.getString("str_sex");
                String str_age = bundle.getString("str_age");
                tv_patient_name.setText(str_name);
                tv_patient_age.setText(str_age);
                tv_patient_sex.setText(str_sex);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    class MyListAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        public MyListAdapter(Context context){
            inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return caseRecords.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){
                convertView = inflater.inflate(R.layout.item_card_list,null);
                viewHolder = new ViewHolder();
                viewHolder.disease = (TextView)convertView.findViewById(R.id.tv_disease);
                viewHolder.date_time = (TextView)convertView.findViewById(R.id.tv_date_time);
                viewHolder.patient_name = (TextView)convertView.findViewById(R.id.tv_patient_name);
                viewHolder.summary_content = (TextView)convertView.findViewById(R.id.tv_summary_content);
                viewHolder.summary = (TextView)convertView.findViewById(R.id.tv_summary);
                viewHolder.user_image = (ImageView)convertView.findViewById(R.id.img_user_image);
                viewHolder.image_kind = (ImageView)convertView.findViewById(R.id.img_image_kind);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.disease.setText(caseRecords.get(position).getTempDiseaseId());
            viewHolder.date_time.setText(caseRecords.get(position).getCaseDate().toString());
            viewHolder.patient_name.setText(caseRecords.get(position).getTempPatientId());
            viewHolder.summary_content.setText(caseRecords.get(position).getPatientTalk());
            viewHolder.user_image.setImageResource(R.drawable.image_user);
            viewHolder.image_kind.setImageResource(R.drawable.image_kind);
            return convertView;
        }

    }
    class ViewHolder{
        TextView disease;
        TextView date_time;
        TextView patient_name;
        TextView summary;
        TextView summary_content;
        ImageView user_image;
        ImageView image_kind;
    }
}
