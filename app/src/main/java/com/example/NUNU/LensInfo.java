package com.example.NUNU;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class LensInfo {
    @PrimaryKey(autoGenerate = true) //id는 PrimaryKey로 지정해주며 자동으로 생성해줌
    public int id;
    public String Lens_name; //렌즈 이름
    public String Lens_type; // 렌즈 유형
    public int Lens_cnt; // 렌즈 개수
    public int Lens_period; // 렌즈 기간/원데이 구분
    public String Lens_color; //렌즈 색상
    public Date Lens_end; //착용기간(끝)


    public LensInfo(){

    }

    // (생성자) 필요한 요소를 가지고 생성자 생성하기

    public LensInfo(String lens_name, String lens_type, int lens_cnt, int lens_period, String lens_color, Date lens_end) {
        this.Lens_name = lens_name;
        this.Lens_type = lens_type;
        this.Lens_cnt = lens_cnt;
        this.Lens_period = lens_period;
        this.Lens_color = lens_color;
        this.Lens_end = lens_end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLens_name() {
        return Lens_name;
    }

    public void setLens_name(String lens_name) {
        Lens_name = lens_name;
    }

    public String getLens_type() {
        return Lens_type;
    }

    public void setLens_type(String lens_type) {
        Lens_type = lens_type;
    }

    public int getLens_cnt() {
        return Lens_cnt;
    }

    public void setLens_cnt(int lens_cnt) {
        Lens_cnt = lens_cnt;
    }

    public int getLens_period() {
        return Lens_period;
    }

    public void setLens_period(int lens_period) {
        Lens_period = lens_period;
    }

    public String getLens_color() {
        return Lens_color;
    }

    public void setLens_color(String lens_color) {
        Lens_color = lens_color;
    }

    public Date getLens_end() {
        return Lens_end;
    }

    public void setLens_end(Date lens_end) {
        Lens_end = lens_end;
    }

    @Override
    public String toString() {
        return "LensInfo{" +
                "id=" + id +
                "Lens_name="+Lens_name+
                "Lens_type="+Lens_type+
                "Lens_cnt="+Lens_cnt+
                "Lens_period="+Lens_period+
                "Lens_color="+Lens_color+
                "Lens_end="+Lens_end+
        '}';
    }
}
