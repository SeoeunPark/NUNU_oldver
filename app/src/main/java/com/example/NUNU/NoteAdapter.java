package com.example.NUNU;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {//implements OnPersonItemClickListener{
    OnPersonItemClickListener listener;
    private final LayoutInflater mInflater;
    private List<Note> mNotes;


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
    @Override
    public int getItemCount() {
        if(mNotes !=null)
            return mNotes.size();
        else return 0;
    }
    public void setItems(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }
    public Note getNoteAt(int position){
        return mNotes.get(position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        private TextView lens_name;
        private TextView lens_cnt;
        private TextView start_date;
        private TextView end_date;

        public ViewHolder(View itemView ){
            super(itemView);
            layout1 = itemView.findViewById(R.id.layout1);
            lens_name = itemView.findViewById(R.id.lens_name);
            lens_cnt = itemView.findViewById(R.id.lens_cnt);
            start_date = itemView.findViewById(R.id.start_date);
            end_date = itemView.findViewById(R.id.end_date);
            /*
            //클릭이벤트
            itemView.setOnClickListener(new View.OnClickListener() {                @Override
                public void onClick(View view) {
                int pos = getAdapterPosition();
                if(pos!= RecyclerView.NO_POSITION){
                    int position = getAdapterPosition();
                    listener.onItemClick(notes.get(position));
                }
                }
            });

             */

        }

        //화면에 보여지게 넣는 함수
        public void setItem(Note item) {
            lens_name.setText(item.getLens_name());
            lens_cnt.setText("보유개수 :"+item.getLens_cnt());
            start_date.setText(item.getLens_start());
            end_date.setText(item.getLens_end());
        }
    }

    public void setOnItemClicklistener(OnPersonItemClickListener listener){
        this.listener = listener;
    }

    public void onItemClick(ViewHolder holder, View view, int position) {
        if(listener != null){ listener.onItemClick(holder,view,position); }
    }


    NoteAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    //apdapter에 들어갈 list
    //ArrayList<Note> items = new ArrayList<Note>();

    //recylerview의 총 개수

    /*
    public Note getItem(int position){
        return .get(position); }

    /*
    //외부에서 itme 추가
    public void addItem(Note item) {
        items.add(item);
    }

     */
}