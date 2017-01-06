package com.example.student.test01;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

/**
 * Created by student on 2017-01-06.
 */

public class MyListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"별도 클래스 이벤트처리",
                Toast.LENGTH_SHORT).show();
    }
}
