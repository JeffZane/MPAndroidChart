
package com.xxmassdeveloper.mpchartexample;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;
import java.util.List;

public class FilledLineActivity2 extends DemoBase {

    private LineChart mChart;
    private int mFillColor = Color.parseColor("#33419BF9");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_linechart_noseekbar);

        mChart = findViewById(R.id.chart1);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setGridBackgroundColor(mFillColor);
        mChart.setDrawGridBackground(true);

        mChart.setDrawBorders(true);

        // no description text
        mChart.getDescription().setEnabled(false);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        Legend l = mChart.getLegend();
        l.setEnabled(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setAxisMaximum(900f);
        leftAxis.setAxisMinimum(-250f);
        leftAxis.setDrawAxisLine(false);
        leftAxis.setDrawZeroLine(false);
        leftAxis.setDrawGridLines(false);

        mChart.getAxisRight().setEnabled(false);
        setData(7, 60);
        mChart.invalidate();
    }

    private void setData(int count, float range) {
        List<Entry> yVals1 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yVals1.add(new Entry(i, (float) (Math.random() * range) + 50));
        }

        List<Entry> yVals2 = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            yVals2.add(new Entry(i, (float) (Math.random() * range) + 450));
        }

//        LineDataSet lineDataSet1 = generateLineDataSet(yVals1, "DataSet 1");
        LineDataSet lineDataSet1 = new LineDataSet(yVals1, "DataSet 1");
        lineDataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet1.setColor(Color.BLUE);
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setDrawCircleHole(false);
        lineDataSet1.setLineWidth(2f);
        lineDataSet1.setCircleRadius(3f);
        lineDataSet1.setFillAlpha(255);
        lineDataSet1.setDrawFilled(true);
        lineDataSet1.setFillColor(Color.WHITE);
        lineDataSet1.setFillFormatter(new IFillFormatter() {
            @Override
            public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                return mChart.getAxisLeft().getAxisMinimum();
            }
        });

        LineDataSet lineDataSet2 = generateLineDataSet(yVals2, "DataSet 2");

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);
        dataSets.add(lineDataSet2);

        LineData data = new LineData(dataSets);
        data.setDrawValues(false);
        mChart.setData(data);
    }

    private LineDataSet generateLineDataSet(List<Entry> yVals, String label) {
        LineDataSet lineDataSet = new LineDataSet(yVals, label);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setColor(Color.BLUE);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setLineWidth(2f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setFillAlpha(255);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setFillColor(Color.WHITE);
        lineDataSet.setFillFormatter(new IFillFormatter() {
            @Override
            public float getFillLinePosition(ILineDataSet dataSet, LineDataProvider dataProvider) {
                return mChart.getAxisLeft().getAxisMaximum();
            }
        });
        return lineDataSet;
    }
}
