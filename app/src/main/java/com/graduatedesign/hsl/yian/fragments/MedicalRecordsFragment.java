package com.graduatedesign.hsl.yian.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.AddPatientRecordsActivity;
import com.graduatedesign.hsl.yian.activitys.PatientRecordActivity;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;
import com.graduatedesign.hsl.yian.widgetlibrary.CustomFAB;
import java.util.ArrayList;
import java.util.List;
import android.os.Handler;

import retrofit2.Call;

/**
 * Created by Mesogene on 3/16/16.
 */
public class MedicalRecordsFragment extends BaseFragment{
    MyApplication myApplication;
    String str_name;
    String str_sex;
    String str_age;
    Integer patientId;
    private ListView listView;
    private CustomFAB customAdd;
    private Context context;
    private List<PatientInfo>patientInfos = new ArrayList<PatientInfo>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<PatientInfo>> call = requestClient.getPatientInfoList("getall");
                patientInfos = call.execute().body();
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                Log.d("MedicalRecordsFragment","病人信息表请求出错" + e.getMessage());
            }
        }
    };
    Handler handler = new Handler() {
        @Override
       public  void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                   listView.setAdapter(new MyListAdapter(context));
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_medical_records,container,false);
        listView = (ListView) view.findViewById(R.id.listView);
        customAdd = (CustomFAB) view.findViewById(R.id.medical_card_add);
        customAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), AddPatientRecordsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position >= 0) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), PatientRecordActivity.class);
                    Bundle bundle = new Bundle();
                    str_name = patientInfos.get(position).getpatientName();
                    str_sex = patientInfos.get(position).getpatientSex();
                    patientId = patientInfos.get(position).getpatientId();
                    if(patientInfos.get(position).getpatientAge()==null){
                        str_age = "";
                    }else{
                        str_age = patientInfos.get(position).getpatientAge().toString();
                    }
                    bundle.putInt("id",patientId);
                    bundle.putString("str_name",str_name);
                    bundle.putString("str_sex",str_sex);
                    bundle.putString("str_age",str_age);
                    intent.putExtras(bundle);
                    getActivity().startActivity(intent);
                   // Toast.makeText(getApplicationContext(), "start PatientRecordActivity", Toast.LENGTH_SHORT).show();
                }
            }

        });
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/patientinfo/",gson);

        listView.deferNotifyDataSetChanged();
        new Thread(getData).start();
        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        new Thread(getData).start();
    }

    class MyListAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        public MyListAdapter(Context context){
           inflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return patientInfos.size();
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
                convertView = inflater.inflate(R.layout.item_records_list,null);
                viewHolder = new ViewHolder();
                viewHolder.tv_name = (TextView)convertView.findViewById(R.id.tv_patient_name);
                viewHolder.tv_sex = (TextView)convertView.findViewById(R.id.tv_patient_sex);
                viewHolder.tv_age = (TextView)convertView.findViewById(R.id.tv_patient_age);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder)convertView.getTag();
            }
            viewHolder.tv_name.setText(patientInfos.get(position).getpatientName());
            viewHolder.tv_sex.setText(patientInfos.get(position).getpatientSex());
            if (patientInfos.get(position).getpatientAge() == null){
                viewHolder.tv_age.setText("");
            }else {
                viewHolder.tv_age.setText(patientInfos.get(position).getpatientAge() + "");
            }
            return convertView;
        }

    }
    class ViewHolder{
        TextView tv_name;
        TextView tv_sex;
        TextView tv_age;
    }
}
