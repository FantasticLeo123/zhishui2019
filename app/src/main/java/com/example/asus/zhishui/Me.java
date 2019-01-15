package com.example.asus.zhishui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class Me extends AppCompatActivity {
    Button modify;
    Button aboutus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        initView();

        aboutus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Me.this, Aboutus.class);
                startActivity(intent);
            }
        });
        modify.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Me.this, Editinfo.class);
                startActivity(intent);
            }
        });
    }

    private void initView(){
        aboutus = (Button) findViewById(R.id.me_abtus_btn);
        modify = (Button) findViewById(R.id.me_modify_btn);

        //设置导航栏
        BottomNavigationBar bottomTabs = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomTabs.addItem(new BottomNavigationItem(R.drawable.book, "情绪书"))
                .addItem(new BottomNavigationItem(R.drawable.home, "主界面"))
                .addItem(new BottomNavigationItem(R.drawable.mine, "我的"))
                .setFirstSelectedPosition(2)
                .setActiveColor(R.color.ac)
                .initialise();
        //导航栏监听器
        bottomTabs.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                switch (position) {
                    case 0:
                        Log.i("1","choose book!");
                        Intent intent = new Intent(Me.this, book.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Log.i("1","choose index!");
                        Intent intent1 = new Intent(Me.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Log.i("1","choose me!");
                        Intent intent2 = new Intent(Me.this, Me.class);
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
    }

}
