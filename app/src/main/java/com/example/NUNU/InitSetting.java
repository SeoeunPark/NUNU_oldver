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

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;


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

//        else if(TextUtils.isDigitsOnly(set_left.getText().toString())==false){
//            Toast.makeText(context,"좌안 시력을 숫자로 입력해주세요",Toast.LENGTH_SHORT).show();
//        }else if(TextUtils.isDigitsOnly(set_right.getText().toString())==false){
//            Toast.makeText(context,"우안 시력을 숫자로 입력해주세요",Toast.LENGTH_SHORT).show();
//        }

//        else if((Float.valueOf(set_left.getText().toString())>=-20.0 && Float.valueOf(set_left.getText().toString())<=10.0)==false) {
//            Toast.makeText(context, "좌안 시력이 범위를 벗어났습니다.", Toast.LENGTH_SHORT).show();
//        }else if((Float.valueOf(set_right.getText().toString())>=-20.0 && Float.valueOf(set_right.getText().toString())<=10.0)==false) {
//            Toast.makeText(context, "우안 시력이 범위를 벗어났습니다.", Toast.LENGTH_SHORT).show();
//        }

        rootView.findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            Boolean check = true;
            Boolean checkcheck = true;
            SimpleDateFormat fdate = new SimpleDateFormat("MM-dd");
            Date date = new Date();
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(set_name.getText().toString())){
                    Toast.makeText(context,"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(set_left.getText().toString())){
                    Toast.makeText(context,"좌안 시력을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(set_right.getText().toString())){
                    Toast.makeText(context,"우안 시력을 입력해주세요.",Toast.LENGTH_SHORT).show();
                }else if(check){
                    boolean output = true;
                    String nosign = null;
                    for(int i=0; i<set_left.getText().toString().length();i++){
                        char tmp = set_left.getText().toString().charAt(i);
                        if (tmp!='-' || tmp!='.'){
                            nosign += tmp;
                        }
                    }

                    for(int j=0; j<nosign.length();j++){
                        char tmp = nosign.charAt(j);
                        if(('0' <=tmp && tmp<='9')){
                            output=true;
                        }else{
                            output=false;
                        }
                    }
                    if(output==false){
                        Toast.makeText(context,"좌안 시력을 숫자로 작성해주세요.",Toast.LENGTH_SHORT).show();
                    }else{
                        check=false;
                    }
                }else if(checkcheck){
                    boolean output = true;
                    String nosign = null;
                    for(int i=0; i<set_right.getText().toString().length();i++){
                        char tmp = set_right.getText().toString().charAt(i);
                        if (tmp!='-' || tmp!='.'){
                            nosign += tmp;
                        }
                    }

                    for(int j=0; j<nosign.length();j++){
                        char tmp = nosign.charAt(j);
                        if(!('0' <=tmp && tmp<='9')){
                            output=false;
                        }else{
                            output=true;
                        }
                    }
                    if(output==false){
                        Toast.makeText(context,"우안 시력을 숫자로 작성해주세요.",Toast.LENGTH_SHORT).show();
                    }else{
                        checkcheck=false;
                    }
                }else{
                    Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show();
                    db.UserDao().insert(new UserInfo(set_name.getText().toString(),set_left.getText().toString(),set_right.getText().toString(),fdate.format(date)));
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