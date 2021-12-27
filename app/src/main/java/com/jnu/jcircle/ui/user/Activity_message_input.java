package com.jnu.jcircle.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jnu.jcircle.R;

public class Activity_message_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_input);

        Intent intent2=getIntent();
        EditText editName = (EditText) findViewById(R.id.input_name);
        EditText editId = (EditText) findViewById(R.id.input_id);//获取姓名和ID的初始值
        EditText editSex = (EditText) findViewById(R.id.input_sex);
        EditText editAge = (EditText) findViewById(R.id.input_age);
        EditText editXinZuo = (EditText) findViewById(R.id.input_xinZuo);

        String name1= intent2.getStringExtra("name");
        String id1=intent2.getStringExtra("id");
        String sex1=intent2.getStringExtra("sex");
        String age1=intent2.getStringExtra("age");
        String xinZuo1=intent2.getStringExtra("xinZuo");

        if(null!=name1){
            editName.setText(name1);
            editId.setText(id1);
            editSex.setText(sex1);
            editAge.setText(age1);
            editXinZuo.setText(xinZuo1);
        }

        Button buttonOk=this.findViewById(R.id.button_ook);
        buttonOk.setOnClickListener(new View.OnClickListener() {        //点击确定就保存新输入的数据
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                    intent.putExtra("name", editName.getText().toString());
                    intent.putExtra("id", editId.getText().toString());
                intent.putExtra("sex", editSex.getText().toString());
                intent.putExtra("age", editAge.getText().toString());
                intent.putExtra("xinZuo", editXinZuo.getText().toString());
                setResult(com.jnu.jcircle.ui.user.Edit_id.Result_edit,intent);
                Activity_message_input.this.finish();
            }
        });
        Button buttonCancel=this.findViewById(R.id.button_cancel);      //点击取消什么也不做，返回
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(0);
                Toast.makeText(Activity_message_input.this, "操作已取消", Toast.LENGTH_LONG).show();
                Activity_message_input.this.finish();
            }
        });
    }
}