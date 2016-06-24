package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;

import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.fragments.MedicineTransitionFragment;
import com.graduatedesign.hsl.yian.fragments.PrescriptionTransitionFragment;
import com.graduatedesign.hsl.yian.misc.Fragments;

/**
 * Created by Mesogene on 3/27/16.
 */
public class PrescriptionActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);
        ImageView img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        if(savedInstanceState == null){
            FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
            PrescriptionTransitionFragment fragment = new PrescriptionTransitionFragment();
            transition.replace(R.id.list_fragment,fragment);
            transition.commit();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                PrescriptionActivity.this.finish();
        }
    }
}

