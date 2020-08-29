package com.example.NUNU;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    //apdapter에 들어갈 list
    ArrayList<Note> items = new ArrayList<Note>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.note_item, viewGroup, false);
        //만들어둔 note_item 넣기
        return new ViewHolder(itemView);
    }
    //item을 하나하나 보여주는 함수
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Note item = items.get(position);
      viewHolder.setItem(item);  //이게 추가하는 거
    }
    //recylerview의 총 개수
    @Override
    public int getItemCount() {
        return items.size();
    }
    //외부에서 itme 추가
    public void addItem(Note item) {
        items.add(item);
    }

    public void setItems(ArrayList<Note> items) {
        this.items = items;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        TextView lens_name;
        TextView lens_cnt;
        TextView start_date;
        TextView end_date;


        public ViewHolder(View itemView ){
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);
            lens_name = itemView.findViewById(R.id.lens_name);
            lens_cnt = itemView.findViewById(R.id.lens_cnt);
            start_date = itemView.findViewById(R.id.start_date);
            end_date = itemView.findViewById(R.id.end_date);
        }
        //화면에 보여지게 넣는 함수
        public void setItem(Note item) {
            lens_name.setText(item.getLens_name());
            lens_cnt.setText(String.valueOf("보유개수 :"+item.getLens_cnt()));
            start_date.setText(item.getStart_date());
            end_date.setText(item.getEnd_date());
        }

    }

    }


