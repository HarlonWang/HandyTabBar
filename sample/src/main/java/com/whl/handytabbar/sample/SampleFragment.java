package com.whl.handytabbar.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by WHL on 2015/1/30.
 */
public class SampleFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String text=getArguments().getString("text");
        TextView textView=new TextView(getActivity());
        textView.setText(text);
        return textView;
    }
}
