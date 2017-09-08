package com.hyperdev.androidme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;



public class BodyPartFragment extends Fragment {

    private static final String parts = "parts";
    private static final String parts_= "parts_";
    private int partIndex;
    private List<Integer> iPart;
    private ImageView i_imgview;

public BodyPartFragment(){}
    public void setiPart(List<Integer> ipartList){
        this.iPart = ipartList;
    }

    public void setpartIndex(int mPartIndex){
        this.partIndex = mPartIndex;
    }

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (savedInstanceState != null) {
        iPart = savedInstanceState.getIntegerArrayList(parts);
        partIndex = savedInstanceState.getInt(parts_);
    }

    View view = inflater.inflate(R.layout.body_part_fragment, container, false);
    i_imgview = (ImageView) view.findViewById(R.id.bodyImg);
    if (iPart != null) {
        i_imgview.setImageResource(iPart.get(partIndex));

        i_imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (partIndex < iPart.size() - 1) {
                    partIndex++;
                } else {
                    partIndex = 0;
                }
                i_imgview.setImageResource(iPart.get(partIndex));
            }
        });
    }
    return view;
}
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(parts,(ArrayList<Integer>)iPart);
        outState.putInt(parts_,partIndex);
    }

}

