package com.example.CONVID19News.ui.notifications;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.table.TableData;
import com.example.CONVID19News.R;
import com.example.CONVID19News.ui.home.Fruit;
import com.example.CONVID19News.ui.home.FruitAdapter;
import com.example.CONVID19News.ui.home.HomeFragment;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
//import com.example.newtest0903.news.NewsActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DataChartFragment extends Fragment {

    private LineChart mLineChart;
    private LineChartManager mChartManager;
    private SmartTable smartTable;



    public DataChartFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_datachart, container, false);

        //set chart--------------------------------------------
        mLineChart = view.findViewById(R.id.line_chart);
        mChartManager = new LineChartManager(mLineChart,"sensors", Color.BLACK);
        mChartManager.setDescription("");

        for(int i=0;i<15;i++){
            addEntry(view);
        }
        //set chart**********************************************
        Column<String> city = new Column<>("部门/渠道", "city");
        Column<Integer> name = new Column<>("板块", "name");
        Column<Integer> count = new Column<>("目标值", "count");
        Column<Integer> restaurant = new Column<>("餐饮", "restaurant");
        Column<Integer> ka = new Column<>("KA", "ka");
        Column<Integer> wholesale = new Column<>("流通批发", "wholesale");
        Column<Integer> industry = new Column<>("工业加工", "industry");
        Column<Integer> other = new Column<>("其他", "other");
        //设置该列当字段相同时自动合并
        city.setAutoMerge(true);
        List<User> list = new ArrayList<>();
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));


        TableData<User> tableData = new TableData<>("表格名", list, city, name, count, restaurant, ka, wholesale, industry, other);
        smartTable = view.findViewById(R.id.table);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setShowTableTitle(false);
        smartTable.getConfig().setShowXSequence(false);
        smartTable.getConfig().setShowYSequence(false);
        tableData.setOnItemClickListener(new TableData.OnItemClickListener() {
            @Override
            public void onClick(Column column, String value, Object o, int col, int row) {
                Toast.makeText(getActivity(), "X:"+col+",Y:"+row, Toast.LENGTH_SHORT).show();
                mChartManager = new LineChartManager(mLineChart,"sensors", Color.BLACK);
                mChartManager.setDescription("");

                for(int i=0;i<15;i++){
                    addEntry(view);
                }
            }
        });

        //set table-------------------------------------------------


        //set table**************************************************

        return view;
    }


    public void addEntry(View view) {
        mChartManager.addEntry((int)(Math.random() * 100));
    }
}


class LineChartManager {
    private LineChart lineChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private List<ILineDataSet> lineDataSets = new ArrayList<>();
    private SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
    private List<String> timeList = new ArrayList<>(); //存储x轴的时间

    //一条曲线
    public LineChartManager(LineChart mLineChart, String name, int color) {
        this.lineChart = mLineChart;
        leftAxis = lineChart.getAxisLeft();
        rightAxis = lineChart.getAxisRight();
        xAxis = lineChart.getXAxis();
        initLineChart();
        initLineDataSet(name, color);
    }

    //多条曲线
    public LineChartManager(LineChart mLineChart, List<String> names, List<Integer> colors) {
        this.lineChart = mLineChart;
        leftAxis = lineChart.getAxisLeft();
        rightAxis = lineChart.getAxisRight();
        xAxis = lineChart.getXAxis();
        initLineChart();
        initLineDataSet(names, colors);
    }

    /**
     * 初始化LineChar
     */
    private void initLineChart() {

        lineChart.setDrawGridBackground(false);
        //显示边界
        lineChart.setDrawBorders(true);
        //折线图例 标签 设置
        Legend legend = lineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(11f);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);

        //X轴设置显示位置在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(10);


