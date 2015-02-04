# HandyTabBar

Before that I have been using [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip), it's really simple to use,
But most of the time,I hope I can do some changes ,so I try to do [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip) with some small change,
If you like, I hope you can give me more suggestion,Of course, I am very grateful to the [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip) author provided such a good code

## Demo

![](https://github.com/81813780/HandyTabBar/blob/master/demo.gif)

## Usage

Add the HandyTabBar to your layout:
```java
    <com.whl.handytabbar.HandyTabBar
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:id="@+id/tab_bar"
        android:background="@color/colorPrimary"
        />
```
In your java code:
```java
    mTabBar= (HandyTabBar) findViewById(R.id.tab_bar);
    mTabBar.attachToViewPager(mViewPager);
```

## Customization

When you use, if want more time to define your own, therefore, provided here
  1. TabBarStyle:
  
```java
     TabBarStyle tabBarStyle=new TabBarStyle.Builder(this)
                      .setDrawIndicator(drawIndicator)
                      .setDrawUnderline(drawUnderLine)
                      .setDrawDivider(drawDivider)
                      .setIndicatorHeight()
                      setDividerColor()
                      ...
                      .build();
      mTabBar.attachToViewPager(mViewPager,mTabBarStyle);
```
  2. TabLayout:
  (your need to extend BaseTabLayout,like this [SimpleTabLayout](https://github.com/81813780/HandyTabBar/blob/master/sample/src/main/java/com/whl/handytabbar/sample/SimpleTabLayout.java) [CustomTabLayout](https://github.com/81813780/HandyTabBar/blob/master/sample/src/main/java/com/whl/handytabbar/sample/CustomTabLayout.java) in sample project)
```java
        mTabBar.attachToViewPager(mViewPager,customTabLayout);
```
    
## Thanks
- [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip)

##Contact me

I love open source project, if you have a better idea on this project or way, please let me know, thanks:)

[Email](mailto:81813780@qq.com)

[Weibo](http://weibo.com/601265161)