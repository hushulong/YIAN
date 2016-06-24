package com.graduatedesign.hsl.yian.fragments;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;

import android.content.res.Resources;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.ChineseMedicineActivity;
import com.graduatedesign.hsl.yian.activitys.ChinesePatentMedicineActivity;
import com.graduatedesign.hsl.yian.activitys.ClassicBookActivity;
import com.graduatedesign.hsl.yian.activitys.DoseConversionActivity;
import com.graduatedesign.hsl.yian.activitys.FamousBiographyActivity;
import com.graduatedesign.hsl.yian.activitys.FamousMedicalRecordActivity;
import com.graduatedesign.hsl.yian.activitys.ForPublicUseActivity;
import com.graduatedesign.hsl.yian.activitys.FragmentManagerActivity;
import com.graduatedesign.hsl.yian.activitys.IngredientActivity;
import com.graduatedesign.hsl.yian.activitys.MeridianPointActivity;
import com.graduatedesign.hsl.yian.activitys.PrescriptionActivity;
import com.graduatedesign.hsl.yian.misc.MyGridView;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Michal Bialas on 19/07/14.
 */
public class ClassicalFragment extends BaseFragment {

    private String TAG = ClassicalFragment.class.getName();
    private List<Integer> imageIdList = new ArrayList<Integer>();
    private MyGridView myGridView;
    private EditText search_edit;
    private Context context;

    static final String [] grid_classical = new String[]{"药","方","经络穴位","名家医案","经典医书","中成药","食材","剂量转换","名医传记"};
    public ClassicalFragment(){

    }
    @Override
    public void onCreateView(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_one);
        context = getActivity().getApplicationContext();

        myGridView = (MyGridView)findViewById(R.id.grid_classical);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();//获取屏幕尺寸
        int w_screen = displayMetrics.widthPixels;
        int h_screen = displayMetrics.heightPixels;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3 * h_screen / 5);
        myGridView.setLayoutParams(layoutParams);
        myGridView.setAdapter(new ImageAdapter(getActivity(), grid_classical,layoutParams,displayMetrics));
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try{
                    Intent intent  = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putInt("position",position);
                    switch (position) {
                        case 0:
                            intent.setClass(getActivity(), ChineseMedicineActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 1:
                            intent.setClass(getActivity(), PrescriptionActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 2:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 3:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 4:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 5:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 6:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 7:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        case 8:
                            intent.setClass(getActivity(), ForPublicUseActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        default:
                            break;
                    }
                }catch (Resources.NotFoundException e){
                    e.printStackTrace();
                }
            }
        });


    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "--------onActivityCreated");
    }


    @Override
    public void onPause() {
        super.onPause();
        // stop auto scroll when onPause
    }

    @Override
    public void onResume() {
        super.onResume();
        // start auto scroll when onResume
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "----------onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
    public class ImageAdapter extends BaseAdapter{
        private Context context;
        private final String[] mobileValues;
        LinearLayout.LayoutParams layoutParams;
        int w_screen;
        int h_screen;
        public ImageAdapter(Context context,String[] mobileValues,LinearLayout.LayoutParams layoutParams, DisplayMetrics displayMetrics){
            this.context = context;
            this.mobileValues = mobileValues;
            this.layoutParams = layoutParams;
            this.w_screen = displayMetrics.widthPixels;
            this.h_screen = displayMetrics.heightPixels;
        }
        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View MyGridView;
            if(convertView == null){
                MyGridView = new View(context);
                MyGridView = inflater.inflate(R.layout.classical_grid_item,null);
                TextView textView = (TextView)MyGridView.findViewById(R.id.grid_classical_text);
                ImageView imageView = (ImageView)MyGridView.findViewById(R.id.grid_classical_image);
                String mobile = mobileValues[position];
                if(mobile.equals("药")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if(mobile.equals("方")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else  if(mobile.equals("经络穴位")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if(mobile.equals("名家医案")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if(mobile.equals("经典医书")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if(mobile.equals("中成药")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if (mobile.equals("食材")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else if(mobile.equals("剂量转换")){
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }else {
                    imageView.setImageResource(R.drawable.iconfont_yishu);
                    textView.setText(mobile);
                }
            }else {
                MyGridView = (View) convertView;
            }
            return MyGridView;
        }
        @Override
        public int getCount() {
            return mobileValues.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
