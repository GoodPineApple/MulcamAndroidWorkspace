package com.example.student.test01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by student on 2017-01-06.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // 액티비티 표지붙이기
/////////////////////////////////////////////////////////////
        // 첫번째 버튼은 xml에 onClick 속성으로 이벤트 처리함.
        // 두번째 버튼 별도 클래스로 이벤트 처리
        Button btnSecond = (Button) findViewById(R.id.btn_second);
        btnSecond.setOnClickListener(new MyListener());
///////////////////////////////////////////////////////
        // 세번째 버튼 무명 클래스로 이벤트 처리
        Button btnThird = (Button) findViewById(R.id.btn_third);
        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"무명클래스 이벤트처리",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void myClick(View view){
        Toast.makeText(this,"버튼1 눌림!",Toast.LENGTH_LONG).show();
    }
}
