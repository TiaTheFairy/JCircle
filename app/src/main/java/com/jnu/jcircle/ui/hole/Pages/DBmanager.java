package com.jnu.jcircle.ui.hole.Pages;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

//管理数据库的类
public class DBmanager {
    private  static SQLiteDatabase db; //初始化数据库
    public static  void initDB(Context context){
        griditem_object_openHelper helper = new griditem_object_openHelper(context);//帮助类对象
        db=helper.getWritableDatabase();//数据库对象,前往全局类引用该对象
    }
    //读取数据库数据，写入集合里。myself_flag为1,others_支出为0

    @SuppressLint("Range")
    public static List<TypeBean>getTypeList(int flag){
        List<TypeBean>list=new ArrayList<>();
        //读取typedb数据表
        String sql="select * from typetb where flag="+flag;
        Cursor cursor = db.rawQuery(sql ,null); //执行
        //循环读取游标内容，存进对象
        while(cursor.moveToNext()){   //判断是否有下一个
            int id=cursor.getInt((cursor.getColumnIndex("id")));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            int wimageId=cursor.getInt(cursor.getColumnIndex("wimageId"));
            int simageId=cursor.getInt(cursor.getColumnIndex("simageId"));
            int flagl=cursor.getInt(cursor.getColumnIndex("flag"));
            TypeBean typeBean = new TypeBean(id, name, wimageId, simageId, flagl);
            list.add(typeBean);  //添加数据到集合里
        }
        return list;
    }


    //向表（accounttb）插入元素
    public  static  void insertItemToAccounttb(AccountBean bean){
        ContentValues values = new ContentValues();
        values.put("name",bean.getName());
        values.put("simageId",bean.getSimageId());
        values.put("time",bean.getTime());
        values.put("liuyan",bean.getLiuyan());
        values.put("year ",bean.getYear());
        values.put("month",bean.getMonth());
        values.put("day",bean.getDay());
        values.put("flag",bean.getFlag());
        db.insert("accounttb",null,values);

    }

    public  static  List<AccountBean>getDayAccountFromtb(int year,int month,int day){
        List<AccountBean>list=new ArrayList<>();
        String sql="select * from accounttb where year=? and month=? and day=? order by id desc";  //在数据库accounttb中查找并倒叙排列
        Cursor cursor = db.rawQuery(sql, new String[]{year + "", month + "", day + ""});
        //遍历每一行数据
        while (cursor.moveToNext()){
            int id = cursor.getInt((cursor.getColumnIndex("id")));
            String name = cursor.getString((cursor.getColumnIndex("name")));
            int simageId = cursor.getInt((cursor.getColumnIndex("simageId")));
            String time = cursor.getString((cursor.getColumnIndex("time")));
            String liuyan = cursor.getString((cursor.getColumnIndex("liuyan")));
            int flag = cursor.getInt((cursor.getColumnIndex("flag")));              //要和accountBean的对象数目一样

            AccountBean accountBean = new AccountBean(id,name,simageId,time,liuyan,year,month,day,flag);
            list.add(accountBean);  //将accountBean添加入集合，还需要主页面加载才可以呈现
        }
        return list;
    }
}
