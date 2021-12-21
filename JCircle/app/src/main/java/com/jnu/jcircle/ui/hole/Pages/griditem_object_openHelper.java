package com.jnu.jcircle.ui.hole.Pages;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.jnu.jcircle.R;

//继承数据库
public class griditem_object_openHelper extends SQLiteOpenHelper {

    public griditem_object_openHelper(@Nullable Context context) {
        super(context,"MycountSql", null, 1);
    }


    //项目第一次运行时创建数据库时调用
    @Override
    public void onCreate(SQLiteDatabase db) {
        //创造类型表，项目和TypeBean对象一一对应
        String sql="create table typetb(id integer primary key autoincrement,name varchar(10),wimageId integer,simageId integer,flag integer)";
        db.execSQL(sql);//传入
        insertType(db);//插入

        //创建tb表。和accountbean一一对应
        sql="create table accounttb(id integer primary key autoincrement,name varchar(10),simageId integer,time varchar(80),liuyan varchar(80),year integer,month integer,day integer,flag integer)";
        db.execSQL(sql); //传入

    }

    private void insertType(SQLiteDatabase db) {
        //向typetb插入元素
        String sql="insert into typetb (name,wimageId,simageId,flag) values (?,?,?,?)";
        db.execSQL(sql,new Object[]{"路人0", R.mipmap.rwred,R.mipmap.rw,0});  //others_支出为0, myself为1,
        db.execSQL(sql,new Object[]{"路人1",R.mipmap.r01,R.mipmap.kuangweifenggerenwu1,0});
        db.execSQL(sql,new Object[]{"路人2",R.mipmap.r02,R.mipmap.kuangweifenggerenwu2,0});
        db.execSQL(sql,new Object[]{"路人3",R.mipmap.r03,R.mipmap.kuangweifenggerenwu3,0});
        db.execSQL(sql,new Object[]{"路人4",R.mipmap.r05,R.mipmap.kuangweifenggerenwu15,0});
        db.execSQL(sql,new Object[]{"路人5",R.mipmap.r06,R.mipmap.kuangweifenggerenwu6,0});
        db.execSQL(sql,new Object[]{"路人6",R.mipmap.r07,R.mipmap.kuangweifenggerenwu7,0});
        db.execSQL(sql,new Object[]{"路人7",R.mipmap.r10,R.mipmap.kuangweifenggerenwu10,0});
        db.execSQL(sql,new Object[]{"路人8",R.mipmap.r11,R.mipmap.kuangweifenggerenwu11,0});
        db.execSQL(sql,new Object[]{"路人9",R.mipmap.r12,R.mipmap.kuangweifenggerenwu12,0});
        db.execSQL(sql,new Object[]{"路人10",R.mipmap.r13,R.mipmap.kuangweifenggerenwu13,0});
        db.execSQL(sql,new Object[]{"路人11",R.mipmap.r15,R.mipmap.kuangweifenggerenwu15,0});
        db.execSQL(sql,new Object[]{"路人12",R.mipmap.r16,R.mipmap.kuangweifenggerenwu16,0});
        db.execSQL(sql,new Object[]{"路人13",R.mipmap.r18,R.mipmap.kuangweifenggerenwu18,0});
        db.execSQL(sql,new Object[]{"路人14",R.mipmap.r20,R.mipmap.kuangweifenggerenwu20,0});


        db.execSQL(sql,new Object[]{"路人0",R.mipmap.rw,R.mipmap.rwred,1});
        db.execSQL(sql,new Object[]{"路人1",R.mipmap.kuangweifenggerenwu1,R.mipmap.r01,1});
        db.execSQL(sql,new Object[]{"路人2",R.mipmap.kuangweifenggerenwu2,R.mipmap.r02,1});
        db.execSQL(sql,new Object[]{"路人3",R.mipmap.kuangweifenggerenwu3,R.mipmap.r03,1});
        db.execSQL(sql,new Object[]{"路人4",R.mipmap.kuangweifenggerenwu15,R.mipmap.r05,1});
        db.execSQL(sql,new Object[]{"路人5",R.mipmap.kuangweifenggerenwu6,R.mipmap.r06,1});
        db.execSQL(sql,new Object[]{"路人6",R.mipmap.kuangweifenggerenwu7,R.mipmap.r07,1});
        db.execSQL(sql,new Object[]{"路人7",R.mipmap.kuangweifenggerenwu10,R.mipmap.r10,1});
        db.execSQL(sql,new Object[]{"路人8",R.mipmap.kuangweifenggerenwu11,R.mipmap.r11,1});
        db.execSQL(sql,new Object[]{"路人9",R.mipmap.kuangweifenggerenwu12,R.mipmap.r12,1});
        db.execSQL(sql,new Object[]{"路人10",R.mipmap.kuangweifenggerenwu13,R.mipmap.r13,1});
        db.execSQL(sql,new Object[]{"路人11",R.mipmap.kuangweifenggerenwu15,R.mipmap.r15,1});
        db.execSQL(sql,new Object[]{"路人12",R.mipmap.kuangweifenggerenwu16,R.mipmap.r16,1});
        db.execSQL(sql,new Object[]{"路人13",R.mipmap.kuangweifenggerenwu18,R.mipmap.r18,1});
        db.execSQL(sql,new Object[]{"路人14",R.mipmap.kuangweifenggerenwu20,R.mipmap.r20,1});

    }

    //项目数据库更新时调用
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
