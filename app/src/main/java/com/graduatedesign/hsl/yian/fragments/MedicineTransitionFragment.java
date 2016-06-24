package com.graduatedesign.hsl.yian.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.graduatedesign.hsl.yian.activitys.ChineseMedicineInfoActivity;
import com.graduatedesign.hsl.yian.domain.ChineseMedicineInfo;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.image.CubeImageView;
import retrofit2.Call;

public class MedicineTransitionFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView listview;
    private Context context;
    private List<ChineseMedicineInfo> chineseMedicines = new ArrayList<ChineseMedicineInfo>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<ChineseMedicineInfo>> call = requestClient.getChineseMedicineInfo("getall");
                chineseMedicines = call.execute().body();
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                Log.d("MedicineTransitionFragment", "中药信息表请求出错" + e.getMessage());
            }
        }
    };
    Handler handler = new Handler() {
        @Override
        public  void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    listview.setAdapter(new ChineseMedicineAdapter(context));
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_chinese_medicine_list,container,false);
        listview = (ListView) view.findViewById(R.id.lv_chinese_medicine);
        listview.setOnItemClickListener(this);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl+"/chinesemedicineinfo/", gson);
        listview.deferNotifyDataSetChanged();
        new Thread(getData).start();
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= 0) {
            Intent intent = new Intent(getActivity(), ChineseMedicineInfoActivity.class);
            Bundle bundle = new Bundle();
            Integer chinese_medicine_id = chineseMedicines.get(position).getChineseMedicineId();
            bundle.putInt("id",chinese_medicine_id);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    class ChineseMedicineAdapter extends BaseAdapter {

        private LayoutInflater mLayoutInflater;
        public ChineseMedicineAdapter(Context context){
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return chineseMedicines.size();
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
            ViewHolder holder;
            if (null == convertView) {
                convertView = mLayoutInflater.inflate(R.layout.item_chinese_medicine_list,null);
                holder = new ViewHolder();
                holder.mImageview = (CubeImageView)convertView.findViewById(R.id.chinese_medicine_image);
                holder.image = (ImageView) convertView.findViewById(R.id.turn_right);
                holder.title = (TextView) convertView.findViewById(R.id.chinese_medicine_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(chineseMedicines.get(position).getMedicineName());
            return convertView;
        }
    }
    class ViewHolder {
        public CubeImageView mImageview;
        public ImageView image;
        public TextView title;
    }
}
