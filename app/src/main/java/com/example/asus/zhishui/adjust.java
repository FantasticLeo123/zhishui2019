package com.example.asus.zhishui;

import android.content.Intent;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.example.asus.zhishui.bookpage.bookpage;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;
import java.util.logging.Handler;

public class adjust extends AppCompatActivity {
//    private MediaPlayer mp = new MediaPlayer();//播放器
//    private ImageButton audioplay;
//    private ImageButton pre;
//    private ImageButton next;

//    // 多个系列的数据集合,即多条线的数据集合
    XYMultipleSeriesDataset mDataset;
    // 一个系列的数据，即一条线的数据集合
    XYSeries series;
    XYSeries series2;

    // 多个系列的环境渲染，即整个画折线的区域
    XYMultipleSeriesRenderer mRenderer;
    // 一个系列的环境渲染，即一条线的环境渲染
    XYSeriesRenderer r;
    XYSeriesRenderer r2;
    // 整个view
    GraphicalView view;

    int i = 5;
    LinearLayout ll;
    ArrayList<Integer> ai;
    private Handler handler;
    Button like;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust);
        initView();

//        audioplay = (ImageButton)findViewById(R.id.audioplay);
//        pre = (ImageButton)findViewById(R.id.pre);
//        next = (ImageButton)findViewById(R.id.next);
//        final MediaPlayer musicRelax = MediaPlayer.create(this, R.raw.情绪管理方式1_音乐放松_N17);
//        final MediaPlayer imagination = MediaPlayer.create(this, R.raw.情绪管理方式3_引导想象_final);
//        final MediaPlayer count = MediaPlayer.create(this, R.raw.情绪管理方式4_数数_final);
//        audioplay.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                mp.start();
//            }
//        });

    }


    private void initChar(){
        lineView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    double d = Math.random() * 15;
                    double d2 = Math.random() * 12;
                    series.add(i, d);
                    series2.add(i,d2);
                    //动态添加数据和标题
                    mRenderer.addXTextLabel(i, String.valueOf(i));
                    //重绘折线
                    view.repaint();
                    i++;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void lineView() {
        // 同样是需要数据dataset和视图渲染器renderer
        mDataset = new XYMultipleSeriesDataset();
        series = new XYSeries("心率");
//        series.add(1, 6);
//        series.add(2, 5);
//        series.add(3, 7);
//        series.add(4, 4);
        mDataset.addSeries(0,series);

        series2 = new XYSeries("皮肤电");
//        series2.add(1, 9);
//        series2.add(2, 2);
//        series2.add(3, 6);
//        series2.add(4, 1);
        mDataset.addSeries(1,series2);

        mRenderer = new XYMultipleSeriesRenderer();

        // 设置图表的X轴的当前方向
        mRenderer
                .setOrientation(XYMultipleSeriesRenderer.Orientation.HORIZONTAL);

        mRenderer.setBackgroundColor(getResources().getColor(R.color.white));
        //mRenderer.setXTitle("X轴");// 设置为X轴的标题
        //mRenderer.setYTitle("Y轴");// 设置y轴的标题
        //mRenderer.setAxisTitleTextSize(20);// 设置轴标题文本大小
        mRenderer.setChartTitle("实时指标");// 设置图表标题
        mRenderer.setChartTitleTextSize(100);// 设置图表标题文字的大小
        mRenderer.setLabelsTextSize(30);// 设置标签的文字大小
        mRenderer.setLegendTextSize(50);// 设置图例文本大小
        mRenderer.setPointSize(10f);// 设置点的大小
        mRenderer.setYAxisMin(0);// 设置y轴最小值是0
        //mRenderer.setYAxisMax(15);
        //mRenderer.setYLabels(0);// 设置Y轴刻度个数（貌似不太准确）
        mRenderer.setXAxisMax(20);//设置X轴坐标个数


        // 将x标签栏目显示如：1,2,3,4替换为显示1月，2月，3月，4月
        mRenderer.addXTextLabel(1, "1");
        mRenderer.addXTextLabel(2, "2");
        mRenderer.addXTextLabel(3, "3");
        mRenderer.addXTextLabel(4, "4");
        mRenderer.setXLabels(0);// 设置只显示如1月，2月等替换后的东西，不显示1,2,3等
        //mRenderer.setMargins(new int[] { 20, 30, 15, 20 });// 设置视图位置
        // 第一个参数设置X轴是否可滑动，第二个参数设置Y轴是够可滑动
        mRenderer.setPanEnabled(false, false);

        r = new XYSeriesRenderer();
        r.setColor(Color.BLUE);// 设置颜色
        r.setPointStyle(PointStyle.CIRCLE);// 设置点的样式
        r.setFillPoints(true);// 填充点（显示的点是空心还是实心）
        r.setDisplayChartValues(false);// 设置将点的值不显示出来
        //r.setChartValuesSpacing(10);// 显示的点的值与图的距离
        //r.setChartValuesTextSize(25);// 点的值的文字大小

        //r.setFillBelowLine(true);//是否填充折线图的下方
        //r.setFillBelowLineColor(Color.GREEN);//填充的颜色，如果不设置就默认与线的颜色一致
        r.setLineWidth(3);// 设置线宽
        mRenderer.addSeriesRenderer(r);

        r2 = new XYSeriesRenderer();
        r2.setColor(Color.YELLOW);// 设置颜色
        r2.setPointStyle(PointStyle.CIRCLE);// 设置点的样式
        r2.setFillPoints(true);// 填充点（显示的点是空心还是实心）
        r2.setDisplayChartValues(false);// 设置将点的值不显示出来
        //r2.setChartValuesSpacing(10);// 显示的点的值与图的距离
        //r2.setChartValuesTextSize(25);// 点的值的文字大小

        //r2.setFillBelowLine(true);//是否填充折线图的下方
        //r2.setFillBelowLineColor(Color.GREEN);//填充的颜色，如果不设置就默认与线的颜色一致
        r2.setLineWidth(3);// 设置线宽
        mRenderer.addSeriesRenderer(r2);

        view = ChartFactory.getLineChartView(this, mDataset, mRenderer);
        view.setBackgroundColor(getResources().getColor(R.color.white));
        ll.addView(view);
        //将画好折线的view添加到xml中的一个布局里
    }

    private void initView(){
        ll = (LinearLayout) findViewById(R.id.ser_ll1);
        like = (Button)findViewById(R.id.adjust_like_btn);

        like.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(adjust.this,"已喜欢",Toast.LENGTH_SHORT);

            }
        });
        //设置导航栏
        BottomNavigationBar bottomTabs = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomTabs.addItem(new BottomNavigationItem(R.drawable.book, "情绪书"))
                .addItem(new BottomNavigationItem(R.drawable.home, "主界面"))
                .addItem(new BottomNavigationItem(R.drawable.mine, "我的"))
                .setFirstSelectedPosition(1)
                .setActiveColor(R.color.ac)
                .initialise();
        //导航栏监听器
        bottomTabs.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        Log.i("1","choose book!");
                        Intent intent = new Intent(adjust.this, bookpage.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Log.i("1","choose index!");
                        Intent intent1 = new Intent(adjust.this, main_activity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Log.i("1","choose me!");
                        Intent intent2 = new Intent(adjust.this, me.class);
                        startActivity(intent2);
                        break;
                }
            }
            @Override
            public void onTabUnselected(int position) {
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
        initChar();
    }

}
