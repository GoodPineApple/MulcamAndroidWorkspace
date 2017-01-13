package com.example.student.test10;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button btnBasic, btnDate, btnTime, btnCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasic = (Button) findViewById(R.id.btn_basic);
        btnDate = (Button) findViewById(R.id.btn_date);
        btnTime = (Button) findViewById(R.id.btn_time);
        btnCustom = (Button) findViewById(R.id.btn_custom);

        btnBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBasicDialog();
            }
        });


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    public void showBasicDialog(){
        AlertDialog.Builder builder =
                            new AlertDialog.Builder(this);

        builder.setTitle("종료확인 대화상자")
                .setMessage("어플리케이션을 종료하시겠습니까?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.finish(); // 앱 진짜 종료;;
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel(); // 다이얼로그 작업취소
                    }
                })
                .create()
                .show();
    }

    public void showDateDialog(){
        int nowYear, nowMonth, nowDay;

        Calendar now = Calendar.getInstance();
        nowYear = now.get(Calendar.YEAR);
        nowMonth = now.get(Calendar.MONTH);
        nowDay = now.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog.OnDateSetListener dateListener =
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String dateMsg =
                            "선택한 날짜:"+year+"-"+(month+1)+"-"+dayOfMonth;
                        Toast.makeText(getApplicationContext(),
                                dateMsg,Toast.LENGTH_SHORT).show();
                    }
                };
        DatePickerDialog dateDialog =
                new DatePickerDialog
                (this, dateListener, nowYear,nowMonth,nowDay);
        dateDialog.show();
    }

    public void showTimeDialog(){
        int nowHour, nowMinute;
        Calendar now = Calendar.getInstance();

        nowHour = now.get(Calendar.HOUR_OF_DAY);
        nowMinute = now.get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener listener =
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String timeMsg =
                                "선택시간 "+hourOfDay+":"+minute;
                        Toast.makeText(getApplicationContext(),
                                timeMsg,Toast.LENGTH_SHORT).show();
                    }
                };

        TimePickerDialog timeDialog =
                new TimePickerDialog
                        (this,listener,nowHour,nowMinute,true);
        timeDialog.show();
    }

    public void showCustomDialog(){
        final Dialog customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.my_dialog);//inflate

        ImageView customImg =
                (ImageView) customDialog.findViewById(R.id.custom_img);
        TextView customText =
                (TextView) customDialog.findViewById(R.id.custom_text);
        Button customBtnYes =
                (Button) customDialog.findViewById(R.id.custom_btn_yes);
        Button customBtnNo =
                (Button) customDialog.findViewById(R.id.custom_btn_no);
        ///////////////////////////////////////////////////////
        customImg.setImageResource(R.drawable.koala);
        customText.setText("이불을 잃어버리시겠습니까?");

        customBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "통장 잔고가 줄어듭니다..",Toast.LENGTH_SHORT)
                        .show();
                customDialog.cancel();
            }
        });
        customBtnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "기특합니다.",Toast.LENGTH_SHORT)
                        .show();
                customDialog.cancel();
            }
        });

        customDialog.show();
    }
}






