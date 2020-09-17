package com.example.NUNU;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Lens extends Fragment implements View.OnClickListener{
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    RecyclerView recyclerView;
    NoteAdapter adapter;
    Context context;
    Oneday oneday;
    Monthly monthly;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lens, container, false);
        //이건 데이터 삽입
        initUI(rootView);
        //이건 floating 버튼 애니메이션
        initFL(rootView);

        return rootView;
    }
    //데이터 삽입 test
    private void initUI(ViewGroup rootView) {

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteAdapter();

        adapter.addItem(new Note(0, "칵테일 먼슬리", 1, "2020.08.30", "2020.10.30"));
        adapter.addItem(new Note(1, "메이크오버 원데이", 2, "2020.08.02", "2020.09.02"));
        adapter.addItem(new Note(2, "아몬드 쵸코", 3, "2020.08.17", "2020.11.17"));

        recyclerView.setAdapter(adapter);
    }

    private void initFL(ViewGroup rootView) {
        fab_open = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.fab_close);

        fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab1 = (FloatingActionButton) rootView.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) rootView.findViewById(R.id.fab2);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
    }

    //floating 버튼 눌르면 뜨게 작업

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        oneday = new Oneday();
        monthly = new Monthly();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab:
                anim();
                //Toast.makeText(getActivity(), "Floating Action Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab1:
                //anim();
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, oneday).commitAllowingStateLoss();
                getActivity().startActivity(new Intent(getActivity(), oneday.getClass())); //<= 액티비티 화면 ( 네비게이션 바 안 뜸)
                //Toast.makeText(getActivity(),"Button1", Toast.LENGTH_SHORT).show();

                break;
            case R.id.fab2:
                //anim();
                getActivity().startActivity(new Intent(getActivity(), monthly.getClass()));
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, monthly).commitAllowingStateLoss();
                //Toast.makeText(getActivity(), "Button2", Toast.LENGTH_SHORT).show(); 버튼 누르면 토스트 발생, 지금은 필요없을 듯
                break;
        }
    }

    public void anim() {
        if (isFabOpen) {
            fab.setImageResource(R.drawable.plus);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab.setImageResource(R.drawable.close);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }


}