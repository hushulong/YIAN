package com.graduatedesign.hsl.yian;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.FontAwesomeText;
import com.graduatedesign.hsl.yian.activitys.user.LoginService;
import com.graduatedesign.hsl.yian.fragments.PersonalFragment;
import com.graduatedesign.hsl.yian.misc.Fragments;
import com.njucm.cmdh.viewpager.indicator.Indicator;
import com.njucm.cmdh.viewpager.indicator.IndicatorViewPager;


public class MainActivity extends FragmentActivity {
    private IndicatorViewPager indicatorViewPager;
    MyApplication myApplication;
    private String login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_name);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabmain_viewPager);
        PersonalFragment personalFragment = new PersonalFragment();
        Bundle bundle = new Bundle();
        bundle.putString("login",login);
        personalFragment.setArguments(bundle);
        Indicator indicator = (Indicator) findViewById(R.id.tabmain_indicator);
        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        // 禁止viewpager的滑动事件
        viewPager.setCanScroll(false);
        // 设置viewpager保留界面不重新加载的页面数量
        viewPager.setOffscreenPageLimit(1);
        // 默认是1,，自动预加载左右两边的界面。设置viewpager预加载数为0。只加载加载当前界面。
        viewPager.setPrepareNumber(0);
        viewPager.setCurrentItem(1);
        myApplication = (MyApplication)getApplication();
        if(LoginService.isLogin(this)){
            isLogined();
        }

    }


    private void isLogined() {
        SharedPreferences sp1 = this.getSharedPreferences("user_config", Context.MODE_PRIVATE);
        login = sp1.getString("login", "");

    }
    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {
        private String[] tabNames = {"经典", "个人医案", "我的"};
//        private String[] tabIcons = {"fa-th", "fa-calendar-o", "fa-file-excel-o"};
        private int [] tabIcons = {R.drawable.maintab1_selector,R.drawable.maintab2_selector,R.drawable.maintab3_selector};
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
                convertView = (View) inflater.inflate(R.layout.tab_main, container, false);
              //  FontAwesomeText tv_navigationitemconvertViewIcon = (FontAwesomeText) convertView.findViewById(R.id.navigationDrawerItemIconMainIcon);
               // tv_navigationitemconvertViewIcon.setBackgroundResource(tabIcons[position]);
                ImageView imageView = (ImageView)convertView.findViewById(R.id.navigationDrawerItemIconMainIcon);
                imageView.setBackgroundResource(tabIcons[position]);
                TextView tv_navigationitemconvertViewText = (TextView) convertView.findViewById(R.id.navigationDrawerItemIconMainText);
                tv_navigationitemconvertViewText.setText(tabNames[position]);

            }
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {
            switch (position) {
                case 0:
                    return Fragment
                            .instantiate(MainActivity.this, Fragments.ONE.getFragment());
                case 1:
                    return Fragment
                            .instantiate(MainActivity.this, Fragments.TWO.getFragment());
                case 2:
                    return Fragment
                            .instantiate(MainActivity.this, Fragments.THREE.getFragment());

                default:
                    return Fragment
                            .instantiate(MainActivity.this, Fragments.TWO.getFragment());
            }

        }
    }
}





