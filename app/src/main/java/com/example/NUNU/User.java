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



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_user, container, false);


        lineChart = (LineChart) view.findViewById(R.id.chart);

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


        LineDataSet set1 = new LineDataSet(entry1, "왼쪽 시력");
        LineDataSet set2 = new LineDataSet(entry2, "오른쪽 시력");

        set1.setLineWidth(2);
        set1.setCircleRadius(6);
        set1.setCircleColor(Color.parseColor("#FFA1B4DC"));
        //lineDataSet.setCircleColorHole(Color.BLUE);
        set1.setColor(Color.parseColor("#FFA1B4DC"));
        set1.setDrawCircleHole(true);
        set1.setDrawCircles(true);
        set1.setDrawHorizontalHighlightIndicator(false);
        set1.setDrawHighlightIndicators(false);
        set1.setDrawValues(false);

        set2.setLineWidth(2);
        set2.setCircleRadius(6);
        set2.setCircleColor(Color.parseColor("#646EFF"));
        //lineDataSet.setCircleColorHole(Color.BLUE);
        set2.setColor(Color.parseColor("#646EFF"));
        set2.setDrawCircleHole(true);
        set2.setDrawCircles(true);
        set2.setDrawHorizontalHighlightIndicator(false);
        set2.setDrawHighlightIndicators(false);
        set2.setDrawValues(false);

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
        // lineChart.animateY(2000, Easing.EasingOption.EaseInCubic);
        lineChart.invalidate();
       // return inflater.inflate(R.layout.fragment_user, container, false);
        return view;
    }


}