package com.example.taemi.test11_callbook;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.taemi.test11_callbook.vo.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private ListView listView;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btn_add);
        listView = (ListView) findViewById(R.id.listview_contacts);

        // This is sample data;
        personList = new ArrayList<>();
        for(int i=0; i<10; i++){
            Person person = new Person();
            person.setContactName("sample"+i);
            person.setPhoneNum("010-7845-123"+i);
            personList.add(person);
        }

        final ContactAdapter adapter = new ContactAdapter(this,R.layout.items_layout,personList);
        listView.setAdapter(adapter);
//////////////////////////////////////////////////////////////////////////////////////////////
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("삭제 확인 대화상자").setMessage("해당 연락처를 정말 삭제하시겠습니까?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                personList.remove(position);
                                adapter.notifyDataSetChanged();
                                dialog.cancel();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })
                        .create().show();
                return true;
            }
        });

///////////////////////////////////////////////////////////////////////////////////////////////
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.dialog_add);

                final EditText editDialogName = (EditText) dialog.findViewById(R.id.edit_dialog_name);
                final EditText editDialogPhone = (EditText) dialog.findViewById(R.id.edit_dialog_phone);
                Button btnDialogSubmit = (Button) dialog.findViewById(R.id.btn_dialog_submit);
                Button btnDialogCancle = (Button) dialog.findViewById(R.id.btn_dialog_cancle);

                btnDialogSubmit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Person person = new Person();
                        person.setContactName(editDialogName.getText()+"");
                        person.setPhoneNum(editDialogPhone.getText()+"");
                        personList.add(person);
                        adapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });

                btnDialogCancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });

    }

}
