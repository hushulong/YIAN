package com.graduatedesign.hsl.yian.activitys;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.misc.Fragments;

/**
 * Created by Mesogene on 3/27/16.
 */
public class FamousMedicalRecordActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_used);
        try{
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    Fragment.instantiate(FamousMedicalRecordActivity.this, Fragments.FamousMedicalRecord.getFragment())).commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}

