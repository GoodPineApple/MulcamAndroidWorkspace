package com.example.taemi.test11_callbook_pineapple;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import com.example.taemi.test11_callbook_pineapple.vo.Person;

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
        personList = new ArrayList<>();

        for(int i=0; i<10; i++){
            Person person = new Person();
            person.setContactName("Pineapple"+i);
            person.setPhoneNum("010-1234-123"+i);
            personList.add(person);
        }



    }
}
