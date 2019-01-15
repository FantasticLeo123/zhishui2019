package com.example.asus.zhishui;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by asus on 2018/7/30.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "zhishui.db";
    private static final String TBL_INFORMATION = "info";
    private static final String CREATE_INFORMATION_TBL
            = "CREATE TABLE " + "info(" +
            "id INTEGER DEFAULT '1' NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " name TEXT," +
            " sex INTEGER DEFAULT -1," +//0 男性  1 女性  2 变性  default:-1
            " blood INTEGER DEFAULT -1," +//0 A型  1 B型  2 O型  3 AB型  DEFAULT:-1
            " birth TEXT," +
            " ill TEXT," +//每次用&分隔
            " prefer INTEGER DEFAULT 0," +//0 音乐放松  1 引导放松  2 自传体回忆  default:0
            " curremot INTEGER DEFAULT -1," +//0 愉悦  1 愤怒  2 忧伤  3 焦虑  4 平静  default:-1
            " yigan INTEGER DEFAULT -1)";//得分大小衡量情绪易感性  default:-1

    private static final String TBL_INDICES = "indices";
    private static final String CREATE_INDICES_TBL
            = "CREATE TABLE " + "indices(" +
            "id INTEGER DEFAULT '1' NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " heartrate INTEGER DEFAULT -1 NOT NULL," +//default:-1
            " skin INTEGER DEFAULT -1 NOT NULL," +//default:-1
            " emot INTEGER DEFAULT '-1')";//0 愉悦  1 愤怒  2 忧伤  3 焦虑  4 平静  default:-1
    private SQLiteDatabase db;

    public DBHelper(android.content.Context context){
        super(context, DB_NAME,null,2);
        Log.i("db","创建数据库");
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        this.db = db;
        db.execSQL(CREATE_INFORMATION_TBL);
        db.execSQL(CREATE_INDICES_TBL);
        Log.i("db","建表成功！");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

    }

//    public void insertTodoItem(ContentValues values){//新增数据
//        SQLiteDatabase db = getWritableDatabase();
//        db.insert(TBL_NAME,null,values);
//        db.close();
//    }

    public Cursor queryAll(){//查询所有的todo事项
        SQLiteDatabase db = getWritableDatabase();
        Cursor c ; //= db.query(TBL_NAME,null,null,null,null,null,null);
        c = db.rawQuery("select * from todo",null);
        return c;
    }

//    public void delById(int id){//通过id进行删除
//        if(db == null){
//            SQLiteDatabase db = getWritableDatabase();
//            db.delete(TBL_NAME,"id=?",new String[]{String.valueOf(id)});
//        }
//    }

    public  void updateDelById(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c;
        db.execSQL("update todo set del = ? where id = ?",
                new String[]{String.valueOf(1),String.valueOf(id)});
    }

    public Cursor queryByDate(String date){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from todo where date='" + date + "'",null);
        return c;
    }

    public Cursor queryByid(int id){
        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.rawQuery("select * from todo where id='" + id + "'",null);
        return c;
    }

    public void updateTodoItem(int state, String id){//修改完成与未完成状态
        SQLiteDatabase db = getWritableDatabase();
        Cursor c;
        Log.i("333","state:" + state);
        if(state == 0){
            db.execSQL("update todo set finish = ? where id = ?",
                    new String[]{String.valueOf(1),id});
        }else if(state == 1){
            db.execSQL("update todo set finish = ? where id = ?",
                    new String[]{String.valueOf(0),id});
        }
    }

    public void close(){
        if(db!= null){
            db.close();
        }
    }
}
