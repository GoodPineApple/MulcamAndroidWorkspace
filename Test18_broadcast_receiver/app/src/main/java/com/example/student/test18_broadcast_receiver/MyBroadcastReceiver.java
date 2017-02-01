package com.example.student.test18_broadcast_receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by student on 2017-01-31.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    // 클래스에서는 어떤 방송이 오는지 모르지만 원하는 방송이 수신된 경우
    // onReceive 함수가 실행됨.
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
//        Toast.makeText
//                (context,"방송수신 Action:"+action,Toast.LENGTH_LONG).show();
        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            // 단말기에 전원선이 연결되었을때 안드로이드시스템이 방송한걸 듣고
            // 그 때 하고자 하는 일을 적는 곳
            Toast.makeText
                    (context, "전원 연결됨" + action, Toast.LENGTH_LONG).show();
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            // 단말기에 전원선이 연결 해제되었을때 안드로이드시스템이 방송한걸 듣고
            // 그 때 하고자 하는 일을 적는 곳
            Toast.makeText
                    (context, "전원 해제됨" + action, Toast.LENGTH_LONG).show();
        } else if (action.equals(Intent.ACTION_BATTERY_LOW)) {
            // 단말기에 배터리가 부족할 때 안드로이드시스템이 방송한걸 듣고
            // 그 때 하고자 하는 일을 적는 곳
            Toast.makeText
                    (context, "전원 부족" + action, Toast.LENGTH_LONG).show();

            Intent intentWeb = new Intent
                    (Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
            // MainActivity가 아닌 새로운 액티비티를 시작하기 위한 설정
            intentWeb.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intentWeb);
        } else if (action.equals("com.example.YANGYU")) {
            // 다른 앱이 com.example.YANGYU 라는 방송한걸 듣고
            // 그 때 하고자 하는 일을 적는 곳
            Toast.makeText
                    (context, "양유방송" + action, Toast.LENGTH_LONG).show();
        } else if (action.equals("android.provider.Telephony.SMS_RECEIVED")) {
            // 문자 수신 이슈가 방송되었을 때 반응하는 조건문
            Bundle bundle = intent.getExtras();
            SmsMessage[] msgs = null;
            String str = "";

            if (bundle == null) {
                Toast.makeText(context, "Message???", Toast.LENGTH_SHORT).show();
            } else {
                // 문자 메시지 내용이 존재함.
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    str += "문자 수신! from: " + msgs[i].getOriginatingAddress() + "\n";
                    str += "[" + msgs[i].getMessageBody().toString() + "]\n";
                }
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
