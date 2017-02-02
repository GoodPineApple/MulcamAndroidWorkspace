package com.example.student.test25_naver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EditText editKeyword;
    private Button btnSearch;
    private ListView listViewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editKeyword = (EditText) findViewById(R.id.edit_keyword);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listViewBook = (ListView) findViewById(R.id.listview_book);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = editKeyword.getText()+"";
                NaverBookThread t =
                        new NaverBookThread(null,keyword);
                t.start();
            }
        });
    }
}








