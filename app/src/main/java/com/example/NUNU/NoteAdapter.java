package com.example.NUNU;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
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
            lens_cnt.setText("보유개수 :"+item.getLens_cnt());
            start_date.setText(item.getLens_start());
            end_date.setText(item.getLens_end());
        }

    }
    private final LayoutInflater mInflater;
    private List<Note> mNotes;

    NoteAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    //apdapter에 들어갈 list
    //ArrayList<Note> items = new ArrayList<Note>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = mInflater.inflate(R.layout.note_item, parent, false);
        //만들어둔 note_item 넣기
        return new ViewHolder(itemView);
    }
    //item을 하나하나 보여주는 함수
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(mNotes != null){
            Note current = mNotes.get(position);
            holder.lens_name.setText(current.getLens_name());
            holder.lens_cnt.setText("보유개수 :"+current.getLens_cnt());
            holder.start_date.setText(current.getLens_start());
            holder.end_date.setText(current.getLens_end());
        }else{
            holder.lens_name.setText("No word");
            holder.lens_cnt.setText("No word");
            holder.start_date.setText("No word");
            holder.end_date.setText("No word");
        }
        //Note item = items.get(position);
        //viewHolder.setItem(item);  //이게 추가하는 거
    }

    public void setItems(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }
    //recylerview의 총 개수
    @Override
    public int getItemCount() {
        if(mNotes !=null)
            return mNotes.size();
        else return 0;
    }
    /*
    //외부에서 itme 추가
    public void addItem(Note item) {
        items.add(item);
    }

     */
}