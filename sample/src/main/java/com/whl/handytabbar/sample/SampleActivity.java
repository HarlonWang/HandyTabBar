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

    public static final int DEFAULT=0;
    public static final int SIMPLE=1;
    public static final int CUSTOM=2;

    private TabBarStyle mTabBarStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean isTop=getIntent().getBooleanExtra("top",true);
        if (isTop){
            setContentView(R.layout.activity_sample);
        }else {
            setContentView(R.layout.activity_sample_bottom);
        }


        initToolbar();
        initView();
        initHandyTabBar();
    }



    private void initToolbar(){
        String title=getIntent().getStringExtra("title");
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }

    private void initView() {
        mTabBar= (HandyTabBar) findViewById(R.id.tab_bar);
        mViewPager= (ViewPager) findViewById(R.id.view_pager);

        mPageAdapter=new ListPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);

    }

    private void initHandyTabBar() {
        boolean drawIndicator=getIntent().getBooleanExtra("drawIndicator",false);
        boolean drawUnderLine=getIntent().getBooleanExtra("drawUnderLine",false);
        boolean drawDivider=getIntent().getBooleanExtra("drawDivider",false);
        mTabBarStyle=new TabBarStyle.Builder(this)
                .setDrawIndicator(drawIndicator)
                .setDrawUnderline(drawUnderLine)
                .setDrawDivider(drawDivider)
                .build();
        int layoutType=getIntent().getIntExtra("type",0);
        switch (layoutType){
            case DEFAULT:
                setDefault();
                break;
            case SIMPLE:
                setSimple();
                break;
            case CUSTOM:
                setCustom();
                break;
        }
    }

    private void setDefault(){
        mTabBar.attachToViewPager(mViewPager,mTabBarStyle);
    }

    private void setSimple(){
        SimpleTabLayout simpleTabLayout=new SimpleTabLayout();
        mTabBar.attachToViewPager(mViewPager,simpleTabLayout,mTabBarStyle);
    }

    private void setCustom(){
        int[] res=new int[]{R.drawable.ic_account_balance_white_24dp,R.drawable.ic_account_box_white_24dp,R.drawable.ic_event_white_24dp,R.drawable.ic_alarm_add_white_24dp};
        CustomTabLayout customTabLayout=new CustomTabLayout(res);
        mTabBar.attachToViewPager(mViewPager,customTabLayout,mTabBarStyle);
    }

    private class ListPageAdapter extends FragmentPagerAdapter {

        private String[] items={"All","Near","Far","Mid"};

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
