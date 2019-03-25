package com.example.asus.zhishui;

import android.content.ContentValues;
import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus.zhishui.bookpage.bookpage;

public class edit_info extends AppCompatActivity {
    Button next;
    EditText name,sex,age,disease,blood;
    int ssex,sblood;
    String sname,sbirth,sill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);
        initView();
        Toolbar eiToolbar = (Toolbar) findViewById(R.id.edit_toolbar);
        setSupportActionBar(eiToolbar);
        ActionBar ei = getSupportActionBar();
        ei.setDisplayHomeAsUpEnabled(true);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                sname = name.getText().toString();
//                ssex = Integer.parseInt(sex.getText().toString());
//                sbirth = age.getText().toString();
//                sill = disease.getText().toString();
//                sblood = Integer.parseInt(blood.getText().toString());
//                ContentValues values = new ContentValues();
//                values.put("name",sname);
//                values.put("sex",ssex);
//                values.put("birth",sbirth);
//                values.put("blood",sblood);
                Intent intent = new Intent(edit_info.this, susceptibility.class);
                startActivity(intent);
            }
        });

    }

    private void initView(){
        next = (Button) findViewById(R.id.editinfo_next_btn);
//        sex = (EditText) findViewById(R.id.ds_sex_picker);
//        name = (EditText) findViewById(R.id.name_et);
//        age = (EditText) findViewById(R.id.ds_age_picker);
//        disease = (EditText) findViewById(R.id.ds_disease_picker);
//        blood = (EditText) findViewById(R.id.ds_blood_picker);

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
                        Intent intent = new Intent(edit_info.this, bookpage.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Log.i("1","choose main!");
                        Intent intent1 = new Intent(edit_info.this, main_activity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Log.i("1","choose me!");
                        Intent intent2 = new Intent(edit_info.this, me.class);
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
