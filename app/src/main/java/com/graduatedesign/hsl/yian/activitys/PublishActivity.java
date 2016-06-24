package com.graduatedesign.hsl.yian.activitys;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;


import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.fragments.MedicineTransitionFragment;
import com.graduatedesign.hsl.yian.fragments.NoteTransitionFragment;


/**
 * Created by Mesogene on 3/30/16.
 */
public class PublishActivity extends FragmentActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ImageView img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        if(savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            NoteTransitionFragment fragment = new NoteTransitionFragment();
            transaction.replace(R.id.list_publish_fragment,fragment);
            transaction.commit();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                PublishActivity.this.finish();
                break;
        }
    }
}
