package com.example.student.test22_thread3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)
                findViewById(R.id.progress_bar);

        ProgressThread t = new ProgressThread();
        t.start();
    }

    class ProgressThread extends Thread {
        private int progress;

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                progress = i;
// Test21번에서 핸들러한테 데이터만 보내고 핸들러가 알아서 처리했으나
// 이번에는 어떤 작업을 해야하는지 까지 다 명시해서 보내기(post)
                progressBar.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setProgress(progress);
                    }
                });

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
