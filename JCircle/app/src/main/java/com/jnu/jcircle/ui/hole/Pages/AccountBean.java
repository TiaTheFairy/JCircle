package com.jnu.jcircle.ui.hole.Pages;


//在键盘点击确定后，数据传入数据库中去，数据相关类
public class AccountBean {
    int id;
    String name;
    int simageId; //选中的id
    String time;  //时间
    String liuyan;//留言
    int year, month,day,flag;//myself_flag为1,others_支出为0

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSimageId() {
        return simageId;
    }

    public void setSimageId(int simageId) {
        this.simageId = simageId;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLiuyan() {
        return liuyan;
    }

    public void setLiuyan(String beizhu) {
        this.liuyan = beizhu;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public AccountBean() {

    }

    public AccountBean(int id, String name, int simageId, String time, String liuyan, int year, int month, int day, int flag) {
        this.id = id;
        this.name = name;
        this.simageId = simageId;
        this.time = time;
        this.liuyan =liuyan;
        this.year = year;
        this.month = month;
        this.day = day;
        this.flag = flag;
    }


}