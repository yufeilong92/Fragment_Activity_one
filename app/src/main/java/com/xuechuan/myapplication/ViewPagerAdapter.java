package com.xuechuan.myapplication;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: demo
 * @Package com.xuechuan
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/9/6 16:11
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mLists;
    private List<String> mtitles;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> lists, List<String> titles) {
        super(fm);
        this.mtitles = titles;
        this.mLists = lists;

    }

    @Override
    public Fragment getItem(int position) {
        return mLists.get(position);
    }

    @Override
    public int getCount() {
        return mLists.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }
}
