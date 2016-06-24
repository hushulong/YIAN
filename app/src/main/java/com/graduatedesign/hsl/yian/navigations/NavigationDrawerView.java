package com.graduatedesign.hsl.yian.navigations;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

import com.graduatedesign.hsl.yian.R;

import com.graduatedesign.hsl.yian.adapters.NavigationDrawerAdapter;
import com.graduatedesign.hsl.yian.misc.BetterViewAnimator;
import com.graduatedesign.hsl.yian.misc.NavigationDrawerItem;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Michal Bialas on 19/07/14.
 */
public class NavigationDrawerView extends BetterViewAnimator {

    @InjectView(R.id.leftDrawerListView)
    ListView leftDrawerListView;

    private final NavigationDrawerAdapter adapter;


    public NavigationDrawerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        adapter = new NavigationDrawerAdapter(context);
    }

    /**
     *
     * @param items  左边下拉框中的选项，用NavigationDrawerItem 类填充
     */
    public void replaceWith(List<NavigationDrawerItem> items) {
        adapter.replaceWith(items);
        setDisplayedChildId(R.id.leftDrawerListView);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.inject(this);
        leftDrawerListView.setAdapter(adapter);
    }

    public NavigationDrawerAdapter getAdapter() {
        return adapter;
    }
}
