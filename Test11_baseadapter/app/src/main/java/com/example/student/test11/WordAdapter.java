package com.example.student.test11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by student on 2017-01-16.
 */

public class WordAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private String[] values;

    public WordAdapter
            (Context context, int itemLayout, String[] values){
        this.context = context;
        this.itemLayout = itemLayout;
        this.values = values;
    }
////////////////////////////////////////////////////////////
    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
///////////////////////////////////////////////////////////
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService
                        (Context.LAYOUT_INFLATER_SERVICE);

        // my_item.xml 파일 팽창
        View myItem = inflater.inflate(itemLayout,parent,false);

        ImageView imageItem =
                (ImageView) myItem.findViewById(R.id.image_item);
        TextView textItem =
                (TextView) myItem.findViewById(R.id.text_item);

        textItem.setText(values[position]);

        return myItem;
    }
}





