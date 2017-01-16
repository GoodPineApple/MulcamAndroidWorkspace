package com.example.taemi.test11_callbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taemi.test11_callbook.vo.Person;

import java.util.List;

/**
 * Created by taemi on 2017-01-16.
 */

public class ContactAdapter extends BaseAdapter {
    private Context context;
    private int itemLayout;
    private List<Person> contactList;

    public ContactAdapter(Context context, int itemLayout, List<Person> contactList) {
        this.context = context;
        this.itemLayout = itemLayout;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonHolder holder;

        // convertView가 null이면 getView가 최초로 실행된거임.
        // viewHolder 패턴.
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(itemLayout,parent,false);
            holder = new PersonHolder();
            holder.imgPerson = (ImageView) convertView.findViewById(R.id.image_contact);
            holder.textName = (TextView) convertView.findViewById(R.id.text_namee);
            holder.textPhone = (TextView) convertView.findViewById(R.id.text_phone);
            holder.btnCall = (Button) convertView.findViewById(R.id.btn_call);
            holder.btnSms = (Button) convertView.findViewById(R.id.btn_sms);
            convertView.setTag(holder);
        } else {
            holder = (PersonHolder) convertView.getTag();
        }
        final Person person = contactList.get(position);
        holder.textName.setText(person.getContactName());
        holder.textPhone.setText(person.getPhoneNum());

        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "전화걸기 : " + person.getPhoneNum(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "문자 : " + person.getPhoneNum(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    //inflate 작업 효율을 위해 사용하는 내부 클래스(holder)
    private class PersonHolder{
        ImageView imgPerson;
        TextView textName;
        TextView textPhone;
        Button btnCall;
        Button btnSms;
    }

}
