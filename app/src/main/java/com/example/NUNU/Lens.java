package com.example.NUNU;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Lens extends Fragment implements View.OnClickListener{
    private static final String TAG= "Lens";
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    RecyclerView recyclerView;
    private List<Note> mDataItemList;
    private NoteAdapter mListAdapter;
    NoteAdapter adapter;
    Context context;
    Oneday oneday;
    Monthly monthly;

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordViewModel mWordViewModel;

    public void setListData(List<Note> dataItemList) {
        //if data changed, set new list to adapter of recyclerview

        if (mDataItemList == null) {
            mDataItemList = new ArrayList<>();
        }
        mDataItemList.clear();
        mDataItemList.addAll(dataItemList);

        if (mListAdapter != null) {
            mListAdapter.setItems(dataItemList);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_lens, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        final NoteAdapter adapter = new NoteAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(getViewLifecycleOwner(), new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable final List<Note> notes) {
                adapter.setItems(notes);
            }

        });

        //이건 데이터 삽입
        //initUI(rootView);
        //이건 floating 버튼 애니메이션
        initFL(rootView);
        //loadNoteListData();
        recyclerView.setAdapter(adapter);

        return rootView;
    } // end of onCreateView


/*
    //데이터 삽입 test
    private void initUI(ViewGroup rootView) {
        NoteAdapter mListAdapter;
        //Intent intent = new Intent(rootView.getContext(), Oneday.class);
        Context context = rootView.getContext();
        OnListFragmentInteractionListener mListener = null;
        //LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        //RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);
        //recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        mListAdapter = new NoteAdapter(mListener);

        //Model Provider
        mWordViewModel= ViewModelProviders.of(this).get(WordViewModel.class);

        //observe : model의 LiveData를 관찰한다.
        /*
        mWordViewModel.getAllWords().observe(getViewLifecycleOwner(), notes -> {
            // Update the cached copy of the words in the adapter.
            adapter.setItems(notes);
        });


        mWordViewModel.getAllWords().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setItems(notes);
            }
        });

        //adapter.addItem(new Note( "칵테일 먼슬리", "미용렌즈", 1, 1,"yellow","2020.09.02","2020.10.28"));
        //adapter.addItem(new Note( "칵테일 먼슬리", "미용렌즈", 1, 1,"yellow","2020.09.02","2020.10.28"));
        //adapter.addItem(new Note("칵테일 먼슬리", "미용렌즈", 1, 1,"yellow","2020.09.02","2020.10.28"));

        recyclerView.setAdapter(adapter);
    }

 */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Note word = new Note(data.getExtras().getString("name"),data.getExtras().getString("type"),data.getExtras().getInt("cnt"),data.getExtras().getInt("period"),data.getExtras().getString("cl"),data.getExtras().getString("start"),data.getExtras().getString("end"));
            mWordViewModel.insert(word);
        } else {
            //Toast.makeText(getActivity(), "저장되어 있는 단어가 없습니다.", Toast.LENGTH_LONG).show();
        }
    }
        //adapter = new NoteAdapter();


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
                /*
                Intent intent = new Intent(v.getContext(), Oneday.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
                 */
                //Toast.makeText(getActivity(), "Floating Action Button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab1:
                //anim();
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, oneday).commitAllowingStateLoss();
                //getActivity().startActivity(new Intent(getActivity(), oneday.getClass())); //<= 액티비티 화면 ( 네비게이션 바 안 뜸)
                Intent intent = new Intent(v.getContext(), Oneday.class); //이거 진짜 중요
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE); // 이것도 중요
                //Toast.makeText(getActivity(),"Button1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2:
                //anim();
                //getActivity().startActivity(new Intent(getActivity(), monthly.getClass()));
                Intent mintent = new Intent(v.getContext(), Monthly.class); //이거 진짜 중요
                startActivityForResult(mintent, NEW_WORD_ACTIVITY_REQUEST_CODE); // 이것도 중요
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, monthly).commitAllowingStateLoss();
                //Toast.makeText(getActivity(), "Button2", Toast.LENGTH_SHORT).show(); 버튼 누르면 토스트 발생, 지금은 필요없을 듯
                break;
        }
    }

    public void anim() {
        if (isFabOpen) {
            fab.setImageResource(R.drawable.fab_plus);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
        } else {
            fab.setImageResource(R.drawable.fab_close);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
        }
    }
    public interface OnListFragmentInteractionListener {
        //onClick items of list
        void onListClickItem(Note dataItem);

        //onClick delete item from list
        void onListFragmentDeleteItemById(long idItem);
    }


}