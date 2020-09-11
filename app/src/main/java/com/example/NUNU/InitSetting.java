package com.example.NUNU;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.room.Room;


public class InitSetting extends Fragment {
    private EditText set_name;
    private EditText set_left;
    private EditText set_right;
    private TextView show_data;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState){
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_init_setting, container, false);
        initInfo(rootView);
        return rootView;
    }

    private void initInfo(ViewGroup rootView){
        Context context = getContext();
        final AppDatabase db = Room.databaseBuilder(context,AppDatabase.class,"userinfo-db")
                .allowMainThreadQueries()
                .build();

        set_name = rootView.findViewById(R.id.set_name);
        set_left = rootView.findViewById(R.id.set_left);
        set_right = rootView.findViewById(R.id.set_right);
        show_data = rootView.findViewById(R.id.show_data);

        show_data.setText(db.userInfo().getAll().toString());

        rootView.findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.userInfo().insert(new UserInfo(set_name.getText().toString(),set_left.getText().toString(),set_right.getText().toString()));
                String text = db.userInfo().getAll().toString();
                show_data.setText(text);
                //mResultTextView.setText(db.todoDao().getAll().get(5).toString()); getAll().get(숫자) 하면 원하는 거 가져올 수 있음
            }
        });
    }

}