package com.example.student.test23_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)
                findViewById(R.id.progress_bar);

        CountThread t = new CountThread();
        t.execute();
    }

    class CountThread extends AsyncTask<Void, Void, Void>{
        private int progress;
        @Override
        protected void onPreExecute() {
            // 쓰레드가 본격적인 작업 이전에 수행해야 하는 사전작업이
            // 있으면 이 메소드 오버라이딩 함.
            progress = 30;
        }

        @Override
        protected Void doInBackground(Void... params) {
            // 쓰레드가 해야하는 주된 작업은 이곳에 작성함.
            while(progress<=100){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                progress++;
                publishProgress(); // 화면갱신(onProgressUpdate)
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            // doInBackground 작업 도중에 화면의 뷰를 갱신하고 싶으면
            // 이 메소드가 실행됨.
            progressBar.setProgress(progress);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            // doInBackground 작업이 다 끝나고 나면 마지막에 한번
            // 실행되는 메소드
            Toast.makeText(MainActivity.this,"작업 완료됨!"
                    ,Toast.LENGTH_SHORT).show();
        }
    }
}
