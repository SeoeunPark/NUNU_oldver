package com.example.NUNU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    private static final String TAG= "Detail";
    private Button cancel;
    private ImageView more;
    private ImageView nunu_ch;
    private TextView dday;
    private TextView dname;
    private TextView dtype;
    private TextView dcnt;
    private TextView dtype_om;
    private TextView dperiod_s;
    private TextView dperiod_e;
    private TextView dinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_detail);
        cancel = (Button) findViewById(R.id.go_out);
        more = (ImageView) findViewById(R.id.more);
        nunu_ch = (ImageView)findViewById(R.id.imageView4); //누누 캐릭터
        dday = (TextView)findViewById(R.id.d_day_text3); //d-day 남은 기간 text
        dname = (TextView)findViewById(R.id.detail_name); //렌즈 이름
        dtype = (TextView)findViewById(R.id.detail_type); //소프트/하드/미용
        dcnt = (TextView)findViewById(R.id.detail_type2);
        dtype_om = (TextView)findViewById(R.id.type_om);
        dperiod_s = (TextView)findViewById(R.id.detail_period_start);
        dperiod_e = (TextView)findViewById(R.id.detail_period_end);
        dinfo = (TextView)findViewById(R.id.detail_info);

        dday.setText("3");
        dname.setText(intent.getExtras().getString("name"));
        dtype.setText(intent.getExtras().getString("type"));
        dcnt.setText(Integer.toString(intent.getExtras().getInt("cnt")));
        dtype_om.setText(Integer.toString(intent.getExtras().getInt("period")));
                //intent.getExtras().getString("cl");
        dperiod_s.setText(intent.getExtras().getString("start"));
        dperiod_e.setText(intent.getExtras().getString("end"));



        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });


        //Note word = new Note(intent.getExtras().getString("name"),intent.getExtras().getString("type"),intent.getExtras().getInt("cnt"),intent.getExtras().getInt("period"),intent.getExtras().getString("cl"),intent.getExtras().getString("start"),intent.getExtras().getString("end"));

    }
}