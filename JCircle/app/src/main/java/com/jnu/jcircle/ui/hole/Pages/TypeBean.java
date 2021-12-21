package com.jnu.jcircle.ui.hole.Pages;
//fragment涉及到的涉及的具体类
public class TypeBean {
    int id;     //数据库用
    String name;
    int wimageId;//未被选中id
    int simageId; //被选中id
    int flag;   //myself_flag为1,others_为0

    public TypeBean(int id, String name, int wimageId, int simageId, int flag) {
        this.id = id;
        this.name = name;
        this.wimageId = wimageId;
        this.simageId = simageId;
        this.flag = flag;
    }
    //getter和setter方法
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

    public int getWimageId() {
        return wimageId;
    }

    public void setWimageId(int wimageId) {
        this.wimageId = wimageId;
    }

    public int getSimageId() {
        return simageId;
    }

    public void setSimageId(int simageId) {
        this.simageId = simageId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public TypeBean() {
    }
}

