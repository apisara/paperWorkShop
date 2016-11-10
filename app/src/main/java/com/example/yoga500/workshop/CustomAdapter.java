package com.example.yoga500.workshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by YOGA500 on 11/10/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context mContext;
    String[] topic;
    String[] date;
    int[] imgId;
    ViewHolder myHolder = null;


    public CustomAdapter(Context context, String[] topic, int[] imgId, String[] date) {
        this.mContext = context;
        this.topic = topic;
        this.date = date;
        this.imgId = imgId;
    }

    @Override
    public int getCount() {
        return topic.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        myHolder = new ViewHolder();
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.activity_menulist, null);
            myHolder.tvTopic = (TextView) convertView.findViewById(R.id.tvTopic);
            myHolder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            myHolder.imgID = (ImageView) convertView.findViewById(R.id.imgDetail);

            convertView.setTag(myHolder);
        }else {
            //คือช่วงที่ convert View ผ่านกาน Scroll มาแล้ว
            //restore ข้อมูลสถานะการทำงาน
            myHolder = (ViewHolder) convertView.getTag();
        }

        //ต้อง set ค่าที่จะนำมาแสดงผล
        myHolder.tvTopic.setText(topic[position]);
        myHolder.tvDate.setText(date[position]);
        myHolder.imgID.setImageResource(imgId[position]);
        return convertView;
    }
    public class ViewHolder {
        //ประกาศภายใน view มี widget อะไรบ้าง
        TextView tvTopic;
        TextView tvDate;
        ImageView imgID;
    }
}
