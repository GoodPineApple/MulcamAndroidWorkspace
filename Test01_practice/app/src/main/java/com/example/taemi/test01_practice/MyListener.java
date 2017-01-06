package com.example.taemi.test01_practice;

import android.view.View;
import android.widget.Toast;

/**
 * Created by taemi on 2017-01-06.
 */

public class MyListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"btn2별도클래스이벤트",Toast.LENGTH_SHORT).show();
    }
}
