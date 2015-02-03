package com.whl.handytabbar.tablayout;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whl.handytabbar.R;


/**
 * Created by Administrator on 2015/1/30.
 */
public class DefaultTabLayout extends BaseTabLayout {


    @Override
    public View createView(LayoutInflater inflater, int position, ViewGroup parent, CharSequence pageTitle) {
        TextView textView=new TextView(getContext());
        textView.setGravity(Gravity.CENTER);
        textView.setText(pageTitle);
        textView.setTextColor(getContext().getResources().getColor(android.R.color.white));
        textView.setSingleLine();
        textView.setMinWidth(160);
        textView.setPadding(15,15,15,15);
        textView.setId(R.id.title);
        return textView;
    }


}
