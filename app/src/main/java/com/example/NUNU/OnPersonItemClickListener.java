package com.example.NUNU;

import android.view.View;

interface OnPersonItemClickListener {
    public void onItemClick(NoteAdapter.ViewHolder holder, View view, int position);
}