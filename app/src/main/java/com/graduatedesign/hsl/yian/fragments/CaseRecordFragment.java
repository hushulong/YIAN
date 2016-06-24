package com.graduatedesign.hsl.yian.fragments;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.graduatedesign.hsl.yian.R;
import com.njucm.cmdh.viewpager.indicator.FixedIndicatorView;
import com.njucm.cmdh.viewpager.indicator.Indicator;
import com.njucm.cmdh.viewpager.indicator.IndicatorViewPager;
import com.njucm.cmdh.viewpager.indicator.slidebar.ColorBar;
import com.njucm.cmdh.viewpager.indicator.slidebar.ScrollBar;
import com.njucm.cmdh.viewpager.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

import static com.norbsoft.typefacehelper.TypefaceHelper.typeface;


/**
 * Created by Michal Bialas on 19/07/14.
 */
public class CaseRecordFragment extends BaseFragment {
    private IndicatorViewPager indicatorViewPager;
    FragmentTransaction fragmentTransaction;
    @Override
    public void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragment_tabmain);
        fragmentTransaction = getFragmentManager().beginTransaction();
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabmain_viewPager);
        Indicator indicator = (Indicator) findViewById(R.id.tabmain_indicator);
        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.parseColor("#eb4f38"), 2, ScrollBar.Gravity.BOTTOM));
        indicator.setOnTransitionListener(new OnTransitionTextListener().setValueFromRes(getApplicationContext(), R.color.selected_color, R.color.gray, R.dimen.text_size_medium1, R.dimen.text_size_medium1));
        viewPager.setCanScroll(true);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(1);
        // 默认是1,，自动预加载左右两边的界面。设置viewpager预加载数为0。只加载加载当前界面。
        viewPager.setPrepareNumber(1);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    }
    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"诊疗卡片", "档案列表"};
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
            if (convertView == null) {
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
            String[] types = {"cards", "records"};
            Bundle viewBundle = new Bundle();
            fragments.add(new MedicalCardFragment());
            fragments.add(new MedicalRecordsFragment());
            viewBundle.putString("type", types[position]);

            return fragments.get(position);
        }

    }

}
