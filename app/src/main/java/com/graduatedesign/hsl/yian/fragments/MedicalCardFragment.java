package com.graduatedesign.hsl.yian.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.AddPatientCardActivity;
import com.graduatedesign.hsl.yian.activitys.PatientCardActivity;
import com.graduatedesign.hsl.yian.domain.CaseRecord;
import com.graduatedesign.hsl.yian.domain.PatientInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;
import com.graduatedesign.hsl.yian.widgetlibrary.CustomFAB;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.list.ListViewDataAdapter;
import in.srain.cube.views.list.ViewHolderBase;
import retrofit2.Call;

/**
 * Created by Mesogene on 3/16/16.
 */
public class MedicalCardFragment extends BaseFragment {
    MyApplication myApplication;
    private static final String TAG = "MedicalCardFragment";
    private ListView listView;
    private Context context;
    Fragment fragment = this;
    private ArrayList<Card> cards = new ArrayList<>();
    private List<CaseRecord> caseRecords = new ArrayList<CaseRecord>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<CaseRecord>> call = requestClient.getCaseRecordsList("getall");
                caseRecords = call.execute().body();
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                Log.d(TAG,"病案请求出错"+e.getMessage());
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
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity().getApplicationContext();
        final View view = layoutInflater.inflate(R.layout.fragment_medical_card, container,false);
        listView = (ListView) view.findViewById(R.id.lv_card);
        CustomFAB customAdd = (CustomFAB) view.findViewById(R.id.medical_card_add);
        customAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddPatientCardActivity.class);
                getActivity().startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position >=0){
                    Intent intent = new Intent(getActivity(), PatientCardActivity.class);
                    Bundle bundle = new Bundle();
                    Integer caseId = caseRecords.get(position).getCaseId();
                    bundle.putInt("caseId",caseId);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class,MyApplication.myUrl+"/caserecord/",gson);
        listView.deferNotifyDataSetChanged();
        new Thread(getData).start();
        return view;

    }


    @Override
    public void onResume() {
        super.onResume();
        new Thread(getData).start();
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyListAdapter extends BaseAdapter{
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


