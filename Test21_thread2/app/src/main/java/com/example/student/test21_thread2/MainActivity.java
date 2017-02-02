package com.example.student.test21_thread2;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textThread;
    private Handler handler; // 쓰레드가 보내는 메세지 받아서 처리

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textThread = (TextView) findViewById(R.id.text_thread);
        textThread.setText("MainThread ID:" +
                Thread.currentThread().getId());
//////////////////////////////////////////////////////////////
//        <첫번째 문제점!!>
//        아래 작업은 메인 쓰레드가 sleep에 걸려서 화면에 그리는 작업이
//        딜레이 되므로 바람직하지 않음.
//
//        for(int i=1; i<=10; i++){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            textThread.setText("count:"+i);
//        }
//////////////////////////////////////////////////////////////
//        <두번째 문제점!!>
//        메인쓰레드가 아닌 쓰레드는 View에 접근해서 변경이 불가능함!
//        CountThread t = new CountThread();
//        t.start();
//////////////////////////////////////////////////////////////
//        <두 가지 문제의 해결책 핸들러 사용하기!!>
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // 다른 쓰레드가 메인한테 메세지를 보내면
                // 어떻게 반응할지 작성하는 공간
                if(msg.what == 200){
                    textThread.setText("진행중:"+msg.arg1);
                }else if(msg.what == 999){
                    textThread.setText("카운트 종료!!");
                }

            }
        };

        CountThread2 t = new CountThread2();
        t.start();
//////////////////////////////////////////////////////////////
    }

//    class CountThread extends Thread{
//        @Override
//        public void run() {
//            for(int i=0; i<10; i++){
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                textThread.setText("count:"+i);
//            }
//        }
//    }


    class CountThread2 extends Thread{
        // 메인쓰레드가 아닌 쓰레드는 뷰 못건드리므로
        // 화면에 뭔가를 변경해 달라는 메세지를 보내야함.
        @Override
        public void run() {
            for(int i=0; i<=10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg = new Message();
                msg.what = 200; // 카운트 진행중임을 알리는 코드
                msg.arg1 = i; // 카운트값
                handler.sendMessage(msg); // 핸들러에게 보냄.
            }

            Message msg = new Message();
            msg.what = 999; // 카운트가 종료됨을 알리는 코드
            handler.sendMessage(msg);
        }
    }
}
