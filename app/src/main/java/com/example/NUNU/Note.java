package com.example.NUNU;

public class Note {
    int _id;
    String lens_name;
    int lens_cnt;
    String start_date;
    String end_date;
    //타입 잘 봐!!
    public Note(int _id, String lens_name, int lens_cnt, String start_date, String end_date) {
        this._id = _id;
        this.lens_name = lens_name;
        this.lens_cnt = lens_cnt;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getLens_name() {
        return lens_name;
    }

    public void setLens_name(String lens_name) {
        this.lens_name = lens_name;
    }

    public int getLens_cnt() {
        return lens_cnt;
    }

    public void setLens_cnt(int lens_cnt) {
        this.lens_cnt = lens_cnt;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
