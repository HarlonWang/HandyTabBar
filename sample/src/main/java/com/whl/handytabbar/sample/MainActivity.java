package com.whl.handytabbar.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.whl.handytabbar.HandyTabBar;


public class MainActivity extends ActionBarActivity {

    private ViewPager mViewPager;
    private HandyTabBar mTabBar;

    private ListPageAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabBar= (HandyTabBar) findViewById(R.id.tab_bar);
        mViewPager= (ViewPager) findViewById(R.id.view_pager);

        mPageAdapter=new ListPageAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPageAdapter);
        mTabBar.attachToViewPager(mViewPager);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class ListPageAdapter extends FragmentPagerAdapter{

        private String[] items={"ALL","NEAR","FAR","SUPERSTAR","ALL","NEAR","FAR","SUPERSTAR"};

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
