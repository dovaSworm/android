package com.example.danij.actionbarnavigationmenu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment3 extends Fragment{

    private static final String TAG = "Fragment1";
    private Button buttonF3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3_layout, container, false);
        buttonF3 = (Button) view.findViewById(R.id.btnTest3);

        buttonF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Testing btn 3 fragment 3", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
