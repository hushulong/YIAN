package com.graduatedesign.hsl.yian.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.ChineseMedicineInfoActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mesogene on 6/6/16.
 */
public class PrescriptionTransitionFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView listview;
    private Context context;
    ArrayList<HashMap<String,Object>> listItem;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_chinese_medicine_list,container,false);
        listview = (ListView) view.findViewById(R.id.lv_chinese_medicine);
        listview.setOnItemClickListener(this);
        PrescriptionAdapter adapter = new PrescriptionAdapter(context);
        listview.setAdapter(adapter);
        return view;
    }
    private ArrayList<HashMap<String,Object>> getData() {
     ArrayList<HashMap<String,Object>>listItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String,Object> map1 =new HashMap<String,Object>();
        map1.put("name","小柴胡汤（伤寒论）");
        listItem.add(map1);
        HashMap<String,Object> map2 =new HashMap<String,Object>();
        map2.put("name","六味地黄丸（准绳·女科）");
        listItem.add(map2);
        HashMap<String,Object> map3 =new HashMap<String,Object>();
        map3.put("name","肾气丸（金匮要略）");
        listItem.add(map3);
        HashMap<String,Object> map4 =new HashMap<String,Object>();
        map4.put("name","桂枝汤（伤寒论）");
        listItem.add(map4);
        HashMap<String,Object> map5 =new HashMap<String,Object>();
        map5.put("name","四物汤（太平惠民和剂居方）");
        listItem.add(map5);
        HashMap<String,Object> map6 =new HashMap<String,Object>();
        map6.put("name","归脾汤（医匮）");
        listItem.add(map6);
        HashMap<String,Object> map7 =new HashMap<String,Object>();
        map7.put("name","五苓散（伤寒论）");
        listItem.add(map7);
        HashMap<String,Object> map8 =new HashMap<String,Object>();
        map8.put("name","真武汤（伤寒论）");
        listItem.add(map8);
        HashMap<String,Object> map9 =new HashMap<String,Object>();
        map9.put("name","补阳还五汤（医林改错）");
        listItem.add(map9);
        return listItem;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        if (position >= 0) {
//            Intent intent = new Intent(getActivity(), ChineseMedicineInfoActivity.class);
//            Bundle bundle = new Bundle();
//            Integer chinese_medicine_id = chineseMedicines.get(position).getChineseMedicineId();
//            bundle.putInt("id",chinese_medicine_id);
//            intent.putExtras(bundle);
//            startActivity(intent);
//        }
    }
    class PrescriptionAdapter extends BaseAdapter {

        private LayoutInflater mLayoutInflater;
        public PrescriptionAdapter(Context context){
            this.mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return getData().size();
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
                convertView = mLayoutInflater.inflate(R.layout.item_prescription_list,null);
                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.turn_right);
                holder.title = (TextView) convertView.findViewById(R.id.chinese_medicine_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText(getData().get(position).get("name").toString());
            return convertView;
        }
    }
    class ViewHolder {
        public ImageView image;
        public TextView title;
    }
}
