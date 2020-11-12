package com.example.NUNU;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.Calendar;

public class Detail extends AppCompatActivity {
    private static final String TAG= "Detail";
    public static final int EDIT_NOTE_REQUEST =2;
    private Button cancel;
    private ImageView more;
    private ImageView dimage;
    private TextView dday;
    private TextView dname;
    private TextView dtype;
    private TextView dcnt;
    private TextView dtype_om;
    private TextView dperiod_s;
    private TextView dperiod_e;
    private TextView dinfo;

    private String idday;
    private String idname;
    private String idtype;
    private String idcnt;
    private String idtype_om;
    private String idperiod_s;
    private String idperiod_e;
    private String idinfo;
    private String idid;
    private String  idcl;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.activity_detail);
        cancel = (Button) findViewById(R.id.go_out);
        more = (ImageView) findViewById(R.id.more);
        dday = (TextView) findViewById(R.id.d_day_text3); //d-day 남은 기간 text
        dname = (TextView) findViewById(R.id.detail_name); //렌즈 이름
        dtype = (TextView) findViewById(R.id.detail_type); //소프트/하드/미용
        dcnt = (TextView) findViewById(R.id.detail_type2);
        dtype_om = (TextView) findViewById(R.id.type_om);
        dperiod_s = (TextView) findViewById(R.id.detail_period_start);
        dperiod_e = (TextView) findViewById(R.id.detail_period_end);
        dinfo = (TextView) findViewById(R.id.detail_info);
        dimage = (ImageView) findViewById(R.id.nunu_ch); //누누 캐릭터

        //intent로 값 받아오기
        idid = intent.getExtras().getString("id");
        idname = intent.getExtras().getString("name");
        idtype = intent.getExtras().getString("type");
        idcnt = Integer.toString(intent.getExtras().getInt("cnt"));
        idtype_om = Integer.toString(intent.getExtras().getInt("period")); //1 이면 원데이 2이면 먼슬리
        idcl = intent.getExtras().getString("cl"); //값 잘 들어감
        idperiod_s = intent.getExtras().getString("start");
        idperiod_e = intent.getExtras().getString("end");

        //디데이 구하기
        String str = idperiod_e;
        String[] array = str.split("/");
        int cyear = Integer.parseInt(array[0]);
        int cmonth = Integer.parseInt(array[1]);
        int cday = Integer.parseInt(array[2]);

        LocalDate fromDate = LocalDate.now();
        LocalDate toDate = LocalDate.of(cyear, cmonth, cday);
        long substract = ChronoUnit.DAYS.between(fromDate, toDate);

        //원데이인지 / 먼슬리인지
        if (idtype_om.equals("1")) {
            idtype_om = "원데이 렌즈";
            dinfo.setText("원데이 렌즈는 반드시 한번만 사용해주세요.\n일반형 1회용 렌즈는 보통 8시간의 착용시간을 권장합니다.\n실리콘 하이드로겔 소재의 렌즈는 12시간에서 14시까지도\n 착용이 가능합니다.");
        } else {
            idtype_om = "기간 렌즈";
            dinfo.setText("기간 렌즈는 한번 개봉하고 사용기한이 지나면\n 반드시 폐기를 해주어야 합니다.\n 개봉하지 않은 렌즈도 5년이 지나면 버려야 합니다. ");
        }

        if (idcl.equals("오렌지")) {
            dimage.setImageResource(R.drawable.orange);
        } else if (idcl.equals("연갈색")) {
            dimage.setImageResource(R.drawable.mocha);
        } else if (idcl.equals("갈색")) {
            dimage.setImageResource(R.drawable.wood);
        } else if (idcl.equals("회색")) {
            dimage.setImageResource(R.drawable.gray);
        } else if (idcl.equals("검정색")) {
            dimage.setImageResource(R.drawable.black);
        } else if (idcl.equals("노란색")) {
            dimage.setImageResource(R.drawable.yellow);
        } else if (idcl.equals("녹색")) {
            dimage.setImageResource(R.drawable.green);
        } else if (idcl.equals("분홍색")) {
            dimage.setImageResource(R.drawable.pink);
        } else if (idcl.equals("보라색")) {
            dimage.setImageResource(R.drawable.purple);
        } else {
            dimage.setImageResource(R.drawable.blue);
        }

        dday.setText(Integer.toString((int) substract));
        dname.setText(idname);
        dtype.setText(idtype);
        dcnt.setText(idcnt);
        dtype_om.setText(idtype_om);
        dperiod_s.setText("착용 주기: "+idperiod_s);
        dperiod_e.setText(idperiod_e);

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    } //onCreate
       public void onPopupButtonClick(View button){
            PopupMenu popup = new PopupMenu(this,button);
            popup.getMenuInflater().inflate(R.menu.detail_popup,popup.getMenu());

            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.edit:
                            if(idtype_om.equals("1")==true) {
                                Intent intent = new Intent(Detail.this, EditLensActivity.class);
                                intent.putExtra("id", idid);
                                intent.putExtra("name", idname); //name 이란 이름으로 one_name에 들어간 text 저장
                                intent.putExtra("type", idtype);
                                intent.putExtra("cnt", idcnt);
                                intent.putExtra("period", idtype_om);
                                intent.putExtra("cl", idcl);
                                intent.putExtra("start", idperiod_s);
                                intent.putExtra("end", idperiod_e);
                                startActivityForResult(intent, EDIT_NOTE_REQUEST);
                            }else if(idtype_om.equals("2")==true){

                            }
                            break;
                        case R.id.delete:
                            Toast.makeText(Detail.this, "delete", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return true;
                }
            });
            popup.show();
       }
    }