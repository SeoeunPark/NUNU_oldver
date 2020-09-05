package com.example.NUNU;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.graphics.Color;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class User extends Fragment {
    View view;
    private LineChart lineChart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
        public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle
        savedInstanceState){
            view = inflater.inflate(R.layout.fragment_user, container, false);
            lineChart = (LineChart) view.findViewById(R.id.sightchart);

            List<Entry> entry1 = new ArrayList<>();
            entry1.add(new Entry(1, 1));
            entry1.add(new Entry(2, 2));
            entry1.add(new Entry(3, 0));
            entry1.add(new Entry(4, 4));
            entry1.add(new Entry(5, 3));

            List<Entry> entry2 = new ArrayList<>();
            entry2.add(new Entry(1, 5));
            entry2.add(new Entry(2, 3));
            entry2.add(new Entry(3, 1));
            entry2.add(new Entry(4, -1));
            entry2.add(new Entry(5, -3));
            entry2.add(new Entry(6, -5));
            entry2.add(new Entry(7, -8));
            entry2.add(new Entry(8, -8));
            entry2.add(new Entry(9, -10));
            
            LineDataSet set1 = new LineDataSet(entry1, "왼쪽 시력");
            LineDataSet set2 = new LineDataSet(entry2, "오른쪽 시력");

            set1.setAxisDependency(YAxis.AxisDependency.LEFT);
            set1.setColor(ColorTemplate.getHoloBlue());
            set1.setValueTextColor(ColorTemplate.getHoloBlue());
            set1.setLineWidth(1.5f);
            set1.setDrawCircles(true);
            set1.setDrawValues(false);
            set1.setFillAlpha(65);
            set1.setFillColor(ColorTemplate.getHoloBlue());
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);

            set2.setAxisDependency(YAxis.AxisDependency.LEFT);
            set2.setColor(Color.parseColor("#646EFF"));
            set2.setValueTextColor(Color.parseColor("#646EFF"));
            set2.setLineWidth(1.5f);
            set2.setDrawCircles(true);
            set2.setDrawValues(false);
            set2.setFillAlpha(65);
            set1.setHighLightColor(Color.rgb(220, 180, 117));
            set2.setDrawCircleHole(true);

            LineData chartData = new LineData();
            chartData.addDataSet(set1);

            chartData.addDataSet(set2);
            lineChart.setData(chartData);

            XAxis xAxis = lineChart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setTextColor(Color.BLACK);
            xAxis.enableGridDashedLine(8, 24, 0);

            YAxis yLAxis = lineChart.getAxisLeft();
            yLAxis.setTextColor(Color.BLACK);

            YAxis yRAxis = lineChart.getAxisRight();
            yRAxis.setDrawLabels(false);
            yRAxis.setDrawAxisLine(false);
            yRAxis.setDrawGridLines(false);

            Description description = new Description();
            description.setText("");

            lineChart.setDoubleTapToZoomEnabled(false);
            lineChart.setDrawGridBackground(false);
            lineChart.setDescription(description);
            //lineChart.animateY(2000, Easing.EasingOption.EaseInCubic);
            lineChart.invalidate();
            return view;
        }
    }
