package com.example.NUNU;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;


public class InitSetting extends Fragment {
    public EditText set_name;
    public EditText set_left;
    public EditText set_right;
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
                .fallbackToDestructiveMigration ()
                .allowMainThreadQueries()
                .build();

        set_name = rootView.findViewById(R.id.set_name);
        set_left = rootView.findViewById(R.id.set_left);
        set_right = rootView.findViewById(R.id.set_right);
        show_data = rootView.findViewById(R.id.show_data);

        show_data.setText(db.UserDao().getAll().toString());

        rootView.findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(set_name.getText().toString())){
                    Toast.makeText(context,"You have to write name",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(set_left.getText().toString())){
                    Toast.makeText(context,"You have to write left sight",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(set_right.getText().toString())){
                    Toast.makeText(context,"You have to write right sight",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show();
                    db.UserDao().insert(new UserInfo(set_name.getText().toString(),set_left.getText().toString(),set_right.getText().toString()));
                }
                String text = db.UserDao().getAll().toString();
                show_data.setText(text);
                //show_data.setText(db.todoDao().getAll().get(5).toString()); getAll().get(숫자) 하면 원하는 거 가져올 수 있음
            }
        });
        rootView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.UserDao().deleteAll();
                String text = db.UserDao().getAll().toString();
                show_data.setText(text);
            }
        });

    }

}