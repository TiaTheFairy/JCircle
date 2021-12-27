package com.jnu.jcircle.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jnu.jcircle.R;

import java.util.List;

public class ListAdapter extends BaseAdapter{
    List<announceList> mList;
    //public ListAdapter( List<announceList> list)
    //{
    //    mList=list;
    //}

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=mLayoutInflater.inflate(R.layout.list_item,null);
        announceList item=mList.get(position);
        TextView uName=view.findViewById(R.id.uName);
        TextView title=view.findViewById(R.id.title);
        TextView details=view.findViewById(R.id.details);
        TextView date=view.findViewById(R.id.date);
        ImageView picture=view.findViewById(R.id.R_picture);

        uName.setText(mList.get(position).getUName());
        title.setText(mList.get(position).getTitle());
        details.setText(mList.get(position).getDetails());
        date.setText(mList.get(position).getDate());
        String TitleStr=mList.get(position).getTitle();
        switch (TitleStr){
            case "紧急提醒":
                picture.setImageResource(R.drawable.rpicture1);
                break;
            case "欢度元旦":
                picture.setImageResource(R.drawable.rpicture2);
                break;
            case "诚信考试":
                picture.setImageResource(R.drawable.rpicture3);
                break;
            case "放假通知":
                picture.setImageResource(R.drawable.rpicture4);
                break;
        }
        return view;

    }

    private List<announceList>getmList;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(Context context,List<announceList>list)
    {
        mList=list;
        mLayoutInflater=LayoutInflater.from(context);
    }
}
