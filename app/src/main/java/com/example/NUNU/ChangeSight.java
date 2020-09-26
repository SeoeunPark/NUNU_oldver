package com.example.NUNU;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class ChangeSight extends Fragment {
    TextView showleft;
    TextView showright;
    EditText editleft;
    EditText editright;
    User User = new User();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_change_sight, container, false);
        ButtonAction(rootView);
        getSightDB(rootView);
        return rootView;
    }

    private void getSightDB(ViewGroup rootView){
        Context context = getContext();
        final AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"userinfo-db")
                .fallbackToDestructiveMigration ()
                .allowMainThreadQueries()
                .build();
        showleft = rootView.findViewById(R.id.showleft);
        String left = db.UserDao().getLeft();
        showleft.setText("현재 등록된 좌안 시력은 "+left+"이에요.");
        showright = rootView.findViewById(R.id.showright);
        String right = db.UserDao().getRight();
        showright.setText("우안 시력은 "+right+"이에요.");
    }

    private void ButtonAction(ViewGroup rootView) {
        Context context = getContext();
        final AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"userinfo-db")
                .fallbackToDestructiveMigration ()
                .allowMainThreadQueries()
                .build();
        editleft = rootView.findViewById(R.id.editleftbtn);
        editright = rootView.findViewById(R.id.editrightbtn);
        ImageButton gobackbtn = (ImageButton)rootView.findViewById(R.id.exit2);
        gobackbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, User).commitAllowingStateLoss();
            }
        });
        ImageButton donebtn = (ImageButton)rootView.findViewById(R.id.done2);
        donebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editleft.getText().toString())){
                    Toast.makeText(context,"변경할 좌안 시력을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(editright.getText().toString())){
                    Toast.makeText(context,"변경할 우안 시력을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else{
                    db.UserDao().insert(new UserInfo(db.UserDao().getName(),editleft.getText().toString(),editright.getText().toString()));
                    Toast.makeText(context,"이름이 변경되었습니다.",Toast.LENGTH_SHORT).show();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, User).commitAllowingStateLoss();
                }
            }
        });
    }
}