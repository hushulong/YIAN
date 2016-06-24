package com.graduatedesign.hsl.yian.fragments;


import android.app.Activity;

import android.content.Context;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import in.srain.cube.image.CubeImageView;

/**
 * Created by Mesogene on 3/27/16.
 */
public class ChineseMedicineListFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnFragmentInteractionListener mListener;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Context context;
    private List<Map<String, Object>> mData;
    private ListView mListview;
    private TextView property_flavor;
    private TextView effect;
    private TextView three_grade;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ListAdapter mAdapter;
    // TODO: Rename and change types of parameters
    public static ChineseMedicineListFragment newInstance(String param1, String param2) {
        ChineseMedicineListFragment fragment = new ChineseMedicineListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ChineseMedicineListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chinese_medicine,container,false);
        context = getActivity().getApplicationContext();
        mData = getData();
        property_flavor = (TextView)view.findViewById(R.id.property_flavor);
        effect = (TextView)view.findViewById(R.id.effect);
        three_grade = (TextView)view.findViewById(R.id.san_pin);
        imageView1 = (ImageView)view.findViewById(R.id.image_xiangshang1);
        imageView2 = (ImageView)view.findViewById(R.id.image_xiangshang2);
        imageView3 = (ImageView)view.findViewById(R.id.image_xiangshang3);
        mListview = (ListView)view.findViewById(android.R.id.list);
        mListview.setAdapter(new ChineseMedicineAdapter(context));
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onFragmentInteraction(mListview.getId());
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title","五味子");
        map.put("img", R.drawable.iconfont_shicai);
        list.add(map);
        map = new HashMap<String,Object>();
        map.put("title","五味子");
        map.put("img", R.drawable.iconfont_shicai);
        map = new HashMap<String,Object>();
        map.put("title","五味子");
        map.put("img", R.drawable.iconfont_shicai);
        map = new HashMap<String,Object>();
        map.put("title","五味子");
        map.put("img", R.drawable.iconfont_shicai);
        map = new HashMap<String,Object>();
        map.put("title","五味子");
        map.put("img", R.drawable.iconfont_shicai);
        list.add(map);




        return list;
    }
    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(int id);
    }
    class ChineseMedicineAdapter extends BaseAdapter{
        private LayoutInflater layoutInflater;
        ChineseMedicineAdapter(Context context){
            this.layoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position,View convertView,ViewGroup parent){
            final ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(R.layout.medicine_list_item,null);
                holder.title = (TextView)convertView.findViewById(R.id.chinese_medicine_title);
                holder.imageView = (CubeImageView)convertView.findViewById(R.id.chinese_medicine_image);
                holder.turnRight = (ImageView)convertView.findViewById(R.id.turn_right);
                holder.imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.title.setText((String) mData.get(position).get("title"));
            holder.imageView.setImageDrawable(getResources().getDrawable(R.drawable.iconfont_shicai));
            holder.turnRight.setImageDrawable(getResources().getDrawable(R.drawable.icon_right_arrow_userinfo));
            return convertView;
        }
    }
    public final class ViewHolder{
        public TextView title;
        public CubeImageView imageView;
        public ImageView turnRight;
    }
}
