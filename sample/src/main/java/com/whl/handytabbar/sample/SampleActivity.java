package com.whl.handytabbar.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.whl.handytabbar.HandyTabBar;
import com.whl.handytabbar.TabBarStyle;

/**
 * Created by Administrator on 2015/2/3.
 */
public class SampleActivity extends ActionBarActivity{


    private ViewPager mViewPager;
    private HandyTabBar mTabBar;

    private ListPageAdapter mPageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);


        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Detail");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        mTabBar= (HandyTabBar) findViewById(R.id.tab_bar);
        mViewPager= (ViewPager) findViewById(R.id.view_pager);

        mPageAdapter=new ListPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);

        String simple=getIntent().getStringExtra("simple");
        if (!TextUtils.isEmpty(simple)){
            setSimple();
        }else {
            setDefault();
        }
    }

    private void setDefault(){
        mTabBar.attachToViewPager(mViewPager);
    }

    private void setSimple(){
        TabBarStyle tabBarStyle=new TabBarStyle.Builder(this).setDrawDivider(false).setDrawIndicator(false).build();
        mTabBar.attachToViewPager(mViewPager,tabBarStyle);
    }

    private class ListPageAdapter extends FragmentPagerAdapter {

        private String[] items={"ALL","NEAR","FAR","SUPERSTAR"};

        public ListPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment sampleFragment=new SampleFragment();
            Bundle bundle=new Bundle();
            bundle.putString("text","Fragment_"+i);
            sampleFragment.setArguments(bundle);
            return sampleFragment;
        }

        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return items[position];
        }
    }

}
