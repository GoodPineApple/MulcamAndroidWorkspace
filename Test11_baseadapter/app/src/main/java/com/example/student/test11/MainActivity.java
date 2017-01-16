package com.example.student.test11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);

        int itemLayout = R.layout.my_item;

        String[] words = {"Yang", "Java", "Android","Apple"
                        ,"Banana","Tomato", "Orange", "Meat"
                        ,"Water", "Jsp", "iPhone", "Google"
                        ,"AAA" ,"BBB" ,"CCC" ,"DDD"};

    // Adapter 객체에는 Context, 아이템 레이아웃, 데이터셋이 필요함.
        WordAdapter adapter =
                new WordAdapter(this,itemLayout,words);

        // 생성한 Adapter 객체를 listview에 장착
        listView.setAdapter(adapter);
    }
}


