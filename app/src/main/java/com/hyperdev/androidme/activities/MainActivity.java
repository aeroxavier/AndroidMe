package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.AndroidImageAssets;
import com.hyperdev.androidme.fragments.BodyPartFragment;

public class MainActivity extends AppCompatActivity {
    private BodyPartFragment Head;
    private BodyPartFragment Body;
    private BodyPartFragment Leg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            Head = new BodyPartFragment();
            Head.setiPart(AndroidImageAssets.getHeads());
            int headPosition = getIntent().getIntExtra("headPos", 0);
            Head.setpartIndex(headPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.ihead, Head)
                    .commit();

            Body = new BodyPartFragment();
            Body.setiPart(AndroidImageAssets.getBodies());
            int bodyPosition = getIntent().getIntExtra("bodyPos", 0);
            Body.setpartIndex(bodyPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.ibody, Body)
                    .commit();

            Leg = new BodyPartFragment();
            Leg.setiPart(AndroidImageAssets.getLegs());
            int legPosition = getIntent().getIntExtra("legPos", 0);
            Leg.setpartIndex(legPosition);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.ileg, Leg)
                    .commit();
        }



    }
}
