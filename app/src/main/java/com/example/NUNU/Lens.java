package com.example.NUNU;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.ArrayList;

public class Lens extends Fragment implements View.OnClickListener{
    private static final String TAG= "Lens";
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
        //loadNoteListData();
        return rootView;
    }



    //데이터 삽입 test
    private void initUI(ViewGroup rootView) {

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteAdapter();

        adapter.addItem(new Note(0, "칵테일 먼슬리", "미용렌즈", 1, "2020.10.30","yellow","2020.09.02","2020.10.28"));
        adapter.addItem(new Note(1, "칵테일 먼슬리", "미용렌즈", 1, "2020.10.30","yellow","2020.09.02","2020.10.28"));
        adapter.addItem(new Note(2, "칵테일 먼슬리", "미용렌즈", 1, "2020.10.30","yellow","2020.09.02","2020.10.28"));

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
    //여기부터 해야함
    public int loadNoteListData() {
        AppConstants.println("loadNoteListData called.");

        String sql = "select _id, LENS_NAME, LENS_TYPE, LENS_CNT, LENS_PERIOD, LENS_COLOR, LENS_START, LENS_END from " + NoteDatabase.TABLE_NOTE + " order by CREATE_DATE desc";

        int recordCount = -1;
        NoteDatabase database = NoteDatabase.getInstance(context);
        if (database != null) {
            Cursor outCursor = database.rawQuery(sql);

            recordCount = outCursor.getCount();
            AppConstants.println("record count : " + recordCount + "\n");

            ArrayList<Note> items = new ArrayList<Note>();

            for (int i = 0; i < recordCount; i++) {
                outCursor.moveToNext();

                int _id = outCursor.getInt(0);
                String lens_name = outCursor.getString(1);
                String lens_type = outCursor.getString(2);
                int lens_cnt = outCursor.getInt(3); // cnt
                String lens_period = outCursor.getString(4);
                String lens_color = outCursor.getString(5);
                String lens_start = outCursor.getString(6);
                String lens_end = outCursor.getString(7);
                //String dateStr = outCursor.getString(8);
                /*
                if (dateStr != null && dateStr.length() > 10) {
                    try {
                        Date inDate = AppConstants.dateFormat4.parse(dateStr);
                        createDateStr = AppConstants.dateFormat3.format(inDate);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    createDateStr = "";
                }

                 */

                AppConstants.println("#" + i + " -> " + _id + ", " + lens_name + ", " +
                        lens_type + ", " + lens_cnt + ", " + lens_period + ", " + lens_color + ", " +
                        lens_start + ", " + lens_end);

                items.add(new Note(_id, lens_name, lens_type, lens_cnt, lens_period, lens_color, lens_start, lens_end));
            }

            outCursor.close();

            adapter.setItems(items);
            adapter.notifyDataSetChanged();

        }

        return recordCount;
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