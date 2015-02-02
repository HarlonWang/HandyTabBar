package com.whl.handytabbar;

import android.content.Context;


/**
 * Created by Administrator on 2015/1/30.
 */
public final class TabBarStyle {

    public final int indicatorColor ;
    public int underlineColor ;
    public int dividerColor ;

    public int indicatorHeight ;
    public int underlineHeight ;
    public int dividerPadding ;
    public int tabPadding ;
    public int dividerWidth ;

    public int scrollOffset ;

    public final boolean drawIndicator;

    public boolean drawDivider;

    public boolean drawUnderline;

    private TabBarStyle(Builder builder){
        this.indicatorColor=builder.indicatorColor;
        this.underlineColor=builder.underlineColor;
        this.dividerColor=builder.dividerColor;
        this.indicatorHeight=builder.indicatorHeight;
        this.underlineHeight=builder.underlineHeight;
        this.dividerPadding=builder.dividerPadding;
        this.tabPadding=builder.tabPadding;
        this.dividerWidth=builder.dividerWidth;
        this.scrollOffset=builder.scrollOffset;
        this.drawIndicator=builder.drawIndicator;
        this.drawDivider=builder.drawDivider;
        this.drawUnderline=builder.drawUnderline;
    }


    public static class Builder{

        private Context mContext;

        private int indicatorColor = 0xFFFFFFFF;
        private int underlineColor = 0xFFFFFFFF;
        private int dividerColor = 0xFFFFFFFF;

        private int indicatorHeight = 8;
        private int underlineHeight = 2;
        private int dividerPadding = 12;
        private int tabPadding = 24;
        private int dividerWidth = 1;

        private int scrollOffset = 52;


        private boolean drawIndicator=true;

        private boolean drawDivider=true;

        private boolean drawUnderline=true;

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


        public Builder setUnderlineColor(int underlineColor) {
            this.underlineColor = underlineColor;
            return this;
        }

        public Builder setUnderlineColorResource(int resId) {
            this.underlineColor = mContext.getResources().getColor(resId);
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


        public Builder setUnderlineHeight(int underlineHeight) {
            this.underlineHeight = underlineHeight;
            return this;
        }

        public Builder setDividerPadding(int dividerPadding) {
            this.dividerPadding = dividerPadding;
            return this;
        }

        public Builder setTabPadding(int tabPadding) {
            this.tabPadding = tabPadding;
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

        public Builder setDrawIndicator(boolean drawIndicator) {
            this.drawIndicator = drawIndicator;
            return this;
        }

        public Builder setDrawDivider(boolean drawDivider) {
            this.drawDivider = drawDivider;
            return this;
        }

        public Builder setDrawUnderline(boolean drawUnderline) {
            this.drawUnderline = drawUnderline;
            return this;
        }


        public TabBarStyle build(){
            return new TabBarStyle(this);
        }


    }

}
