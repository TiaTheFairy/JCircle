package com.jnu.jcircle.ui.hole.Pages;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.jnu.jcircle.R;


class liuyanDialog extends Dialog implements View.OnClickListener{
    EditText et;
    Button cancleBtn;
    Button sureBtn;
    OnSureListener OnsureListener;

    public void setSureListener(OnSureListener OnsureListener) {  //设置回调接口
        this.OnsureListener = OnsureListener;
    }

    public liuyanDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  //创建对话框
        setContentView(R.layout.liuyanhole);  //设置对话框显示
        et=findViewById(R.id.beizhu_et);
        cancleBtn=findViewById((R.id.liuyan_btn_cancel));
        sureBtn=findViewById((R.id.liuyan_btn_sure));
        cancleBtn.setOnClickListener(this);
        sureBtn.setOnClickListener(this);
    }
    public interface OnSureListener {
        public void OnSure();  //接口定义确定方法
    }
    @Override
    public void onClick(View view) {   //若为取消着直接取消，若为确定则调用接口执行确定的函数
        switch (view.getId()){
            case R.id.liuyan_btn_cancel:
                cancel();
                break;
            case R.id.liuyan_btn_sure:
                if(OnsureListener!=null){
                    OnsureListener.OnSure();
                }
                break;
        }
    }

    //获取备注的书写的数据 方法
    public String getEditText(){
        return et.getText().toString().trim();  //trim去掉了没用的空格和回车
    }

}
