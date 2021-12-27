package com.jnu.jcircle.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jnu.jcircle.MainActivity;
import com.jnu.jcircle.R;
import com.jnu.jcircle.data.saver_users;

public class userlogin extends AppCompatActivity {

    private ImageView login_pic;
    private EditText  login_userPhone;
    private EditText login_password;
    private CheckBox login_eula;
    private TextView login_view;
    private ImageView login_next;
    private ImageView login_reset;
    private LinearLayout login_IDLine;
    private LinearLayout login_passwordLine;
    private LinearLayout login_eulaLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        login_pic = findViewById(R.id.login_pic);
        login_userPhone = findViewById(R.id.login_userPhone);
        login_password = findViewById(R.id.login_userPassword);
        login_eula = findViewById(R.id.login_accept);
        login_view = findViewById(R.id.login_eula);
        login_next = findViewById(R.id.login_next);
        login_reset = findViewById(R.id.login_reset);
        login_IDLine = findViewById(R.id.login_IDLine);
        login_passwordLine = findViewById(R.id.login_passwordLine);
        login_eulaLine = findViewById(R.id.login_eulaLine);

        login_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(login_passwordLine.getVisibility() == View.INVISIBLE){
                    if("0".equals(login_userPhone.getText().toString())){
                        Intent intent = new Intent(userlogin.this, MainActivity.class);
                        startActivity(intent);
                    }

                    if(login_userPhone.getText().toString().length() != 11){
                        Toast.makeText(userlogin.this, R.string.login_enterPhone, Toast.LENGTH_SHORT).show();
                        return;
                    }
                    else if(!(saver_users.mapPhone.containsValue(login_userPhone.getText().toString()))){
                        login_eulaLine.setVisibility(View.VISIBLE);
                    }
                    login_userPhone.setFocusable(false);
                    login_passwordLine.setVisibility(View.VISIBLE);
                }

                else{
                    if("".equals(login_password.getText().toString())){
                        Toast.makeText(userlogin.this, R.string.login_enterPassword, Toast.LENGTH_SHORT).show();
                    }

                    else{
                        if(login_eulaLine.getVisibility() == View.VISIBLE){
                            if(login_eula.isChecked()){
                                int idKey;
                                while(true) {
                                    idKey = 100 + (int) Math.random() * 900;
                                    if(!(saver_users.mapPhone.containsKey(idKey))) {
                                        break;
                                    }
                                }
                                saver_users.users.setUserID(0);
                                saver_users.users.setUserPassword(login_password.getText().toString());
                                saver_users.users.setUserName("");
                                saver_users.users.setUserPhone(login_userPhone.getText().toString());
                                saver_users.users.setUserPic("");
                                saver_users.users.setUserReal("");
                                saver_users.mapPhone.put(idKey, login_userPhone.getText().toString());
                                saver_users.mapPassword.put(idKey, login_password.getText().toString());

                                try {
                                    Thread.sleep(500);
                                }catch (Exception e) {

                                }
                                Intent intent = new Intent(userlogin.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(userlogin.this, R.string.login_acceptEULA, Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            if((saver_users.mapPassword.get(getHashKey(login_userPhone.getText().toString()))).equals(login_password.getText().toString())){
                                try {
                                    Thread.sleep(500);
                                }catch (Exception e) {

                                }
                                Intent intent = new Intent(userlogin.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(userlogin.this, R.string.login_wrongPassword, Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });

        login_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_userPhone.setText("");
                login_userPhone.setFocusable(true);
                login_password.setText("");
                login_passwordLine.setVisibility(View.INVISIBLE);
                login_eulaLine.setVisibility(View.INVISIBLE);
                login_eula.setChecked(true);
            }
        });

        login_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userlogin.this, eula.class);
                startActivity(intent);
            }
        });
    }

    public int getHashKey(String phone){
        int key = 0;
        for(int getKey: saver_users.mapPhone.keySet()){
            if(saver_users.mapPhone.get(getKey).equals(phone)){
                key = getKey;
            }
        }
        return key;
    }
}