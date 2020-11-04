package com.example.NUNU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.Room;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InitInfo extends AppCompatActivity {
    public EditText set_name;
    public EditText set_left;
    public EditText set_right;
    private TextView show_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initinfo);
        Button add_button = (Button) findViewById(R.id.add_button);

        final AppDatabase db = Room.databaseBuilder(this,AppDatabase.class,"userinfo-db")
                .fallbackToDestructiveMigration ()
                .allowMainThreadQueries()
                .build();

        set_name = findViewById(R.id.set_name);
        set_left = findViewById(R.id.set_left);
        set_right = findViewById(R.id.set_right);
        show_data = findViewById(R.id.show_data);

        show_data.setText(db.UserDao().getAll().toString());

        add_button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        SimpleDateFormat fdate = new SimpleDateFormat("MM-dd");
                        Date date = new Date();
                        Boolean check = true;
                        Boolean check2 = true;
                        if(TextUtils.isEmpty(set_name.getText().toString())){
                            Toast.makeText(getApplicationContext(),"이름을 입력해주세요.",Toast.LENGTH_SHORT).show();
                        }else if(TextUtils.isEmpty(set_left.getText().toString())){
                            Toast.makeText(getApplicationContext(),"좌안 시력을 입력해주세요.",Toast.LENGTH_SHORT).show();
                        }else if(TextUtils.isEmpty(set_right.getText().toString())) {
                            Toast.makeText(getApplicationContext(), "우안 시력을 입력해주세요.", Toast.LENGTH_SHORT).show();
                        }else if(check){
                            char tmp;
                            int count = 0;
                            for(int i=0; i<set_left.getText().toString().length();i++) {
                                tmp = set_left.getText().toString().charAt(i);
                                int num = (int)tmp;
                                if(!(num==45 || num==46 || (num>=48 && num<=57))) {
                                    count++;
                                }
                            }
                            if(count!=0){
                                Toast.makeText(getApplicationContext(), "좌안 시력을 숫자로 입력해주세요.", Toast.LENGTH_SHORT).show();
                                check=true;
                            }else{
                                check = false;
                            }
                        }else if(check2){
                            char tmp;
                            int count = 0;
                            for(int i=0; i<set_right.getText().toString().length();i++) {
                                tmp = set_right.getText().toString().charAt(i);
                                int num = (int)tmp;
                                if(!(num==45 || num==46 || (num>=48 && num<=57))) {
                                    count++;
                                }
                            }
                            if(count!=0){
                                Toast.makeText(getApplicationContext(), "우안 시력을 숫자로 입력해주세요.", Toast.LENGTH_SHORT).show();
                                check2=true;
                            }else{
                                check2 = false;
                            }
                        }else if((Float.valueOf(set_left.getText().toString())>=-20.0 && Float.valueOf(set_left.getText().toString())<=10.0)==false) {
                            Toast.makeText(getApplicationContext(), "좌안 시력이 범위를 벗어났습니다.", Toast.LENGTH_SHORT).show();
                        }else if((Float.valueOf(set_right.getText().toString())>=-20.0 && Float.valueOf(set_right.getText().toString())<=10.0)==false) {
                            Toast.makeText(getApplicationContext(), "우안 시력이 범위를 벗어났습니다.", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                            db.UserDao().insert(new UserInfo(set_name.getText().toString(),set_left.getText().toString(),set_right.getText().toString(),fdate.format(date)));
                        }


                        String text = db.UserDao().getAll().toString();
                        show_data.setText(text);
                        //show_data.setText(db.todoDao().getAll().get(5).toString()); getAll().get(숫자) 하면 원하는 거 가져올 수 있음
                    }
                }
        );
    }




}