package com.example.asus.zhishui;

import android.content.DialogInterface;
import android.content.Intent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.asus.zhishui.bookpage.bookpage;

public class susceptibility extends AppCompatActivity {
    Button pre;
    Button skip;
    Button submit;
    ImageButton question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_susceptibility);
        initView();
        Toolbar suToolbar = (Toolbar) findViewById(R.id.susceptibility_toolbar);
        setSupportActionBar(suToolbar);
        ActionBar su = getSupportActionBar();
        su.setDisplayHomeAsUpEnabled(true);

    }

    private void initView(){
        pre = (Button) findViewById(R.id.yigan_pre_btn);
        skip = (Button)findViewById(R.id.yigan_skip_btn);
        submit = (Button)findViewById(R.id.yigan_submit_btn);
        question = (ImageButton) findViewById(R.id.question);
        pre.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(susceptibility.this, edit_info.class);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(susceptibility.this, me.class);
                startActivity(intent);
            }
        });
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(susceptibility.this, me.class);
                startActivity(intent);
            }
        });

        question.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder dialog=new AlertDialog.Builder(susceptibility.this);
                //获取AlertDialog对象
                dialog.setTitle("情绪易感性");//设置标题
                dialog.setMessage("情绪易感性专指人们在执行认知活动时受其情绪影响的程度特征。情绪易感性的程度不同，相应的应为反应也不同，情绪易感性高的人群容易受其情绪的控制，因此这类人群更应该利用情绪调节策略来控制自己的情绪。");//设置信息具体内容
                dialog.setCancelable(true);//设置是否可取消
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override//设置ok的事件
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //在此处写入ok的逻辑
                        dialogInterface.dismiss();

                    }
                });
                dialog.show();
            }
        });


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
                        Intent intent = new Intent(susceptibility.this, bookpage.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Log.i("1","choose index!");
                        Intent intent1 = new Intent(susceptibility.this, main_activity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Log.i("1","choose me!");
                        Intent intent2 = new Intent(susceptibility.this, me.class);
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
