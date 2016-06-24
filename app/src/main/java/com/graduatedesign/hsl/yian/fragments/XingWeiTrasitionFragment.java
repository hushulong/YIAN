package com.graduatedesign.hsl.yian.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.graduatedesign.hsl.yian.R;

/**
 * Created by Mesogene on 6/2/16.
 */
public class XingWeiTrasitionFragment extends BaseFragment implements View.OnClickListener{
    RadioGroup group_xing;
    RadioGroup group_wei;
    Button bt_sure;
    public static XingWeiTrasitionFragment newInstance(){
        return new XingWeiTrasitionFragment();
    }
    public XingWeiTrasitionFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_xing_wei,container,false);
        group_xing = (RadioGroup)view.findViewById(R.id.group_xing);
        group_wei = (RadioGroup)view.findViewById(R.id.group_wei);
        bt_sure = (Button)view.findViewById(R.id.bt_sure);
        bt_sure.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_sure:
                FragmentTransaction transition = getFragmentManager().beginTransaction();
                MedicineTransitionFragment fragment = new MedicineTransitionFragment();
                transition.replace(R.id.list_fragment,fragment);
                transition.commit();
                break;
        }
    }
}
