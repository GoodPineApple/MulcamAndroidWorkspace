package com.example.student.test05;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private CheckBox checkMeat;
    private CheckBox checkCheese;
    private CheckBox checkHam;

    private RadioButton radioRed;
    private RadioButton radioBlue;

    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCheckEvent checkListener = new MyCheckEvent();

        checkMeat = (CheckBox) findViewById(R.id.check_meat);
        checkCheese = (CheckBox) findViewById(R.id.check_cheese);
        checkHam = (CheckBox) findViewById(R.id.check_ham);

        radioRed = (RadioButton) findViewById(R.id.radio_red);
        radioBlue = (RadioButton) findViewById(R.id.radio_blue);

        ratingBar = (RatingBar) findViewById(R.id.rating);

        checkMeat.setOnClickListener(checkListener);
        checkCheese.setOnClickListener(checkListener);
        checkHam.setOnClickListener(checkListener);

        radioRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "빨강", Toast.LENGTH_SHORT).show();
            }
        });


        ratingBar.setRating(2.5f);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("yangyu","별점:"+rating+",fromUser:"+fromUser);
            }
        });

    }

    class MyCheckEvent implements View.OnClickListener{
        @Override
        public void onClick(View v) {

            switch(v.getId()){
                case R.id.check_meat:
                    Toast.makeText(getApplicationContext(),
                            "고기 선택함",Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.check_ham:
                    Toast.makeText(getApplicationContext(),
                            "햄 선택함",Toast.LENGTH_SHORT)
                            .show();
                    break;
                case R.id.check_cheese:
                    Toast.makeText(getApplicationContext(),
                            "치즈 선택함",Toast.LENGTH_SHORT)
                            .show();
                    break;
            }
        }
    }

}
