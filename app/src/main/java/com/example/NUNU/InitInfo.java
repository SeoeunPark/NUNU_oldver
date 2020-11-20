package com.example.NUNU;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.Room;

import android.content.Intent;
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
        Button add_button = findViewById(R.id.add_button);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "userinfo-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        set_name = findViewById(R.id.set_name);
        set_left = findViewById(R.id.set_left);
        set_right = findViewById(R.id.set_right);
        show_data = findViewById(R.id.show_data);

        show_data.setText(db.UserDao().getAll().toString());

        add_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                SimpleDateFormat fdate = new SimpleDateFormat("MM-dd");
                Date date = new Date();
                db.UserDao().insert(new UserInfo(set_name.getText().toString(), set_left.getText().toString(), set_right.getText().toString(), fdate.format(date)));
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }

        });

    }
}