package com.example.asus.zhishui;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class Editinfo extends AppCompatActivity {
    Button next;
    EditText name,sex,birth,ill,blood;
    int ssex,sblood;
    String sname,sbirth,sill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);
        initView();

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sname = name.getText().toString();
                ssex = Integer.parseInt(sex.getText().toString());
                sbirth = birth.getText().toString();
                sill = ill.getText().toString();
                sblood = Integer.parseInt(blood.getText().toString());
                ContentValues values = new ContentValues();
                values.put("name",sname);
                values.put("sex",ssex);
                values.put("birth",sbirth);
                values.put("blood",sblood);
                Intent intent = new Intent(Editinfo.this, yiganxing.class);
                startActivity(intent);
            }
        });

    }

    private void initView(){
        next = (Button) findViewById(R.id.editinfo_next_btn);
        sex = (EditText) findViewById(R.id.editinfo_sex_et);
        name = (EditText) findViewById(R.id.editinfo_name_et);
        birth = (EditText) findViewById(R.id.editinfo_birth_et);
        ill = (EditText) findViewById(R.id.editinfo_ill_et);
        blood = (EditText) findViewById(R.id.editinfo_blood_et);
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
                        Log.i("1","choose Today!");
                        break;
                    case 1:
                        Log.i("1","choose index!");
                        Intent intent1 = new Intent(Editinfo.this, MainActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Log.i("1","choose calendar!");
                        Intent intent2 = new Intent(Editinfo.this, Me.class);
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
