package com.example.danij.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment1 extends Fragment {

    private static final String TAG = "Fragment1";
    private Button btnNavigateFragment1;
    private Button btnNavigateFragment2;
    private Button btnNavigateFragment3;
    private Button btnNavSecAct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment1_layout, container, false);
        btnNavigateFragment1 = (Button) view.findViewById(R.id.btnGoToF1);
        btnNavigateFragment2 = (Button) view.findViewById(R.id.btnGoToF2);
        btnNavigateFragment3 = (Button) view.findViewById(R.id.btnGoToF3);
        btnNavSecAct = (Button) view.findViewById(R.id.btnGoToSecondActivity);

        btnNavigateFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "enter Fragment 1---------------------------------------", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        btnNavigateFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "enter Fragment 2---------------------------------------", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });
        btnNavigateFragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "enter Fragment 3---------------------------------------", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(2);
            }
        });
        btnNavSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "enter btn sec activity---------------------------------------", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
