package com.jnu.jcircle.ui.hole;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.jnu.jcircle.ui.hole.Adapter.AccountAdapter;
import com.jnu.jcircle.ui.hole.Pages.AccountBean;
import com.jnu.jcircle.R;
import com.jnu.jcircle.ui.hole.Pages.DBmanager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HoleFragment extends Fragment implements View.OnClickListener{
    //注册对象
    ListView mainlistview;//主页留言情况
    List<AccountBean> mDatas; //数据源
    private AccountAdapter accountAdapter;  //适配器
    int year,month,day;
    ImageButton addBtn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=View.inflate(getActivity(),R.layout.activity_holemain,null);

        initTime();       //获取时间
        mainlistview=view.findViewById(R.id.list_main);
        addBtn=view.findViewById(R.id.add_button_main);
        mDatas=new ArrayList<>();
        //设置适配器，加载数据到主页面ListView中
        accountAdapter = new AccountAdapter(getActivity(),mDatas);
        mainlistview.setAdapter(accountAdapter);   //引入数据源适配器在Listview的数据源中
        addBtn.setOnClickListener(this);

        AccountBean bean=new AccountBean();
        bean.setCaiFocus(false);
        bean.setZanFocus(false);
        return view;
    }

    //获取焦点就加载
    public void onResume(){
        super.onResume();
        loadDBdata();
    }

    private void loadDBdata() {
        List<AccountBean>list = DBmanager.getDayAccountFromtb(year, month, day);
        mDatas.clear();
        mDatas.addAll(list);
        accountAdapter.notifyDataSetChanged();

    }

    //获取今日时间
    private void initTime() {
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        day=calendar.get(Calendar.DAY_OF_MONTH);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){     //点击添加  使用Intent连接其他界面，点击添加后跳转到记录界面
            case R.id.add_button_main:
                Intent itl = new Intent(getActivity(),PagerFragment.class);
                startActivity(itl);
                break;
        }

    }
}