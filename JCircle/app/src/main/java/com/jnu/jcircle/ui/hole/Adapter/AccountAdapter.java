package com.jnu.jcircle.ui.hole.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnu.jcircle.ui.hole.Pages.AccountBean;
import com.jnu.jcircle.R;
import java.util.Calendar;
import java.util.List;

public class AccountAdapter extends BaseAdapter {
    Context context;  //传入上下文对象
    List<AccountBean> mDatas;  //传入数据源
    LayoutInflater inflater;  //加载布局
    int year,month,day;   //设定年月日

    public AccountAdapter(Context context, List<AccountBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater= LayoutInflater.from(context);//不用每次都调用
        Calendar calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH)+1;
        day=calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;  //返回指令位置
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Viewholder viewholder=null;
        if(view==null){
            view=inflater.inflate(R.layout.item_holemain,viewGroup,false);
            viewholder=new Viewholder(view);

            //
            viewholder.dianzhan=(Button) view.findViewById(R.id.dianzhan) ;
            viewholder.cai=(Button) view.findViewById(R.id.cai);
            //

            view.setTag(viewholder);
        }
        else {
            viewholder=(Viewholder) view.getTag();

            viewholder.dianzhan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("aaa");
                }
            });
            viewholder.cai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TO-DO Something
                }
            });
        }

        //从数据库拿资源
        AccountBean bean=mDatas.get(position);
        viewholder.typeImageview.setImageResource(bean.getSimageId());
        viewholder.typeTextview.setText(bean.getName());
        viewholder.liuyanTextview.setText(bean.getLiuyan());
        viewholder.timeTextview.setText(bean.getTime());
        return view;
    }
    class Viewholder{  //传入布局Listview的每一个对象
        ImageView typeImageview;
        Button dianzhan,cai;
        TextView typeTextview,liuyanTextview,timeTextview;
        public Viewholder(View view){
            typeImageview=view.findViewById(R.id.item_mainlist_image);
            typeTextview=view.findViewById(R.id.item_mainlist_title);
            liuyanTextview=view.findViewById(R.id.item_mainlist_liuyan);
            timeTextview=view.findViewById(R.id.item_mainlist_time);
            dianzhan=view.findViewById(R.id.dianzhan);
            cai=view.findViewById(R.id.cai);
        }
    }
}
