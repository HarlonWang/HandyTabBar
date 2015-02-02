package com.whl.handytabbar.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Administrator on 2015/1/30.
 */
public abstract class BaseTabLayout {

    private Context mContext;

    private CharSequence pageTitle;

    private int position;

    private ViewGroup parent;


    public View getView(){
        return createView(LayoutInflater.from(mContext),position,parent,pageTitle);
    }

    public void init(Context context,int position,CharSequence pageTitle,ViewGroup parent){
        this.pageTitle=pageTitle;
        mContext=context;
        this.parent=parent;
        this.position=position;
    }

    public void setItemPosition(int position){
        this.position=position;
    }

    public int getItemPosition(){
        return position;
    }

    public Context getContext(){
        return mContext;
    }

    public abstract View createView(LayoutInflater inflater,int position,ViewGroup parent,CharSequence pageTitle);

}
