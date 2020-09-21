package com.example.NUNU;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Option extends Fragment {
    User User = new User();
    ChangeName ChangeName = new ChangeName();
    ChangeSight ChangeSight = new ChangeSight();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option, null);
        Context context=container.getContext();
        ImageButton gobackbtn = (ImageButton)view.findViewById(R.id.goback_btn);
        gobackbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, User).commitAllowingStateLoss();
            }
        });

        Button changeName = (Button)view.findViewById(R.id.editname_btn);
        changeName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, ChangeName).commitAllowingStateLoss();
            }
        });
        Button changeSight = (Button)view.findViewById(R.id.editsight_btn);
        changeSight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, ChangeSight).commitAllowingStateLoss();
            }
        });
        return view;
    }



}