package com.jnu.jcircle.ui.hole;

import android.app.Application;

import com.jnu.jcircle.ui.hole.Pages.DBmanager;

public class Unitapp extends Application {//全局类


    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库对象
        DBmanager.initDB(getApplicationContext()); //得到全局引用对象，注意，application只能有一个对象，需在清单文件注册
    }
}