        //保证Y轴从0开始，不然会上移一点
        leftAxis.setAxisMinimum(0f);
        rightAxis.setAxisMinimum(0f);
    }

    /**
     * 初始化折线(一条线)
     *
     * @param name
     * @param color
     */
    private void initLineDataSet(String name, int color) {

        lineDataSet = new LineDataSet(null, name);
        lineDataSet.setLineWidth(1.5f);
        lineDataSet.setCircleRadius(1.5f);
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);
        lineDataSet.setHighLightColor(color);
        //设置曲线填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        //添加一个空的 LineData
        lineData = new LineData();
        lineChart.setData(lineData);
        lineChart.invalidate();

    }

    /**
     * 初始化折线（多条线）
     *
     * @param names
     * @param colors
     */
    private void initLineDataSet(List<String> names, List<Integer> colors) {

        for (int i = 0; i < names.size(); i++) {
            lineDataSet = new LineDataSet(null, names.get(i));
            lineDataSet.setColor(colors.get(i));
            lineDataSet.setLineWidth(1.5f);
            lineDataSet.setCircleRadius(1.5f);
            lineDataSet.setColor(colors.get(i));

            lineDataSet.setDrawFilled(false);
            lineDataSet.setDrawValues(false);
            lineDataSet.setCircleColor(colors.get(i));
            lineDataSet.setHighLightColor(colors.get(i));
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
            lineDataSet.setValueTextSize(10f);
            lineDataSets.add(lineDataSet);

        }
        //添加一个空的 LineData
        lineData = new LineData();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

//    public void Ads() {
//        timeList=new ArrayList<>();
//        addEntry(35);
//        addEntry(45);
//        addEntry(55);
//        lineData.notifyDataChanged();
//        lineChart.notifyDataSetChanged();
//    }

    /**
     * 动态添加数据（一条折线图）
     *
     * @param number
     */
    public void addEntry(int number) {

        //最开始的时候才添加 lineDataSet（一个lineDataSet 代表一条线）
        if (lineDataSet.getEntryCount() == 0) {
            lineData.addDataSet(lineDataSet);
        }
        lineChart.setData(lineData);
        //避免集合数据过多，及时清空（做这样的处理，并不知道有没有用，但还是这样做了）
//        if (timeList.size() > 11) {
//            timeList.clear();
//        }

        timeList.add(df.format(System.currentTimeMillis()));

        Entry entry = new Entry(lineDataSet.getEntryCount(), number);
//        Entry entry = new Entry(number, number);
        lineData.addEntry(entry, 0);
        //通知数据已经改变
        lineData.notifyDataChanged();
        lineChart.notifyDataSetChanged();
        //设置在曲线图中显示的最大数量
//        lineChart.setVisibleXRangeMaximum(10);
        //移到某个位置
        lineChart.moveViewToX(lineData.getEntryCount() - 5);
    }

    /**
     * 动态添加数据（多条折线图）
     *
     * @param numbers
     */
    public void addEntry(List<Float> numbers) {

        if (lineDataSets.get(0).getEntryCount() == 0) {
            lineData = new LineData(lineDataSets);
            lineChart.setData(lineData);
        }
        if (timeList.size() > 100) {
            timeList.clear();
        }
        timeList.add(df.format(System.currentTimeMillis()));
        for (int i = 0; i < numbers.size(); i++) {
            Entry entry = new Entry(lineDataSet.getEntryCount(), numbers.get(i));
            lineData.addEntry(entry, i);
            lineData.notifyDataChanged();
            lineChart.notifyDataSetChanged();
            lineChart.setVisibleXRangeMaximum(6);
            lineChart.moveViewToX(lineData.getEntryCount() - 5);
        }
    }

    /**
     * 设置Y轴值
     *
     * @param max
     * @param min
     * @param labelCount
     */
    public void setYAxis(float max, float min, int labelCount) {
        if (max < min) {
            return;
        }
        leftAxis.setAxisMaximum(max);
        leftAxis.setAxisMinimum(min);
        leftAxis.setLabelCount(labelCount, false);

        rightAxis.setAxisMaximum(max);
        rightAxis.setAxisMinimum(min);
        rightAxis.setLabelCount(labelCount, false);
        lineChart.invalidate();
    }

    /**
     * 设置高限制线
     *
     * @param high
     * @param name
     */
    public void setHightLimitLine(float high, String name, int color) {
        if (name == null) {
            name = "高限制线";
        }
        LimitLine hightLimit = new LimitLine(high, name);
        hightLimit.setLineWidth(4f);
        hightLimit.setTextSize(10f);
        hightLimit.setLineColor(color);
        hightLimit.setTextColor(color);
        leftAxis.addLimitLine(hightLimit);
        lineChart.invalidate();
    }

    /**
     * 设置低限制线
     *
     * @param low
     * @param name
     */
    public void setLowLimitLine(int low, String name) {
        if (name == null) {
            name = "低限制线";
        }
        LimitLine hightLimit = new LimitLine(low, name);
        hightLimit.setLineWidth(4f);
        hightLimit.setTextSize(10f);
        leftAxis.addLimitLine(hightLimit);
        lineChart.invalidate();
    }

    /**
     * 设置描述信息
     *
     * @param str
     */
    public void setDescription(String str) {
        Description description = new Description();
        description.setText(str);
        lineChart.setDescription(description);
        lineChart.invalidate();
    }
}


class User {
    public User(String city, int name, int count, int restaurant, int ka, int wholesale, int industry, int other) {
        this.city = city;
        this.name = name;
        this.count = count;
        this.restaurant = restaurant;
        this.ka = ka;
        this.wholesale = wholesale;
        this.industry = industry;
        this.other = other;
    }

    //    name：版块名称，count：目标值，restaurant：餐饮数量，ka：KA数量，wholesale：流通批发数量，industry：工业加工数量，other：其它数量
    private String city;
    private int name;
    private int count;
    private int restaurant;
    private int ka;
    private int wholesale;
    private int industry;
    private int other;
}