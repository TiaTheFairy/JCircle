package com.jnu.jcircle.ui.user;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.jnu.jcircle.R;

public class Edit_id extends AppCompatActivity {

    public static final int Result_edit=66;
    public static final int Result_choice=68;
    ActivityResultLauncher<Intent> launcherEdit = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {       //响应输入新的姓名和ID，显示在个人信息界面内并保存
            Intent data = result.getData();
            int resultCode = result.getResultCode();
            if (resultCode ==Result_edit) {
                if (null == data) return;
                TextView name1=(TextView) findViewById(R.id.TextDate_name);
                TextView id1=(TextView) findViewById(R.id.TextDate_id);
                String name = data.getStringExtra("name");
                String id = data.getStringExtra("id");
                name1.setText(name);
                id1.setText(id);
                Toast.makeText(Edit_id.this.getBaseContext(), "修改成功", Toast.LENGTH_LONG).show();
            }
        }
    });

    ActivityResultLauncher<Intent> launcherChoice = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        int picture;
        public void onActivityResult(ActivityResult result) {        //响应更改头像，显示在个人信息界面内并保存
            Intent data = result.getData();
            int resultCode = result.getResultCode();
            if (resultCode ==Result_choice) {
                if (null == data) return;
                picture=data.getIntExtra("picture",0);
                ImageView aa=findViewById(R.id.imageView_head);
                Toast.makeText(Edit_id.this.getBaseContext(),"picture", Toast.LENGTH_LONG);
                aa.setImageResource(picture);
                saveData2();
            }
        }
        public void saveData2(){
            SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
            editor.putInt("picture",picture);
            editor.apply();
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        readData();
        Button buttonOk=findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {            //点击修改后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.TextDate_name);
                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", "原ID："+idView.getText().toString());
                intent.putExtra("name","原昵称："+nameView.getText().toString());
                launcherEdit.launch(intent);

            }

        });
        Button buttonCancel=this.findViewById(R.id.button_not);
        buttonCancel.setOnClickListener(new View.OnClickListener() {       //点击确定按钮后保存数据
            @Override
            public void onClick(View v) {
                saveData();
                setResult(0);
                Toast.makeText(Edit_id.this, "信息无误", Toast.LENGTH_LONG).show();
                Edit_id.this.finish();
            }
        });
        ImageView head=this.findViewById(R.id.imageView_head);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4;
                intent4=new Intent(Edit_id.this.getBaseContext(),head_choise.class);
                launcherChoice.launch(intent4);
            }
        });
        }
    public void saveData() {//保存数据在本文件内
        TextView names=(TextView) findViewById(R.id.TextDate_name);
        TextView ids=(TextView) findViewById(R.id.TextDate_id);
        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name",names.getText().toString());
        editor.putString("id",ids.getText().toString());
        editor.apply();
    }
    public void readData(){//读出之前保存的数据
        TextView names=(TextView) findViewById(R.id.TextDate_name);
        TextView ids=(TextView) findViewById(R.id.TextDate_id);
        ImageView images=(ImageView)findViewById(R.id.imageView_head);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        String name = pref.getString("name","请输入");
        String id = pref.getString("id","请输入");
        int picture =pref.getInt("picture",R.drawable.a4);
        names.setText(name);
        ids.setText(id);
        images.setImageResource(picture);
    }
    }
