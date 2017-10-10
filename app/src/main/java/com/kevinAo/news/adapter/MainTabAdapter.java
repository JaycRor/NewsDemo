package com.kevinAo.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by AdminJax on 2017/10/9.
 */

public class MainTabAdapter extends FragmentPagerAdapter {
    private List<Fragment> mfragmentList;
    private String[] mlist_title_name;

    //构造方法
    public MainTabAdapter(FragmentManager fm, List<Fragment> fragmentList, String[] list_title_name) {
        super(fm);
        mfragmentList=fragmentList;
        mlist_title_name=list_title_name;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mlist_title_name[position];
    }
}