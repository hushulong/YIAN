package com.graduatedesign.hsl.yian.activitys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.graduatedesign.hsl.yian.R;

import com.graduatedesign.hsl.yian.misc.Fragments;

/**
 * Created by Mesogene on 3/27/16.
 */
public class FragmentManagerActivity extends FragmentActivity{

    String title;
    int grid_classical_id;
    String [] FRAGMENT_ID = new String[]{

            Fragments.ChineseMedicine.getFragment(),
            Fragments.Prescription.getFragment(),
            Fragments.MerdianPoint.getFragment(),
            Fragments.FamousMedicalRecord.getFragment(),
            Fragments.ClassicBook.getFragment(),
            Fragments.ChinesePatentMedicine.getFragment(),
            Fragments.Ingredient.getFragment(),
            Fragments.DoseConversion.getFragment(),
            Fragments.FamousBiography.getFragment(),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_used);
        Bundle bundle = this.getIntent().getExtras();
        grid_classical_id = bundle.getInt("grid_classical_id");
        Log.i("AAAAA",""+grid_classical_id);
        title =bundle.getString("title");
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//        if(fragment == null){
//            fragment = new Fragment();
//            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
//        }
        try{
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,
                    Fragment.instantiate(FragmentManagerActivity.this,FRAGMENT_ID[grid_classical_id])).commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
