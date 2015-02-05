package com.whl.handytabbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.whl.handytabbar.tablayout.BaseTabLayout;
import com.whl.handytabbar.tablayout.DefaultTabLayout;


/**
 * Created by Administrator on 2015/1/30.
 */
public class HandyTabBar extends HorizontalScrollView{

    private TabBarStyle mTabBarStyle;
    private BaseTabLayout mTabLayout;
    private ViewPager mViewPager;

    private final PageListener pageListener = new PageListener();

    public OnPageChangeListener delegatePageListener;

    private TabsContainer mTabsContainer;

    private int tabCount;
    private int currentPosition = 0;
    private float currentPositionOffset = 0f;

    private int lastScrollX = 0;

    private Paint rectPaint;
    private Paint dividerPaint;

    private int mSelectedPosition;

    public HandyTabBar(Context context) {
        this(context, null);
    }

    public HandyTabBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HandyTabBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFillViewport(true);
        setWillNotDraw(false);
        init(context);
    }

    private void init(Context context) {
        mTabsContainer=new TabsContainer(context);
        addView(mTabsContainer.getContentView());

        rectPaint = new Paint();
        rectPaint.setAntiAlias(true);
        rectPaint.setStyle(Paint.Style.FILL);

        dividerPaint = new Paint();
        dividerPaint.setAntiAlias(true);

    }

    public void attachToViewPager(ViewPager viewPager){
        attachToViewPager(viewPager,null,null);
    }

    public void attachToViewPager(ViewPager viewPager,BaseTabLayout tabLayout){
        attachToViewPager(viewPager,tabLayout,null);
    }

    public void attachToViewPager(ViewPager viewPager,TabBarStyle tabBarStyle){
        attachToViewPager(viewPager,null,tabBarStyle);
    }

    public void attachToViewPager(ViewPager viewPager,BaseTabLayout tabLayout,TabBarStyle tabBarStyle){
        if (viewPager.getAdapter()==null){
            throw new IllegalStateException("ViewPager must be set a adapter at first.");
        }
        mViewPager=viewPager;
        viewPager.setOnPageChangeListener(pageListener);
        mTabLayout=tabLayout;
        if (mTabLayout==null){
            mTabLayout=new DefaultTabLayout();
        }
        mTabBarStyle=tabBarStyle;
        if (mTabBarStyle==null){
            mTabBarStyle=new TabBarStyle.Builder(getContext()).build();
        }
        setupTabs();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @SuppressLint("NewApi")
            @Override
            public void onGlobalLayout() {

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                currentPosition = mViewPager.getCurrentItem();

                scrollToChild(currentPosition, 0);

                setActiveTab(mSelectedPosition);
            }
        });
    }

    private void setupTabs() {
        tabCount=mViewPager.getAdapter().getCount();
        for (int i = 0; i < tabCount; i++) {
            final int finalI = i;
            mTabsContainer.addTab(i, mViewPager.getAdapter().getPageTitle(i),mTabLayout).setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(finalI);
                }
            });
        }
    }

    private void scrollToChild(int position, int offset) {

        if (tabCount == 0) {
            return;
        }

        int newScrollX = mTabsContainer.getChildAt(position).getLeft() + offset;

        if (position > 0 || offset > 0) {
            newScrollX -= mTabBarStyle.scrollOffset;
        }

        if (newScrollX != lastScrollX) {
            lastScrollX = newScrollX;
            scrollTo(newScrollX, 0);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (isInEditMode() || tabCount == 0) {
            return;
        }

        final int height = getHeight();

        if (mTabBarStyle.drawIndicator){
            // draw indicator line
            rectPaint.setColor(mTabBarStyle.indicatorColor);

            // default: line below current tab
            View currentTab = mTabsContainer.getChildAt(currentPosition);
            float lineLeft = currentTab.getLeft();
            float lineRight = currentTab.getRight();

            // if there is an offset, start interpolating left and right coordinates between current and next tab
            if (currentPositionOffset > 0f && currentPosition < tabCount - 1) {

                View nextTab = mTabsContainer.getChildAt(currentPosition + 1);
                final float nextTabLeft = nextTab.getLeft();
                final float nextTabRight = nextTab.getRight();

                lineLeft = (currentPositionOffset * nextTabLeft + (1f - currentPositionOffset) * lineLeft);
                lineRight = (currentPositionOffset * nextTabRight + (1f - currentPositionOffset) * lineRight);
            }

            canvas.drawRect(lineLeft, height - mTabBarStyle.indicatorHeight, lineRight, height, rectPaint);
        }

        if (mTabBarStyle.drawUnderline){
            // draw underline
            rectPaint.setColor(mTabBarStyle.underlineColor);
            canvas.drawRect(0, height - mTabBarStyle.underlineHeight, mTabsContainer.getWidth(), height, rectPaint);
        }

        if (mTabBarStyle.drawDivider){
            // draw divider
            dividerPaint.setColor(mTabBarStyle.dividerColor);
            dividerPaint.setStrokeWidth(mTabBarStyle.dividerWidth);
            for (int i = 0; i < tabCount - 1; i++) {
                View tab = mTabsContainer.getChildAt(i);
                canvas.drawLine(tab.getRight(), mTabBarStyle.dividerPadding, tab.getRight(), height - mTabBarStyle.dividerPadding, dividerPaint);
            }
        }
    }

    private void setActiveTab(int position) {
        for (int i = 0; i < tabCount; i++) {
            View v = mTabsContainer.getChildAt(i);
            boolean isSelected=false;
            if (position==i){
                isSelected=true;
            }
            mTabLayout.onTabState(v,isSelected,position);
        }
    }

    public void setOnPageChangeListener(OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    private class PageListener implements OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {



            currentPosition = position;
            currentPositionOffset = positionOffset;

            scrollToChild(position, (int) (positionOffset * mTabsContainer.getChildAt(position).getWidth()));

            invalidate();

            if (delegatePageListener != null) {
                delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {
                scrollToChild(mViewPager.getCurrentItem(), 0);
            }

            if (delegatePageListener != null) {
                delegatePageListener.onPageScrollStateChanged(state);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if (mSelectedPosition!=position){
                setActiveTab(position);
            }
            mSelectedPosition = position;
            if (delegatePageListener != null) {
                delegatePageListener.onPageSelected(position);
            }
        }
    }

    private class TabsContainer{

        private Context context;
        private LinearLayout mContentView;

        public TabsContainer(Context context){
            this.context=context;
            this.mContentView=new LinearLayout(context);
            mContentView.setOrientation(LinearLayout.HORIZONTAL);
            mContentView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }

        public LinearLayout getContentView(){
            return mContentView;
        }

        public View getChildAt(int position){
            return mContentView.getChildAt(position);
        }

        public int getWidth(){
            return mContentView.getWidth();
        }

        public View addTab(int i, CharSequence pageTitle,BaseTabLayout tabLayout) {
            tabLayout.init(context, i, pageTitle, mContentView);
            View view=tabLayout.getView();
            if (view==null){
                throw new NullPointerException("the BaseTabLayout getView() must not be null.");
            }
            mContentView.addView(view,i,new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0f));
            return view;
        }

    }

}
