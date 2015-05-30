package com.example.harshitha.contacts_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity mainActivity, String[] contactNameList, int[] contactImages) {
            result=contactNameList;
            context=mainActivity;
            imageId=contactImages;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

    public class Holder
        {
            TextView tv;
            ImageView img;
        }


    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;

    }

    @Override
    public long getItemId(int position) {
        return position;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View eachRow;
        eachRow = inflater.inflate(R.layout.custom_list,parent,false);
        holder.tv=(TextView) eachRow.findViewById(R.id.textView);
        holder.img=(ImageView) eachRow.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);
        return eachRow;
    }
}
