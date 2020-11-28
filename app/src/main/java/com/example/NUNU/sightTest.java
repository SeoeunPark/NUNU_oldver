package com.example.NUNU;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class sightTest extends Fragment {

    private MyDialog Dialog_Listener;

    public sightTest() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sight_test, container, false);
        Context context = getContext();
        View.OnClickListener Confirm = new View.OnClickListener() {
            public void onClick(View v) {
                Dialog_Listener.dismiss();
            }
        };

        ImageView near = (ImageView) view.findViewById(R.id.nearsighted);
        near.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("근시일까? 난시일까?");
//                builder.setMessage("당신은 근시입니다!");
//                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                builder.create().show();

                Dialog_Listener = new MyDialog(getContext(),Confirm,"근시일까? 난시일까?","당신은 근시입니다!");
                Dialog_Listener.show();

            }
        });
        ImageView as = (ImageView) view.findViewById(R.id.astigmatism);
        as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("근시일까? 난시일까?");
//                builder.setMessage("당신은 난시입니다!");
//                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                builder.create().show();

                Dialog_Listener = new MyDialog(getContext(),Confirm,"근시일까? 난시일까?","당신은 난시입니다!");
                Dialog_Listener.show();
            }
        });
        ImageView all = (ImageView) view.findViewById(R.id.all);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("근시일까? 난시일까?");
//                builder.setMessage("당신은 근시와 난시 둘 다 있습니다!");
//                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                builder.create().show();

                Dialog_Listener = new MyDialog(getContext(),Confirm,"근시일까? 난시일까?","당신은 근시와 난시 둘 다 있습니다!");
                Dialog_Listener.show();
            }
        });
        ImageView niceEye = (ImageView) view.findViewById(R.id.niceEye);
        niceEye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle("근시일까? 난시일까?");
//                builder.setMessage("당신은 건강한 눈을 가지고 있습니다!");
//                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                builder.create().show();

                Dialog_Listener = new MyDialog(getContext(),Confirm,"근시일까? 난시일까?","당신은 건강한 눈을 가지고\n있습니다!");
                Dialog_Listener.show();
            }
        });



        return view;
    }
}