package com.example.taemi.test13_timer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

// 핸들러를 통해 메인스레드가 메인스레드에게 메세지를 보냄
public class MainActivity extends AppCompatActivity {
    int value=0;
    TextView mText;
    TextView mText2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText=(TextView)findViewById(R.id.text);
        mText2=(TextView)findViewById(R.id.text2);

        mHandler.sendEmptyMessage(0); // 앱 시작과 동시에 핸들러에 메세지 전달


    }
    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            value++;
            mText.setText("Value = " + value);

            // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
            mHandler.sendEmptyMessageDelayed(0,1000);
        }
    };

}