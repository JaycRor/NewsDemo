package com.kevinAo.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.kevinAo.news.adapter.MainTabAdapter;
import com.kevinAo.news.fragment.FirstpagerFragment;
import com.kevinAo.news.fragment.SecondpagerFragment;
import com.kevinAo.news.fragment.ThirdpagerFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * github:JaycRor
 * @author KevinLuo
 */
public class MainActivity extends AppCompatActivity {

    private TabLayout mtabLayout;//顶部标题栏选项布局
    private ViewPager mviewPager;
    private String[] mtab_title;  //存放标题名
    private List<Fragment> mfragments; // 存放Fragment的集合
    private MainTabAdapter tab_Adapter;//标题适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hidetoolbal);//替换但是保留activity_main.xml,布局可以隐藏toolbar

        //初始化fresco
        Fresco.initialize(this);

        initData();

        initView();
    }

    //初始化布局
    private void initView() {
        mtabLayout = (TabLayout) findViewById(R.id.tab_title);
        mviewPager = (ViewPager) findViewById(R.id.view_pager);
        tab_Adapter = new MainTabAdapter(getSupportFragmentManager(), mfragments, mtab_title);
        mviewPager.setAdapter(tab_Adapter);

        //tabLayout绑定viewpager
        mtabLayout.setupWithViewPager(mviewPager);
    }

    private void initData() {
        mtab_title = getResources().getStringArray(R.array.tab_title);
        mfragments = new ArrayList<>();

//        创建Fragment个数根据标题数来
        for (int i = 0; i < mtab_title.length; i++) {
            FirstpagerFragment fragment = new FirstpagerFragment();
            SecondpagerFragment fragment02 = new SecondpagerFragment();
            ThirdpagerFragment fragment03 = new ThirdpagerFragment();

            if (i == 0) mfragments.add(fragment);
            if (i == 1) mfragments.add(fragment02);
            if (i == 2) mfragments.add(fragment03);
        }
    }
}
