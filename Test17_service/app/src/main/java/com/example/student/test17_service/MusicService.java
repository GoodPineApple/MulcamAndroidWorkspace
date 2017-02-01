package com.example.student.test17_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by student on 2017-01-31.
 */

public class MusicService extends Service {
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
    // MusicService가 처음 생성되는 시점에 실행되는 메소드
        Toast.makeText(this,"Service 생성됨.",Toast.LENGTH_SHORT)
                .show();

        player = MediaPlayer.create(this,R.raw.kalimba);
        player.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    // MusicService가 시작될 때마다 실행되는 메소드
        Toast.makeText(this,"Service 시작됨.",Toast.LENGTH_SHORT)
                .show();

        player.start(); // 음악 시작
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
    // 서비스가 종료될 때 실행되는 메소드
        Toast.makeText(this,"Service 소멸됨.",Toast.LENGTH_SHORT)
                .show();
        player.stop();
    }
}
