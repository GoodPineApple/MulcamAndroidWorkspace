package com.example.taemi.test11_callbook_pineapple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taemi.test11_callbook_pineapple.vo.Person;

import java.util.List;

/**
 * Created by taemi on 2017-01-17.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private List<Person> personList;

    public ContactAdapter(Context context, int itemLayout, List<Person> personList) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonHolder holder;

        if(convertView == null){

        } else {

        }

        return null;
    }

    private class PersonHolder{
        ImageView imgPerson;
        TextView textName;
        TextView textPhone;
        Button btnCall;
        Button btnSms;
    }
}
