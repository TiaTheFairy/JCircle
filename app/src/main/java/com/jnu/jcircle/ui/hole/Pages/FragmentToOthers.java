package com.jnu.jcircle.ui.hole.Pages;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jnu.jcircle.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class FragmentToOthers extends Fragment implements  View.OnClickListener {
    //一切会变化的量都先初始化对象,根据视图从上到下
    ImageView typeImageview;
    TextView typeTextview;
    GridView typeGridview;
    TextView liuyanTextview;
    TextView sureTextview;
    TextView timeTextview;
    List<TypeBean> typeList;
    private TypeBaseAdapter adapter;
    AccountBean accountBean;   //在键盘点击确定后，将需要的数据全部用对象形式保存

    @Override  //设定未点击时的默认值
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountBean = new AccountBean();//创建对象
        accountBean.setName("路人0");
        accountBean.setSimageId(R.mipmap.rw); //默认图片，动态的
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_holetoothers, container, false);
        initView(view); //将view写入
        setInittime();
        //在数据库完善后，为gridview填写数据
        loadDataToGirdview();
        setGridviewListener();
        return view;
    }

    //gridview点击事件
    private void setGridviewListener() {
        typeGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.selectPos = position;
                adapter.notifyDataSetInvalidated();//提示点击时发生变化,点击到的元素颜色改变
                TypeBean typeBean = typeList.get(position); //得到点击对象
                String name = typeBean.getName();  //通过点击对象改变左上为对应的名字和图
                typeTextview.setText(name);
                int simageId = typeBean.getSimageId();
                typeImageview.setImageResource(simageId);
                //点击时，同时改变数据库预存对象的名和图
                accountBean.setName(name);
                accountBean.setSimageId(simageId);
            }
        });
    }
    private void loadDataToGirdview() {
        typeList = new ArrayList<>();
        adapter = new TypeBaseAdapter(getContext(), typeList);
        typeGridview.setAdapter(adapter);    //引入适配器
        //获取数据库的数据源
        List<TypeBean> othersList = DBmanager.getTypeList(0);  //toothers
        typeList.addAll(othersList);
        adapter.notifyDataSetChanged();
    }

    //设置初始化时间，获取时间以显示timetextview
    private void setInittime() {
        Date date = new Date();
        SimpleDateFormat nowTime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");//设置格式,格式为固定搭配
        String time = nowTime.format(date);
        timeTextview.setText(time);   //传入显示
        accountBean.setTime(time);     //传入数据库

        Calendar caleder = Calendar.getInstance();//设置日历对象
        int year = caleder.get(Calendar.YEAR);
        int mouth = caleder.get(Calendar.MONTH) + 1;  //比实际月份少了1所以+1
        int day = caleder.get(Calendar.DAY_OF_MONTH);
        //传入数据库
        accountBean.setYear(year);
        accountBean.setMonth(mouth);
        accountBean.setDay(day);
    }

    private void initView(View view) {
        typeImageview = view.findViewById(R.id.toothers_image);
        typeTextview = view.findViewById(R.id.toothers_name);
        typeGridview = view.findViewById(R.id.toothers_gridview);
        liuyanTextview = view.findViewById(R.id.toothers_liuyan_tv);
        timeTextview = view.findViewById(R.id.toothers_time_tv);
        sureTextview=view.findViewById(R.id.toothers_sure_tv);
        liuyanTextview.setOnClickListener(this);
        sureTextview.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.toothers_sure_tv: //点击了确认后，保存数据，获取数据，返回上级页面
                saveAccountToDB();
                getActivity().finish();//返回上级
                break;
            case R.id.toothers_liuyan_tv:
                //点击确定，弹出备注对话框
                showbzDialog();
                break;
        }
    }


    private void saveAccountToDB() {
        accountBean.setFlag(0);
        DBmanager.insertItemToAccounttb(accountBean);
    }


    private void showbzDialog() {
        liuyanDialog lydialog = new liuyanDialog(getContext());
        lydialog.show();
        lydialog.setSureListener(new liuyanDialog.OnSureListener() {
            @Override
            public void OnSure() {
                String msg=lydialog.getEditText();
                //判断是否为空不为控制则添加
                if(!TextUtils.isEmpty(msg)){
                    liuyanTextview.setText(msg); //显示
                    accountBean.setLiuyan(msg);  //数据库
                }
                lydialog.cancel();
            }
        });
    }
}
