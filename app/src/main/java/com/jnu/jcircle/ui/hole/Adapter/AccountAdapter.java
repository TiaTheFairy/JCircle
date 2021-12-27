package com.jnu.jcircle.ui.hole.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnu.jcircle.ui.hole.AnimationTools;
import com.jnu.jcircle.ui.hole.HoleFragment;
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
        final Viewholder viewholder;
        AccountBean bean=mDatas.get(position);
        if(view==null){
            view=inflater.inflate(R.layout.item_holemain,viewGroup,false);
            viewholder=new Viewholder(view);

            /////////
            viewholder.dianzhaniv=(ImageView)view.findViewById(R.id.dianzhaniv);
            viewholder.caiiv=(ImageView)view.findViewById(R.id.caiiv);
            viewholder.dianzhantv=(TextView)view.findViewById(R.id.dianzhantv);
            viewholder.caitv=(TextView)view.findViewById(R.id.caitv);
            ///////

            view.setTag(viewholder);
        }
        else {
            viewholder=(Viewholder) view.getTag();
        }
        //从数据库拿资源
        viewholder.typeImageview.setImageResource(bean.getSimageId());
        viewholder.typeTextview.setText(bean.getName());
        viewholder.liuyanTextview.setText(bean.getLiuyan());
        viewholder.timeTextview.setText(bean.getTime());
        //////////

        if(bean.isZanFocus()){
            viewholder.dianzhaniv.setImageResource(R.mipmap.dianzanred);
        }else {
            viewholder.dianzhaniv.setImageResource(R.mipmap.dianzan);
        }
        if(bean.isCaiFocus()){
            viewholder.caiiv.setImageResource(R.mipmap.caired);
        }else {
            viewholder.caiiv.setImageResource(R.mipmap.cai);
        }

        viewholder.dianzhaniv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag= bean.isZanFocus();
                bean.setZanFocus(!flag);
                if(bean.isCaiFocus()){
                    bean.setCaiFocus(flag);
                }
                notifyDataSetChanged();
                AnimationTools.scale(viewholder.dianzhaniv);
            }
        });
        viewholder.dianzhantv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag= bean.isZanFocus();
                bean.setZanFocus(!flag);
                if(bean.isCaiFocus()){
                    bean.setCaiFocus(flag);
                }
                notifyDataSetChanged();
                AnimationTools.scale(viewholder.dianzhaniv);
            }
        });


        viewholder.caiiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag= bean.isCaiFocus();
                bean.setCaiFocus(!flag);
                if(bean.isZanFocus()){
                    bean.setZanFocus(flag);
                }
                notifyDataSetChanged();
                AnimationTools.scale(viewholder.caiiv);
            }
        });
        viewholder.caitv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag= bean.isCaiFocus();
                bean.setCaiFocus(!flag);
                if(bean.isZanFocus()){
                    bean.setZanFocus(flag);
                }
                notifyDataSetChanged();
                AnimationTools.scale(viewholder.caiiv);
            }
        });

        /////////
        return view;
    }


    class Viewholder{
         //传入布局Listview的每一个对象
        ImageView typeImageview,dianzhaniv,caiiv;
        TextView typeTextview,liuyanTextview,timeTextview,dianzhantv,caitv;
        public Viewholder(View view){
            typeImageview=view.findViewById(R.id.item_mainlist_image);
            typeTextview=view.findViewById(R.id.item_mainlist_title);
            liuyanTextview=view.findViewById(R.id.item_mainlist_liuyan);
            timeTextview=view.findViewById(R.id.item_mainlist_time);
        }
    }

}


