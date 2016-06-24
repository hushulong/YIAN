package com.graduatedesign.hsl.yian.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.graduatedesign.hsl.yian.R;
import com.graduatedesign.hsl.yian.fragments.ChineseMedicineDetialFragment;
import com.njucm.cmdh.viewpager.indicator.Indicator;
import com.njucm.cmdh.viewpager.indicator.IndicatorViewPager;
import com.njucm.cmdh.viewpager.indicator.slidebar.ColorBar;
import com.njucm.cmdh.viewpager.indicator.slidebar.ScrollBar;
import com.njucm.cmdh.viewpager.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;

import static com.norbsoft.typefacehelper.TypefaceHelper.typeface;

/**
 * Created by Mesogene on 6/5/16.
 */
public class ChineseMedicineInfoActivity extends FragmentActivity implements View.OnClickListener{
    private IndicatorViewPager indicatorViewPager;
    private ImageView img_back;
    private ImageView img_note;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_medicine_info);
        img_back = (ImageView)findViewById(R.id.img_back);
        img_back.setOnClickListener(this);
        img_note = (ImageView)findViewById(R.id.img_note);
        img_note.setOnClickListener(this);
        TextView medicine_name = (TextView)findViewById(R.id.tv_medicine_name);
        ViewPager viewPager = (ViewPager)findViewById(R.id.tabmain_viewPager);
        Indicator indicator = (Indicator)findViewById(R.id.tabmain_indicator);
        indicator.setScrollBar(new ColorBar(getApplicationContext(), getResources().getColor(R.color.maincolor), 2, ScrollBar.Gravity.BOTTOM));
        indicator.setOnTransitionListener(new OnTransitionTextListener().setValueFromRes(getApplicationContext(), R.color.green_dark, R.color.gray, R.dimen.text_size_medium1, R.dimen.text_size_medium1));
        indicatorViewPager = new IndicatorViewPager(indicator,viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setCanScroll(true);
        viewPager.setOffscreenPageLimit(0);
        viewPager.setPrepareNumber(1);
        viewPager.setCurrentItem(0);
    }
    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter{
        private String[] tabNames = {"概述","应用","饮片","炮制"};
        private LayoutInflater inflater;
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
            inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return tabNames.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if(convertView == null) {
                convertView = (TextView) inflater.inflate(R.layout.tab_top, container, false);
            }
                TextView textView = (TextView) convertView;
                typeface(textView);
                textView.setText(tabNames[position]);
                return textView;

        }

        @Override
        public Fragment getFragmentForPage(int position) {
            ArrayList<Fragment> fragments = new ArrayList<Fragment>();
            String[] types = {"summary","apply","yinpian","processing"};
            Bundle bundle = new Bundle();
            Fragment fragment = new ChineseMedicineDetialFragment();
            bundle.putString("type", types[position]);
            fragment.setArguments(bundle);
            return fragment;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                ChineseMedicineInfoActivity.this.finish();
                break;
            case R.id.img_note:
                Intent intent = new Intent(ChineseMedicineInfoActivity.this,AddNoteActivity.class);
                startActivity(intent);
                break;
        }
    }
}
