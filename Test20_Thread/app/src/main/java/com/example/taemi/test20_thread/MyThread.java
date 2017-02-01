package com.example.taemi.test20_thread;

import android.util.Log;

/**
 * Created by taemi on 2017-02-01.
 */

public class MyThread extends Thread{
    @Override
    public void run() {
        Log.v("ktm thread","ThreadID:"+getId());

        for(int i=0; i<10; i++){
            Log.v("Thread by Object","count:"+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
