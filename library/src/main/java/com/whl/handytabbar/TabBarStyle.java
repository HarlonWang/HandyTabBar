package com.whl.handytabbar;

import android.content.Context;


/**
 * Created by Administrator on 2015/1/30.
 */
public final class TabBarStyle {


    public static final int UNDERLINE=0;
    public static final int TOPLINE=1;
    public static final int BOTHLINE=2;
    public static final int NONELINE=3;
    
    public static final int INDICATOR_LINE=0;
    public static final int INDICATOR_NONE=1;
    public static final int INDICATOR_TRIANGLE=2;

    public final int indicatorColor ;
    public int lineColor ;
    public int dividerColor ;

    public int indicatorHeight ;
    public int lineHeight ;
    public int dividerPadding ;
    public int dividerWidth ;

    public int scrollOffset ;

    public int drawIndicator;

    public boolean drawDivider;

    public int drawLine;
    

    private TabBarStyle(Builder builder){
        this.indicatorColor=builder.indicatorColor;
        this.lineColor=builder.lineColor;
        this.dividerColor=builder.dividerColor;
        this.indicatorHeight=builder.indicatorHeight;
        this.lineHeight=builder.lineHeight;
        this.dividerPadding=builder.dividerPadding;
        this.dividerWidth=builder.dividerWidth;
        this.scrollOffset=builder.scrollOffset;
        this.drawIndicator=builder.drawIndicator;
        this.drawDivider=builder.drawDivider;
        this.drawLine=builder.drawLine;
    }


    public static class Builder{

        private Context mContext;

        private int indicatorColor = 0xFFFFFFFF;
        private int lineColor = 0xFFFFFFFF;
        private int dividerColor = 0xFFFFFFFF;

        private int indicatorHeight = 12;
        private int lineHeight = 2;
        private int dividerPadding = 12;
        private int dividerWidth = 1;

        private int scrollOffset = 52;


        private int drawIndicator;

        private boolean drawDivider=false;

        private int drawLine=0;

        public Builder(Context context){
            mContext=context;
        }

        public Builder setIndicatorHeight(int indicatorHeight) {
            this.indicatorHeight = indicatorHeight;
            return this;
        }

        public Builder setIndicatorColor(int indicatorColor) {
            this.indicatorColor = indicatorColor;
            return this;
        }

        public Builder setIndicatorColorResource(int resId){
            this.indicatorColor=mContext.getResources().getColor(resId);
            return this;
        }


        public Builder setlineColor(int lineColor) {
            this.lineColor = lineColor;
            return this;
        }

        public Builder setlineColorResource(int resId) {
            this.lineColor = mContext.getResources().getColor(resId);
            return this;
        }


        public Builder setDividerColor(int dividerColor) {
            this.dividerColor = dividerColor;
            return this;
        }

        public Builder setDividerColorResource(int resId) {
            this.dividerColor = mContext.getResources().getColor(resId);
            return this;
        }


        public Builder setlineHeight(int lineHeight) {
            this.lineHeight = lineHeight;
            return this;
        }

        public Builder setDividerPadding(int dividerPadding) {
            this.dividerPadding = dividerPadding;
            return this;
        }

        public Builder setDividerWidth(int dividerWidth) {
            this.dividerWidth = dividerWidth;
            return this;
        }

        public Builder setScrollOffset(int scrollOffset) {
            this.scrollOffset = scrollOffset;
            return this;
        }

        public Builder setDrawIndicator(int drawIndicator) {
            this.drawIndicator = drawIndicator;
            return this;
        }

        public Builder setDrawDivider(boolean drawDivider) {
            this.drawDivider = drawDivider;
            return this;
        }

        public Builder setDrawLine(int drawLine){
            this.drawLine=drawLine;
            return this;
        } 


        public TabBarStyle build(){
            return new TabBarStyle(this);
        }


    }

}
