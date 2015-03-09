# HandyTabBar

Before that I have been using [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip), it's really simple to use,
But most of the time,I want to custom each tab or more things ,so I make this library with my thought,
If you like, I hope you can give me more suggestion,Of course, I am very grateful to the [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip) author provided such a good code.

## Demo

![](https://github.com/81813780/HandyTabBar/blob/master/demo4.gif)

## Usage

### Step 1

Add dependencies in build.gradle.
```groovy
	dependencies {
	   compile 'com.whl.handytabbar:library:1.0.4'
	}
```

### Step 2

Add the HandyTabBar to your layout:
```java
    <com.whl.handytabbar.HandyTabBar
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:id="@+id/tab_bar"
        android:background="@color/colorPrimary"
        />
```
In your java code with simple(Most of time I suggest you use customization,it's very flexible.):
```java
    mTabBar= (HandyTabBar) findViewById(R.id.tab_bar);
    mTabBar.attachToViewPager(mViewPager);
```

## Customization

When you use, I think you want more time to define your own, therefore, provided here

- TabBarStyle(whole HandyTabBar style):
  
```java
     TabBarStyle tabBarStyle=new TabBarStyle.Builder(this)
                      .setDrawIndicator(TabBarStyle.INDICATOR_LINE)
                      .setDrawLine(TabBarStyle.TOPLINE)
                      .setDrawDivider(drawDivider)
                      .setIndicatorHeight()
                      setDividerColor()
                      ...
                      .build();
      mTabBar.attachToViewPager(mViewPager,mTabBarStyle);
```
- TabLayout(Single Tab should be like):
  
(your need to extend BaseTabLayout,like this [SimpleTabLayout](https://github.com/81813780/HandyTabBar/blob/master/sample/src/main/java/com/whl/handytabbar/sample/SimpleTabLayout.java) [CustomTabLayout](https://github.com/81813780/HandyTabBar/blob/master/sample/src/main/java/com/whl/handytabbar/sample/CustomTabLayout.java) in sample project)
```java
        mTabBar.attachToViewPager(mViewPager,customTabLayout);
```

- Tips:
  
HandyTabBar don't provided about animation method(maybe later), but if you want to use animation,
very simple, need only in onTabState () method to implements anything you want in the animation,
I strongly recommend to use [AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations),just like this
```java
    @Override
    public void onTabState(View v, boolean isSelected,int position) {
        ImageView imageView= (ImageView) v.findViewById(R.id.yourViewID);
        if (isSelected){
            YoYo.with(Techniques.Tada)
                .duration(700)
                .playOn(imageView);
        }else {
            ...
        }
    }
```
  or look this [CustomTabLayout](https://github.com/81813780/HandyTabBar/blob/master/sample/src/main/java/com/whl/handytabbar/sample/CustomTabLayout.java);

## Thanks
- [PagerSlidingTabStrip](https://github.com/astuetz/PagerSlidingTabStrip)
- [AndroidViewAnimations](https://github.com/daimajia/AndroidViewAnimations)

##Contact me

I love open source project, if you have a better idea on this project or way, please let me know, thanks:)

[Email](mailto:81813780@qq.com)

[Weibo](http://weibo.com/601265161)
