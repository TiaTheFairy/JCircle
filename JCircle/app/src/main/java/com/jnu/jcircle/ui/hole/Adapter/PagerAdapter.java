package com.jnu.jcircle.ui.hole.Adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    public List<Fragment> fragmentList;    //传入页面集合
    private String[] mTitles=new String[]{"To Myself","To Others"};  //others支出为0,myself  flag为1,
    public PagerAdapter(@NonNull FragmentManager fm, List<Fragment>fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }   //alt+enter添加包



    @NonNull
    @Override
    public Fragment getItem(int position) {  //返回指定位置的对象
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();   //返回长度
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
