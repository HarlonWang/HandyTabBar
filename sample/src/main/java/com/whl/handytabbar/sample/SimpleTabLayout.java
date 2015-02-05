package com.whl.handytabbar.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whl.handytabbar.tablayout.BaseTabLayout;

/**
 * Created by Administrator on 2015/2/4.
 */
public class SimpleTabLayout extends BaseTabLayout{


    @Override
    public View createView(LayoutInflater inflater, int position, ViewGroup parent, CharSequence pageTitle) {
        View view=inflater.inflate(R.layout.view_simple_tab,parent,false);
        TextView textView= (TextView) view.findViewById(R.id.text);
        textView.setTextColor(getContext().getResources().getColor(R.color.normal));
        textView.setText(pageTitle);
        return view;
    }

    @Override
    public void onTabState(View v, boolean isSelected,int position) {
        TextView textView= (TextView) v.findViewById(R.id.text);
        if (isSelected){
            textView.setTextColor(getContext().getResources().getColor(android.R.color.white));
        }else {
            textView.setTextColor(getContext().getResources().getColor(R.color.normal));
        }
    }
    
}
