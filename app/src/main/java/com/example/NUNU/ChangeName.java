package com.example.NUNU;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class ChangeName extends Fragment {

    User User = new User();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_change_name, null);
        Context context=container.getContext();
        ImageButton gobackbtn = (ImageButton)view.findViewById(R.id.exit);
        gobackbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, User).commitAllowingStateLoss();
            }
        });
        ImageButton donebtn = (ImageButton)view.findViewById(R.id.done);
        donebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"이름이 변경되었습니다.",Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, User).commitAllowingStateLoss();
            }
        });
        return view;
    }
}