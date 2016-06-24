package com.graduatedesign.hsl.yian.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.graduatedesign.hsl.yian.MyApplication;
import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.activitys.AboutActivity;
import com.graduatedesign.hsl.yian.activitys.DownloadActivity;
import com.graduatedesign.hsl.yian.activitys.IngredientActivity;
import com.graduatedesign.hsl.yian.activitys.PublishActivity;
import com.graduatedesign.hsl.yian.activitys.RecommendActivity;
import com.graduatedesign.hsl.yian.activitys.SetActivity;
import com.graduatedesign.hsl.yian.activitys.UserInfoActivity;
import com.graduatedesign.hsl.yian.activitys.user.UserLoginActivity;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class PersonalFragment extends BaseFragment implements View.OnClickListener {
    private String TAG = PersonalFragment.class.getName();
    MyApplication myApplication;
    private Context context;
    private LinearLayout userInfoLayout;
    private LinearLayout publishLayout;
    private LinearLayout integrationLayout;
    private LinearLayout downloadLayout;
    private LinearLayout aboutLayout;
    private LinearLayout recommendLayout;
    private LinearLayout setLayout;
    private TextView doctorName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
            Bundle savedInstanceState) {

        context = getActivity().getApplicationContext();
        View view = inflater.inflate(R.layout.fragment_three, containter, false);
        userInfoLayout = ((LinearLayout) view.findViewById(R.id.user_info));
        doctorName = (TextView)view.findViewById(R.id.user_name);
        myApplication = (MyApplication)getApplicationContext();
        userInfoLayout.setOnClickListener(this);
        publishLayout = ((LinearLayout) view.findViewById(R.id.publish));
        publishLayout.setOnClickListener(this);
        integrationLayout = ((LinearLayout) view.findViewById(R.id.integration));
        integrationLayout.setOnClickListener(this);
        downloadLayout = ((LinearLayout) view.findViewById(R.id.download));
        downloadLayout.setOnClickListener(this);
        aboutLayout = ((LinearLayout) view.findViewById(R.id.about));
        aboutLayout.setOnClickListener(this);
        recommendLayout = ((LinearLayout) view.findViewById(R.id.recommend));
        recommendLayout.setOnClickListener(this);
        setLayout = ((LinearLayout) view.findViewById(R.id.set));
        setLayout.setOnClickListener(this);
        doctorName.setText(MyApplication.login_status);

        return view;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_info:
                if (doctorName.getText().equals("一键登录")) {
                    Intent intent0 = new Intent(PersonalFragment.this.getActivity(), UserLoginActivity.class);
                    startActivity(intent0);
                }else {
                    Intent intent = new Intent(PersonalFragment.this.getActivity(),UserInfoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("name", doctorName.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                break;
            case R.id.publish:
                Intent intent1 = new Intent(PersonalFragment.this.getActivity(),PublishActivity.class);
                startActivity(intent1);
                break;
            case R.id.integration:
                Intent intent2 = new Intent(PersonalFragment.this.getActivity(),IngredientActivity.class);
                startActivity(intent2);
                break;
            case R.id.download:
                Intent intent3 = new Intent(PersonalFragment.this.getActivity(),DownloadActivity.class);
                startActivity(intent3);
                break;
            case R.id.about:
                Intent intent4 = new Intent(PersonalFragment.this.getActivity(),AboutActivity.class);
                startActivity(intent4);
                break;
            case R.id.recommend:
                Intent intent5 = new Intent(PersonalFragment.this.getActivity(),RecommendActivity.class);
                startActivity(intent5);
                break;
            case R.id.set:
                Intent intent6 = new Intent(PersonalFragment.this.getActivity(),SetActivity.class);
                startActivity(intent6);
                break;
            default:
                break;

        }

    }

}
