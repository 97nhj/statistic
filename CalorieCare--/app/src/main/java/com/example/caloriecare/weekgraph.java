package com.example.caloriecare;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class weekgraph extends AppCompatActivity {

    private LineChart lineChart;
    private LineChart lineChart2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekgraph);

        lineChart = findViewById(R.id.chart);
        int val[]={1,2,0,4,5,12,11};
        int val2[]={3,4,5,7,6,10,13};
        //데이터 입력, db에서 데이터 입력받는 값으로 y값 수정해야함
        List<Entry> entries = new ArrayList<>();
        List<Entry> entries2 = new ArrayList<>();
        List<Entry> entries3 = new ArrayList<>();
        for(int i =0; i<7;i++){
            entries.add(new Entry(i+1,val[i]));
        }
        for(int i =0; i<7;i++){
            entries2.add(new Entry(i+1,val2[i]));
        }
        for(int i =0; i<7;i++){
            entries3.add(new Entry(i+1,val2[i]-val[i]));
        }

        //입력 데이터 삽입 및 그래프 다자인
        LineDataSet lineDataSet = new LineDataSet(entries, "평균 섭취량");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(4);
        lineDataSet.setCircleColor(Color.BLUE);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setValueTextSize(13);

        LineDataSet lineDataSet2 = new LineDataSet(entries2, "평균 운동량");
        lineDataSet2.setLineWidth(2);
        lineDataSet2.setCircleRadius(4);
        lineDataSet2.setCircleColor(Color.RED);
        lineDataSet2.setColor(Color.RED);
        lineDataSet2.setDrawCircles(true);
        lineDataSet2.setValueTextSize(13);

        LineDataSet lineDataSet3 = new LineDataSet(entries3, "순 소비 칼로리량");
        lineDataSet3.setLineWidth(2);
        lineDataSet3.setCircleRadius(4);
        lineDataSet3.setCircleColor(Color.BLACK);
        lineDataSet3.setColor(Color.BLACK);
        lineDataSet3.setDrawCircles(true);
        lineDataSet3.setValueTextSize(13);

        LineData lineData = new LineData();
        lineData.addDataSet(lineDataSet);
        lineData.addDataSet(lineDataSet2);
        lineData.addDataSet(lineDataSet3);
        lineChart.setData(lineData);


        //x축 디자인
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(7,true);

        //y축 왼쪽 디자인 및 설정
        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setDrawAxisLine(true);
        yLAxis.setDrawGridLines(false);
        yLAxis.setDrawLabels(false);

        //y축 오른쪽 디자인 및 설정
        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        //description 부분 디자인 및 설정
        Description description = new Description();
        description.setText("x : 일, y : 평균 칼로리");
        description.setTextSize(8);

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.invalidate();
    }
}