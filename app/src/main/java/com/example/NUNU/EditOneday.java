package com.example.NUNU;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import petrov.kristiyan.colorpicker.ColorPicker;

public class EditOneday extends AppCompatActivity  {
    public static final String EXTRA_REPLY = "com.example.NUNU.REPLY";
    public static final String EXTRA_ID = "eid";
    public static final String EXTRA_NAME = "ename";
    public static final String EXTRA_TYPE = "etype";
    public static final String EXTRA_CNT = "ecnt";
    public static final String EXTRA_PERIOD = "eperiod";
    public static final String EXTRA_CL = "ecl";
    public static final String EXTRA_START = "estart";
    public static final String EXTRA_END = "eend";

    Calendar myCalendar = Calendar.getInstance();
    private Button epallete;
    private int eposi;
    private EditText eone_name;
    private EditText eone_cnt;
    private String eclname;  // 렌즈 색
    private String o_dday;
    private Button ecancel; //X 버튼
    private EditText eone_type; // 렌즈유형
    private LensDao mLensDao;
    private String bcolor;
    private String bcolorhex;
    private int eperiod;
    private String eid;
    Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_oneday);

        EditText et_Date = (EditText) findViewById(R.id.eOneday_period);
        eone_name = (EditText)findViewById(R.id.eOneday_name);
        eone_cnt = (EditText)findViewById(R.id.eOneday_cnt);
        epallete = (Button) findViewById(R.id.eOneday_color);
        ecancel = (Button) findViewById(R.id.eto_main);
        eone_type = (EditText)findViewById(R.id.eOneday_type);
        Button o_save = findViewById(R.id.eOneday_save);



        //값 받아오기
        Intent intent = getIntent();

        bcolor = intent.getExtras().getString("cl");

        if (bcolor.equals("오렌지")) {
            epallete.setBackgroundColor(Color.parseColor("#c35817"));
        } else if (bcolor.equals("연갈색")) {
            epallete.setBackgroundColor(Color.parseColor("#966f33"));
        } else if (bcolor.equals("갈색")) {
            epallete.setBackgroundColor(Color.parseColor("#493d26"));
        } else if (bcolor.equals("회색")) {
            epallete.setBackgroundColor(Color.parseColor("#657383"));
        } else if (bcolor.equals("검정색")) {
            epallete.setBackgroundColor(Color.parseColor("#000000"));
        } else if (bcolor.equals("노란색")) {
            epallete.setBackgroundColor(Color.parseColor("#fff380"));
        } else if (bcolor.equals("녹색")) {
            epallete.setBackgroundColor(Color.parseColor("#387c44"));

        } else if (bcolor.equals("분홍색")) {
            epallete.setBackgroundColor(Color.parseColor("#e38aae"));

        } else if (bcolor.equals("보라색")) {
            epallete.setBackgroundColor(Color.parseColor("#9172ec"));

        } else {
            epallete.setBackgroundColor(Color.parseColor("#4863ad"));

        }
            //detail에서 받아온 값 보여주기
            eid = intent.getExtras().getString("id"); //id 값
            eone_name.setText(intent.getExtras().getString("name"));
            eone_type.setText(intent.getExtras().getString("type"));
            eone_cnt.setText(intent.getExtras().getString("cnt"));
            eperiod = intent.getExtras().getInt("period"); //1 이면 원데이 2이면 먼슬리
            //epallete.setBackgroundColor(Integer.parseInt(bcolorhex)); //색상에 맞는 값 버튼 색상 변경
            //eone_name.setText(intent.getExtras().getString("start"));
            et_Date.setText(intent.getExtras().getString("end"));

        eone_type.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                type();
            }
        });

        o_save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(eone_name.getText()) || TextUtils.isEmpty(eone_type.getText()) ||
                        TextUtils.isEmpty(eclname) || TextUtils.isEmpty(eone_cnt.getText()) ||
                        TextUtils.isEmpty(et_Date.getText())) {
                    Toast.makeText(context, "값을 모두 입력해주세요.", Toast.LENGTH_SHORT).show();
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    //String word = mEditWordView.getText().toString();
                    /*
                    replyIntent.putExtra(EXTRA_ID,eid);
                    replyIntent.putExtra(EXTRA_NAME, eone_name.getText().toString()); //name 이란 이름으로 one_name에 들어간 text 저장
                    replyIntent.putExtra(EXTRA_TYPE, eone_type.getText().toString());
                    replyIntent.putExtra(EXTRA_CNT,Integer.parseInt(eone_cnt.getText().toString()));
                    replyIntent.putExtra(EXTRA_PERIOD,eperiod); //1 이면 원데이 2이면 먼슬리
                    replyIntent.putExtra(EXTRA_NAME, eclname);
                    replyIntent.putExtra(EXTRA_START,"");
                    replyIntent.putExtra(EXTRA_CL,"분홍색");
                    replyIntent.putExtra(EXTRA_END,et_Date.getText().toString());

                     */

                    //replyIntent.putExtra(EXTRA_ID,eid);
                    replyIntent.putExtra(EXTRA_NAME, "please"); //name 이란 이름으로 one_name에 들어간 text 저장
                    replyIntent.putExtra(EXTRA_TYPE, "미용렌즈");
                    replyIntent.putExtra(EXTRA_CNT,55);
                    replyIntent.putExtra(EXTRA_PERIOD,1); //1 이면 원데이 2이면 먼슬리
                   // replyIntent.putExtra(EXTRA_NAME, eclname);
                    replyIntent.putExtra(EXTRA_START,"");
                    replyIntent.putExtra(EXTRA_CL,"분홍색");
                    int id = getIntent().getIntExtra("id",-1);
                    if (eid != "-1"){
                        replyIntent.putExtra(EXTRA_ID,eid);
                    }
                    setResult(RESULT_OK, replyIntent);
                    finish();
                }
            }
        });



        //유효기간
        et_Date.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(EditOneday.this,myDatePicker,myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        /*
        //추가버튼시 DB에 데이터 INSERT
        findViewById(R.id.Oneday_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    new insertAsyncTask(db.LensDao()).execute(new Note(one_name.getText().toString(),one_type.getText().toString(),
                    Integer.parseInt(one_cnt.getText().toString()),1,clname,"0",et_Date.getText().toString()));
                    one_name.setText("");
                    one_type.setText("");
                    one_cnt.setText("");
                    et_Date.setText("");
                    pallete.setText("");
            }
        });
         */

        //x 버튼
        ecancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        //컬러피커
        epallete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
    } // end of onCreate


    //날짜 입력
    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel_period();
        }
    };

    private void updateLabel_period() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
        EditText et_date = (EditText) findViewById(R.id.eOneday_period);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }

    //색상 선택
    public void openColorPicker() {
        final ColorPicker colorPicker = new ColorPicker(this);  // ColorPicker 객체 생성
        ArrayList<String> colors = new ArrayList<>();  // 렌즈 컬러 리스트
        colors.add("#c35817"); //orange
        colors.add("#966f33"); //wood
        colors.add("#493d26"); //mocha
        colors.add("#657383"); //gray
        colors.add("#000000"); //black
        colors.add("#fff380"); //yellow
        colors.add("#387c44"); //green
        colors.add("#4863ad"); //blue
        colors.add("#e38aae"); //pink
        colors.add("#9172ec"); //purple
        //colors.add("#e6ee9c");
        //colors.add("#fff59d");
        //colors.add("#ffe082");
        //colors.add("#ffcc80");
        //colors.add("#bcaaa4");
        colorPicker.setColors(colors)  // 만들어둔 list 적용
                .setColumns(5)  // 5열로 설정
                .setRoundColorButton(true)  // 원형 버튼으로 설정
                .setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                        //layout.setBackgroundColor(color);  // OK 버튼 클릭 시 이벤트
                        epallete.setBackgroundColor(color);
                        eposi = position;
                        //

                        if(eposi == 0){
                            eclname = "오렌지";
                        }else if(eposi == 1){
                            eclname = "연갈색";
                        }else if(eposi == 2){
                            eclname = "갈색";
                        }else if(eposi == 3) {
                            eclname = "회색";
                        }else if(eposi == 4){
                            eclname = "검정색";
                        }else if(eposi == 5){
                            eclname = "노란색";
                        }else if(eposi == 6){
                            eclname = "녹색";
                        }else if(eposi ==7){
                            eclname = "파랑색";
                        }else if(eposi ==8){
                            eclname = "분홍색";
                        }else if(eposi ==9) {
                            eclname = "보라색";
                        }else{
                            eclname ="파랑색";
                        }
                    }
                    @Override
                    public void onCancel() {
                        // Cancel 버튼 클릭 시 이벤트
                    }
                }).show();  // dialog 생성
        //색 잘 들어가는지 확인
        // Toast.makeText(getApplicationContext(), clname, Toast.LENGTH_SHORT).show();
    }


    final Context context = this;

    public void type(){
        {
            final CharSequence[] items ={"소프트렌즈","하드렌즈","미용렌즈"};
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("옵션 선택");

            alertDialogBuilder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Toast.makeText(getApplicationContext(), items[id], Toast.LENGTH_SHORT).show();
                    EditText type = (EditText) findViewById(R.id.eOneday_type);
                    type.setText(items[id]);
                    dialog.dismiss();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

    //메인스레드에서 데이터베이스에 접근할 수 없으므로 AsyncTask를 사용하도록 한다.
    public static class insertAsyncTask extends AsyncTask<Note, Void, Void> {
        private LensDao mLensDao;

        public insertAsyncTask(LensDao lensDao) {
            this.mLensDao = lensDao;
        }

        @Override //백그라운드작업(메인스레드 X)
        protected Void doInBackground(Note... lens) {
            //추가만하고 따로 SELECT문을 안해도 라이브데이터로 인해
            //getAll()이 반응해서 데이터를 갱신해서 보여줄 것이다,  메인액티비티에 옵저버에 쓴 코드가 실행된다. (라이브데이터는 스스로 백그라운드로 처리해준다.)
            mLensDao.insert(lens[0]);
            return null;
        }
    }
}