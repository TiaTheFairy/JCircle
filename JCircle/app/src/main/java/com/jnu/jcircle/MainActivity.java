package com.jnu.jcircle;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.jnu.jcircle.databinding.ActivityMainBinding;
import com.jnu.jcircle.ui.login.LoginActivity;
import com.jnu.jcircle.ui.user.Edit_id;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);//navview是地下的导航栏
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(    //configuration是fragment显示的内容
                R.id.navigation_trade, R.id.navigation_hole, R.id.navigation_news)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);   //mainactivity的fragment就是controler
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);  //将上面的fragment（controler）与下方的导航栏联系
        NavigationUI.setupWithNavController(binding.navView, navController);
        //-------------------------------------启动fragment---------------------------------------------------------------------------------

    }


 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);      //创建右上角溢出菜单（三个点点开的菜单）
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_id:        //响应点击右上角菜单第一个按钮跳转到个人信息界面
                Intent intent=new Intent();
                intent.setClass(MainActivity.this.getBaseContext(),Edit_id.class);
                startActivity(intent);
                return true;
            case R.id.action_log_out:   //响应点击右上角菜单第二个按钮直接退出程序
                android.os.Process.killProcess(android.os.Process.myPid());
            case R.id.action_log_in:
                Intent intent2=new Intent();
                intent2.setClass(MainActivity.this.getBaseContext(), LoginActivity.class);
                startActivity(intent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}