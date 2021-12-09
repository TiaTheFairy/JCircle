package com.jnu.jcircle.ui.user;

import static com.jnu.jcircle.ui.user.Edit_id.Result_choice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.jnu.jcircle.R;

public class head_choise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_choise);

        Intent intent2=getIntent();
        ImageView a1=findViewById(R.id.imageView_a1);
        ImageView a2=findViewById(R.id.imageView_a2);
        ImageView a3=findViewById(R.id.imageView_a3);
        ImageView a4=findViewById(R.id.imageView_a4);
        ImageView a5=findViewById(R.id.imageView_a5);
        ImageView a6=findViewById(R.id.imageView_a6);
        ImageView a7=findViewById(R.id.imageView_a7);
        ImageView a8=findViewById(R.id.imageView_a8);
        ImageView a9=findViewById(R.id.imageView_a9);
        ImageView a10=findViewById(R.id.imageView_a10);
        ImageView a11=findViewById(R.id.imageView_a11);
        ImageView a12=findViewById(R.id.imageView_a12);

//以下对每一个图片点击响应，返回图片的值
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a3);
                setResult(Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a4);
                setResult(Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a6);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a12);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a5);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a2);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a1);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a11);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a7);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a9);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a8);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });
        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.putExtra("picture",R.drawable.a10);
                setResult(Edit_id.Result_choice,intent);
                head_choise.this.finish();
            }
        });

    }
}