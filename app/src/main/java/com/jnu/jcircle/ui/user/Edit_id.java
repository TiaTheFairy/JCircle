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
                TextView name1=(TextView) findViewById(R.id.textDate_name);
                TextView id1=(TextView) findViewById(R.id.TextDate_id);
                TextView sex1=(TextView) findViewById(R.id.TextDate_sex);
                TextView age1=(TextView) findViewById(R.id.TextDate_age);
                TextView xinZuo1=(TextView) findViewById(R.id.TextDate_xinZuo);
                String name = data.getStringExtra("name");
                String id = data.getStringExtra("id");
                String sex = data.getStringExtra("sex");
                String age = data.getStringExtra("age");
                String xinZuo = data.getStringExtra("xinZuo");

                name1.setText(name);
                id1.setText(id);
                sex1.setText(sex);
                age1.setText(age);
                xinZuo1.setText(xinZuo);
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
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);
                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());

                launcherEdit.launch(intent);

            }

        });
        TextView textName=findViewById(R.id.textDate_name);
        textName.setOnClickListener(new View.OnClickListener() {            //点击name后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);

                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());


                launcherEdit.launch(intent);

            }

        });
        TextView textId=findViewById(R.id.TextDate_id);
        textId.setOnClickListener(new View.OnClickListener() {            //点击name后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);
                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());

                launcherEdit.launch(intent);

            }

        });
        TextView textSex=findViewById(R.id.TextDate_sex);
        textSex.setOnClickListener(new View.OnClickListener() {            //点击name后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);

                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());


                launcherEdit.launch(intent);

            }

        });
        TextView textAge=findViewById(R.id.TextDate_age);
        textAge.setOnClickListener(new View.OnClickListener() {            //点击name后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);

                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());


                launcherEdit.launch(intent);

            }

        });
        TextView textXin=findViewById(R.id.TextDate_xinZuo);
        textXin.setOnClickListener(new View.OnClickListener() {            //点击name后进入修改界面并把原来的信息传过去
            @Override
            public void onClick(View v) {
                Intent intent;
                TextView idView=(TextView) findViewById(R.id.TextDate_id);
                TextView nameView=(TextView) findViewById(R.id.textDate_name);
                TextView sexView=(TextView) findViewById(R.id.TextDate_sex);
                TextView ageView=(TextView) findViewById(R.id.TextDate_age);
                TextView xinView=(TextView) findViewById(R.id.TextDate_xinZuo);

                intent=new Intent(Edit_id.this.getBaseContext(),Activity_message_input.class);
                intent.putExtra("id", idView.getText().toString());
                intent.putExtra("name",nameView.getText().toString());
                intent.putExtra("sex",sexView.getText().toString());
                intent.putExtra("age",ageView.getText().toString());
                intent.putExtra("xinZuo",xinView.getText().toString());

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
        TextView names=(TextView) findViewById(R.id.textDate_name);
        TextView ids=(TextView) findViewById(R.id.TextDate_id);
        TextView sex=(TextView) findViewById(R.id.TextDate_sex);
        TextView age=(TextView) findViewById(R.id.TextDate_age);
        TextView xinZuo=(TextView) findViewById(R.id.TextDate_xinZuo);

        SharedPreferences.Editor editor = getSharedPreferences("data",MODE_PRIVATE).edit();
        editor.putString("name",names.getText().toString());
        editor.putString("id",ids.getText().toString());
        editor.putString("sex",sex.getText().toString());
        editor.putString("age",age.getText().toString());
        editor.putString("xinZuo",xinZuo.getText().toString());

        editor.apply();
    }
    public void readData(){//读出之前保存的数据
        TextView names=(TextView) findViewById(R.id.textDate_name);
        TextView ids=(TextView) findViewById(R.id.TextDate_id);
        TextView sex1=(TextView) findViewById(R.id.TextDate_sex);
        TextView age1=(TextView) findViewById(R.id.TextDate_age);
        TextView xinZuo1=(TextView) findViewById(R.id.TextDate_xinZuo);
        ImageView images=(ImageView)findViewById(R.id.imageView_head);
        SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
        String name = pref.getString("name","请输入");
        String id = pref.getString("id","2019000000");
        String sex = pref.getString("sex","你猜！");
        String age = pref.getString("age","18");
        String xinZuo = pref.getString("xinZuo","肉做的");

        int picture =pref.getInt("picture",R.drawable.a4);

        names.setText(name);
        ids.setText(id);
        sex1.setText(sex);
        age1.setText(age);
        xinZuo1.setText(xinZuo);
        images.setImageResource(picture);
    }
    }
