package com.example.NUNU;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import com.google.android.material.tabs.TabLayout;

public class Home extends Fragment {
    TabLayout tabs;
    Fragment sightTest;
    Fragment otherTest;
    Fragment numTest;
    Fragment selected = null;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_home, container, false);
        sightTest = new sightTest();
        otherTest = new otherTest();
        numTest = new numTest();

        tabs = mView.findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("근시난시테스트"));
        tabs.addTab(tabs.newTab().setText("다른글자찾기"));
        tabs.addTab(tabs.newTab().setText("숫자맞추기"));

        getFragmentManager().beginTransaction().replace(R.id.contatiner, sightTest).commit();

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 0) {
                    selected = sightTest;
                } else if (position == 1) {
                    selected = otherTest;
                } else if (position == 2) {
                    selected = numTest;
                }


                getFragmentManager().beginTransaction().replace(R.id.contatiner, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return mView;
    }
}