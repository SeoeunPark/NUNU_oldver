package com.example.NUNU;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Lens extends Fragment {

    RecyclerView recyclerView;
    NoteAdapter adapter;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lens, container, false);

        initUI(rootView);

        return rootView;
    }


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

}