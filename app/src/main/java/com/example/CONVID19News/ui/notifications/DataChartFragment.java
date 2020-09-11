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
import com.example.CONVID19News.bean.CountryModel;
import com.example.CONVID19News.bean.timedata;
import com.example.CONVID19News.myData;
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
import java.util.Collections;
import java.util.Comparator;
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
        mChartManager = new LineChartManager(mLineChart, "sensors", Color.BLACK);
        mChartManager.setDescription("");

        for (int i = 0; i < 15; i++) {
            addEntry(view,0);
        }
        //set chart**********************************************

        //set table--------------------------------------------
        Column<String> Province = new Column<>("Province", "Province");
        Column<String> Confirmed = new Column<>("Confirmed", "Confirmed");
        Column<Integer> Cured = new Column<>("Cured", "Cured");
        Column<Integer> Dead = new Column<>("Dead", "Dead");
        Column<Integer> Suspected = new Column<>("Suspected", "Suspected");
//        Column<Integer> ka = new Column<>("KA", "ka");
//        Column<Integer> wholesale = new Column<>("流通批发", "wholesale");
//        Column<Integer> industry = new Column<>("工业加工", "industry");
//        Column<Integer> other = new Column<>("其他", "other");
        //设置该列当字段相同时自动合并
        Province.setAutoMerge(true);
//        Confirmed.setAutoCount(true);
        final List<User> list = new ArrayList<>();

        final List<CountryModel> proModel = myData.getCountry();

        for(int i=0;i<proModel.size();i++){
            CountryModel CM=proModel.get(i);
            timedata td=CM.getTimedataList().get(CM.getTimedataList().size()-1);

            list.add(new User(CM.getArea(),Integer.parseInt(td.getConfirmed()),Integer.parseInt(td.getCured()),Integer.parseInt(td.getDead()),Integer.parseInt(td.getSuspected())));
        }
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("乌鲁木齐", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));
//        list.add(new User("沈阳", 100, 150, 50, 240, 1100, 450, 23458));

//            System.out.println(list.get(0).getClass());
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.getConfirmed()-o1.getConfirmed();
            }
        });



        TableData<User> tableData = new TableData<>("表格名", list, Province,Confirmed,Cured,Dead,Suspected);
        smartTable = view.findViewById(R.id.table);
        smartTable.setTableData(tableData);
        smartTable.getConfig().setShowTableTitle(false);
        smartTable.getConfig().setShowXSequence(false);
        smartTable.getConfig().setShowYSequence(false);
        tableData.setOnItemClickListener(new TableData.OnItemClickListener() {
            @Override
            public void onClick(Column column, String value, Object o, int col, int row) {
//                Toast.makeText(getActivity(), "X:" + col + ",Y:" + row, Toast.LENGTH_SHORT).show();
//                mChartManager = new LineChartManager(mLineChart, "sensors", Color.BLACK);
//                mChartManager.setDescription("");

//                for (int i = 0; i < 15; i++) {
//                    addEntry(view);
//                }
                for(int i=0;i<proModel.size();i++){
                    if(proModel.get(i).getArea()==list.get(row).getProvince()){
                        int ii=proModel.get(i).getTimedataList().size()-15;
                        if(ii<0)ii=0;

                        mChartManager = new LineChartManager(mLineChart, "sensors", Color.BLACK);
                        for(int j=ii;j<proModel.get(i).getTimedataList().size();j++){
                            int cnum=Integer.parseInt(proModel.get(i).getTimedataList().get(j).getConfirmed());
//                            if(cnum<0)cnum=0;
                            addEntry(view,cnum);
                        }
                    }
                }
            }
        });

        //set table-------------------------------------------------


        //set table**************************************************

        return view;
    }


    public void addEntry(View view,int num) {
//        mChartManager.addEntry((int) (Math.random() * 100));
        mChartManager.addEntry(num);
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
//        leftAxis.setAxisMinimum(0f);
//        rightAxis.setAxisMinimum(0f);
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
//        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setMode(LineDataSet.Mode.LINEAR);
        //添加一个空的 LineData
        lineData = new LineData();
        lineChart.setData(lineData);
        lineChart.animateX(1000);

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
    private String Province;
    private int Confirmed;
    private int Cured;
    private int Dead;
    private int Suspected;
    //    name：版块名称，count：目标值，restaurant：餐饮数量，ka：KA数量，wholesale：流通批发数量，industry：工业加工数量，other：其它数量


    public User(String p, int co, int cu, int d, int s) {
        this.Province = p;
        this.Confirmed = co;
        this.Cured = cu;
        this.Dead = d;
        this.Suspected = s;

    }

    public int getConfirmed(){
        return Confirmed;
    }

    public String getProvince(){
        return Province;
    }


}