package com.example.student.test25_naver;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.student.test25_naver.vo.BookVO;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private EditText editKeyword;
    private Button btnSearch;
    private ListView listViewBook;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // NaverBookThread가 작업을 끝내고 메세지를 보내면
            // 이 메소드가 실행됨.
            bookVOList.clear();
            bookVOList.addAll((List<BookVO>)msg.obj);
            adapter.notifyDataSetChanged();
        }
    };

    private BookListAdapter adapter;
    private List<BookVO> bookVOList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editKeyword = (EditText) findViewById(R.id.edit_keyword);
        btnSearch = (Button) findViewById(R.id.btn_search);
        listViewBook = (ListView) findViewById(R.id.listview_book);

        adapter = new BookListAdapter
                (this, R.layout.item_book, bookVOList);

        listViewBook.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = editKeyword.getText() + "";
                NaverBookThread t =
                        new NaverBookThread(handler, keyword);
                t.start();
            }
        });
    }
}








