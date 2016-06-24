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
import com.graduatedesign.hsl.yian.activitys.AddNoteActivity;
import com.graduatedesign.hsl.yian.activitys.ChineseMedicineInfoActivity;
import com.graduatedesign.hsl.yian.activitys.NoteInfoActivity;
import com.graduatedesign.hsl.yian.domain.Note;
import com.graduatedesign.hsl.yian.service.ServiceGenerator;
import com.graduatedesign.hsl.yian.utils.RequestClient;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.image.CubeImageView;
import retrofit2.Call;

/**
 * Created by Mesogene on 6/6/16.
 */
public class NoteTransitionFragment extends BaseFragment implements AdapterView.OnItemClickListener{
    private ListView listview;
    private Context context;
    private List<Note> notes = new ArrayList<Note>();
    RequestClient requestClient;
    Runnable getData = new Runnable() {
        @Override
        public void run() {
            try{
                Call<List<Note>> call = requestClient.getNoteList("getall");
                notes = call.execute().body();
                handler.sendEmptyMessage(0);
            }catch (Exception e){
                Log.d("NoteTransitionFragment","笔记信息请求出错"+e.getMessage());
            }
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    listview.setAdapter(new NoteAdapter(context));
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_chinese_medicine_list,container,false);
        listview = (ListView)view.findViewById(R.id.lv_chinese_medicine);
        listview.setOnItemClickListener(this);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        requestClient = ServiceGenerator.createService(RequestClient.class, MyApplication.myUrl + "/note/", gson);
        listview.deferNotifyDataSetChanged();
        new Thread(getData).start();
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        new Thread(getData).start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position >= 0) {
            Intent intent = new Intent(NoteTransitionFragment.this.getActivity(), NoteInfoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("content",notes.get(position).getNoteContent());
            bundle.putInt("id",notes.get(position).getMyNoteId());
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
    class NoteAdapter extends BaseAdapter {

        private LayoutInflater mLayoutInflater;
        public NoteAdapter(Context context){
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return notes.size();
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
                convertView = mLayoutInflater.inflate(R.layout.item_note_list,null);
                holder = new ViewHolder();
                holder.mImageview = (CubeImageView)convertView.findViewById(R.id.chinese_medicine_image);
                holder.note_content = (TextView) convertView.findViewById(R.id.note_content);
                holder.title = (TextView) convertView.findViewById(R.id.chinese_medicine_title);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.note_content.setText(notes.get(position).getNoteContent());
            return convertView;
        }
    }
    class ViewHolder {
        public CubeImageView mImageview;
        public TextView note_content;
        public TextView title;
    }
}
