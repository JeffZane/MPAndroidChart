
package com.xxmassdeveloper.mpchartexample.notimportant;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.github.mikephil.charting.utils.Utils;
import com.xxmassdeveloper.mpchartexample.AnotherBarActivity;
import com.xxmassdeveloper.mpchartexample.BarChartActivity;
import com.xxmassdeveloper.mpchartexample.BarChartActivityMultiDataset;
import com.xxmassdeveloper.mpchartexample.BarChartActivitySinus;
import com.xxmassdeveloper.mpchartexample.BarChartPositiveNegative;
import com.xxmassdeveloper.mpchartexample.BubbleChartActivity;
import com.xxmassdeveloper.mpchartexample.CandleStickChartActivity;
import com.xxmassdeveloper.mpchartexample.CombinedChartActivity;
import com.xxmassdeveloper.mpchartexample.CombinedChartActivity2;
import com.xxmassdeveloper.mpchartexample.CubicLineChartActivity;
import com.xxmassdeveloper.mpchartexample.DynamicalAddingActivity;
import com.xxmassdeveloper.mpchartexample.FilledLineActivity;
import com.xxmassdeveloper.mpchartexample.FilledLineActivity2;
import com.xxmassdeveloper.mpchartexample.HalfPieChartActivity;
import com.xxmassdeveloper.mpchartexample.HorizontalBarChartActivity;
import com.xxmassdeveloper.mpchartexample.InvertedLineChartActivity;
import com.xxmassdeveloper.mpchartexample.LineChartActivity1;
import com.xxmassdeveloper.mpchartexample.LineChartActivity2;
import com.xxmassdeveloper.mpchartexample.LineChartActivityColored;
import com.xxmassdeveloper.mpchartexample.LineChartTime;
import com.xxmassdeveloper.mpchartexample.ListViewBarChartActivity;
import com.xxmassdeveloper.mpchartexample.ListViewMultiChartActivity;
import com.xxmassdeveloper.mpchartexample.MultiLineChartActivity;
import com.xxmassdeveloper.mpchartexample.PerformanceLineChart;
import com.xxmassdeveloper.mpchartexample.PieChartActivity;
import com.xxmassdeveloper.mpchartexample.PiePolylineChartActivity;
import com.xxmassdeveloper.mpchartexample.R;
import com.xxmassdeveloper.mpchartexample.RadarChartActivity;
import com.xxmassdeveloper.mpchartexample.RealtimeLineChartActivity;
import com.xxmassdeveloper.mpchartexample.ScatterChartActivity;
import com.xxmassdeveloper.mpchartexample.ScrollViewActivity;
import com.xxmassdeveloper.mpchartexample.StackedBarActivity;
import com.xxmassdeveloper.mpchartexample.StackedBarActivityNegative;
import com.xxmassdeveloper.mpchartexample.fragments.SimpleChartDemo;
import com.xxmassdeveloper.mpchartexample.realm.RealmMainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnItemClickListener {
    private List<Intent> mIntents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setTitle("MPAndroidChart Example");

        // initialize the utilities
        Utils.init(this);

        List<ContentItem> objects = new ArrayList<>();

        mIntents.add(new Intent(this, LineChartActivity1.class));
        objects.add(new ContentItem("Line Chart", "A simple demonstration of the linechart."));

        mIntents.add(new Intent(this, LineChartActivity2.class));
        objects.add(new ContentItem("Line Chart (Dual YAxis)",
                "Demonstration of the linechart with dual y-axis."));

        mIntents.add(new Intent(this, BarChartActivity.class));
        objects.add(new ContentItem("Bar Chart", "A simple demonstration of the bar chart."));

        mIntents.add(new Intent(this, HorizontalBarChartActivity.class));
        objects.add(new ContentItem("Horizontal Bar Chart",
                "A simple demonstration of the horizontal bar chart."));

        mIntents.add(new Intent(this, CombinedChartActivity.class));
        objects.add(new ContentItem("Combined Chart",
                "Demonstrates how to create a combined chart (bar and line in this case)."));

        mIntents.add(new Intent(this, CombinedChartActivity2.class));
        objects.add(new ContentItem("Combined Chart2",
                "Demonstrates how to create a combined chart (bar and line in this case)."));

        mIntents.add(new Intent(this, PieChartActivity.class));
        objects.add(new ContentItem("Pie Chart", "A simple demonstration of the pie chart."));

        mIntents.add(new Intent(this, PiePolylineChartActivity.class));
        objects.add(new ContentItem("Pie Chart with value lines", "A simple demonstration of the pie chart with polyline notes."));

        mIntents.add(new Intent(this, ScatterChartActivity.class));
        objects.add(new ContentItem("Scatter Chart", "A simple demonstration of the scatter chart."));

        mIntents.add(new Intent(this, BubbleChartActivity.class));
        objects.add(new ContentItem("Bubble Chart", "A simple demonstration of the bubble chart."));

        mIntents.add(new Intent(this, StackedBarActivity.class));
        objects.add(new ContentItem("Stacked Bar Chart",
                "A simple demonstration of a bar chart with stacked bars."));

        mIntents.add(new Intent(this, StackedBarActivityNegative.class));
        objects.add(new ContentItem("Stacked Bar Chart Negative",
                "A simple demonstration of stacked bars with negative and positive values."));

        mIntents.add(new Intent(this, AnotherBarActivity.class));
        objects.add(new ContentItem("Another Bar Chart",
                "Implementation of a BarChart that only shows values at the bottom."));

        mIntents.add(new Intent(this, MultiLineChartActivity.class));
        objects.add(new ContentItem("Multiple Lines Chart",
                "A line chart with multiple DataSet objects. One color per DataSet."));

        mIntents.add(new Intent(this, BarChartActivityMultiDataset.class));
        objects.add(new ContentItem("Multiple Bars Chart",
                "A bar chart with multiple DataSet objects. One multiple colors per DataSet."));

        mIntents.add(new Intent(this, SimpleChartDemo.class));
        objects.add(new ContentItem(
                "Charts in ViewPager Fragments",
                "Demonstration of charts inside ViewPager Fragments. In this example the focus was on the design and look and feel of the" +
                        " chart."));

        mIntents.add(new Intent(this, ListViewBarChartActivity.class));
        objects.add(new ContentItem(
                "BarChart inside ListView",
                "Demonstrates the usage of a BarChart inside a ListView item."));

        mIntents.add(new Intent(this, ListViewMultiChartActivity.class));
        objects.add(new ContentItem(
                "Multiple charts inside ListView",
                "Demonstrates the usage of different chart types inside a ListView."));

        mIntents.add(new Intent(this, InvertedLineChartActivity.class));
        objects.add(new ContentItem(
                "Inverted Line Chart",
                "Demonstrates the feature of inverting the y-axis."));

        mIntents.add(new Intent(this, CandleStickChartActivity.class));
        objects.add(new ContentItem(
                "Candle Stick Chart",
                "Demonstrates usage of the CandleStickChart."));

        mIntents.add(new Intent(this, CubicLineChartActivity.class));
        objects.add(new ContentItem(
                "Cubic Line Chart",
                "Demonstrates cubic lines in a LineChart."));

        mIntents.add(new Intent(this, RadarChartActivity.class));
        objects.add(new ContentItem(
                "Radar Chart",
                "Demonstrates the use of a spider-web like (net) chart."));

        mIntents.add(new Intent(this, LineChartActivityColored.class));
        objects.add(new ContentItem(
                "Colored Line Chart",
                "Shows a LineChart with different background and line color."));

        mIntents.add(new Intent(this, RealtimeLineChartActivity.class));
        objects.add(new ContentItem(
                "Realtime Chart",
                "This chart is fed with new data in realtime. It also restrains the view on the x-axis."));

        mIntents.add(new Intent(this, DynamicalAddingActivity.class));
        objects.add(new ContentItem(
                "Dynamical data adding",
                "This Activity demonstrates dynamical adding of Entries and DataSets (real time graph)."));

        mIntents.add(new Intent(this, PerformanceLineChart.class));
        objects.add(new ContentItem(
                "Performance Line Chart",
                "Renders up to 30.000 objects smoothly."));

        mIntents.add(new Intent(this, BarChartActivitySinus.class));
        objects.add(new ContentItem(
                "Sinus Bar Chart",
                "A Bar Chart plotting the sinus function with 8.000 values."));

        mIntents.add(new Intent(this, ScrollViewActivity.class));
        objects.add(new ContentItem(
                "Chart in ScrollView",
                "This demonstrates how to use a chart inside a ScrollView."));

        mIntents.add(new Intent(this, BarChartPositiveNegative.class));
        objects.add(new ContentItem(
                "BarChart positive / negative",
                "This demonstrates how to create a BarChart with positive and negative values in different colors."));

        mIntents.add(new Intent(this, RealmMainActivity.class));
        ContentItem realm = new ContentItem(
                "Realm.io Database",
                "This demonstrates how to use this library with Realm.io mobile database.");
        objects.add(realm);

        mIntents.add(new Intent(this, LineChartTime.class));
        objects.add(new ContentItem(
                "Time Chart",
                "Simple demonstration of a time-chart. This chart draws one line entry per hour originating from the current time in " +
                        "milliseconds."));

        mIntents.add(new Intent(this, FilledLineActivity.class));
        objects.add(new ContentItem(
                "Filled LineChart",
                "This demonstrates how to fill an area between two LineDataSets."));

        mIntents.add(new Intent(this, FilledLineActivity2.class));
        objects.add(new ContentItem(
                "Filled LineChart2",
                "This demonstrates how to fill an area between two LineDataSets."));

        mIntents.add(new Intent(this, HalfPieChartActivity.class));
        objects.add(new ContentItem(
                "Half PieChart",
                "This demonstrates how to create a 180 degree PieChart."));

        MyAdapter adapter = new MyAdapter(this, objects);

        ListView lv = findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int pos, long arg3) {
        startActivity(mIntents.get(pos));
        overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent i = null;

        switch (item.getItemId()) {
            case R.id.viewGithub:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://github.com/PhilJay/MPAndroidChart"));
                startActivity(i);
                break;
            case R.id.report:
                i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "philjay.librarysup@gmail.com", null));
                i.putExtra(Intent.EXTRA_SUBJECT, "MPAndroidChart Issue");
                i.putExtra(Intent.EXTRA_TEXT, "Your error report here...");
                startActivity(Intent.createChooser(i, "Report Problem"));
                break;
            case R.id.blog:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.xxmassdeveloper.com"));
                startActivity(i);
                break;
            case R.id.website:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://at.linkedin.com/in/philippjahoda"));
                startActivity(i);
                break;
        }

        return true;
    }
}
