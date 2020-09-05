package com.example.NUNU;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Home fragment1; // 홈 fragment
    Lens fragment2; // 렌즈 fragment
    User fragment3; // 유저 fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //프래그먼트 생성
        fragment1 = new Home();
        fragment2 = new Lens();
        fragment3 = new User();

        //제일 처음 보여지는 창
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commitAllowingStateLoss();

        //bottomnavigationview의 아이콘을 선택 했을때 원하는 프래그먼트가 띄워질 수 있도록 리스너를 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //my_navigation_items.xml에서 지정해줬던 아이디 값을 받아와서 각 아이디값마다 다른 이벤트를 발생
                    case R.id.home: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment1).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.eye: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment2).commitAllowingStateLoss();
                        return true;
                    }
                    case R.id.user: {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragment3).commitAllowingStateLoss();
                        return true;
                    }
                    default:
                        return false;
                }
            }
        });
    }

}