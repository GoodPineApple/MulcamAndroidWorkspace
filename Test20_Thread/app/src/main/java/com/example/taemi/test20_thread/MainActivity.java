package com.example.taemi.test20_thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("ktm","메인쓰레드ID:"+Thread.currentThread().getId());

        MyThread t = new MyThread();
        t.start();

        for(int i =0; i<10; i++){
            Log.i("ktm","count:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
