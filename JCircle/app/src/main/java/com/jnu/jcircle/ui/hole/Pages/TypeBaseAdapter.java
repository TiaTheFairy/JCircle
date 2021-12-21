package com.jnu.jcircle.ui.hole.Pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnu.jcircle.R;

import java.util.List;


public class TypeBaseAdapter extends BaseAdapter {
    Context context;
    List<TypeBean> mDatas;  //数据源，通过构造方法传递
    int selectPos=0;    //选中的位置

    public TypeBaseAdapter(Context context, List<TypeBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override   //重写适配器4个方法
    public int getCount() {
        return mDatas.size();     //返回集合长度
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);  //返回指定位置的数据源
    }

    @Override
    public long getItemId(int position) {
        return position;   //返回位置
    }

    @Override  //不考虑复用问题
    public View getView(int position,View convertView,ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.fragment_holegridview,parent,false);
        //查找布局控件
        ImageView iv=convertView.findViewById(R.id.item_grid_iv);
        TextView tv=convertView.findViewById(R.id.item_grid_tv);
        //获取数据源
        TypeBean typeBean=mDatas.get(position);   //TypeBean类重新定义的方法
        tv.setText(typeBean.getName());
        if(selectPos==position){
            iv.setImageResource(typeBean.getSimageId());  //如果选中，用选中的图片id和图
        }
        else{
            iv.setImageResource((typeBean.getWimageId())); //如果选中，用未被选中的图片id和图
        }
        return convertView;
    }

}
