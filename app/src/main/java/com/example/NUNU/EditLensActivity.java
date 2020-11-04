package com.example.NUNU;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

import petrov.kristiyan.colorpicker.ColorPicker;

public class EditLensActivity extends AppCompatActivity {
    Calendar myCalendar = Calendar.getInstance();
    private Button pallete;
    private Button cancel;
    private int posi;
    private String clname; // 렌즈 색
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editlens);
        pallete = (Button) findViewById(R.id.lens_color);
        cancel = (Button) findViewById(R.id.to_main);

        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        //컬러피커
        pallete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorPicker();
            }
        });
    }

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
                        pallete.setBackgroundColor(color);
                        posi = position;
                        //

                        if(posi == 0){
                            clname = "오렌지";
                        }else if(posi == 1){
                            clname = "연갈색";
                        }else if(posi == 2){
                            clname = "갈색";
                        }else if(posi == 3) {
                            clname = "회색";
                        }else if(posi == 4){
                            clname = "검정색";
                        }else if(posi == 5){
                            clname = "노란색";
                        }else if(posi == 6){
                            clname = "녹색";
                        }else if(posi ==7){
                            clname = "파랑색";
                        }else if(posi ==8){
                            clname = "분홍색";
                        }else if(posi ==9) {
                            clname = "보라색";
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
}