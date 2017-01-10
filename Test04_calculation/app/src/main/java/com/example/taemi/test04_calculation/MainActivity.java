package com.example.taemi.test04_calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText firstEdit;
    private EditText secondEdit;
    private TextView resultText;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiplication;
    private Button btnDivision;
    private Button btnEqual;
    private String logic;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView) findViewById(R.id.text_result);
        btnEqual = (Button) findViewById(R.id.btn_equal);
        btnDivision = (Button) findViewById(R.id.btn_division);
        btnMinus = (Button) findViewById(R.id.btn_minus);
        btnMultiplication = (Button) findViewById(R.id.btn_multiplication);
        btnPlus = (Button) findViewById(R.id.btn_plus);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic = "+";
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic = "*";
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic="-";
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logic="-";
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstEdit = (EditText) findViewById(R.id.edit_first);
                String firstText = firstEdit.getText().toString();
                int firstNum = Integer.parseInt(firstText);
                secondEdit = (EditText) findViewById(R.id.edit_second);
                String secondText = secondEdit.getText().toString();
                int secondNum = Integer.parseInt(secondText);

                if(logic == "+"){
                    result = firstNum+secondNum;
                    resultText.setText(result+"");
                } else if(logic == "-"){
                    result = firstNum-secondNum;
                    resultText.setText(result+"");
                } else if(logic == "*"){
                    result = firstNum*secondNum;
                    resultText.setText(result+"");
                } else if(logic == "/"){
                    result=firstNum/secondNum;
                    resultText.setText(result+"");
                }
                firstEdit.setText("");
                secondEdit.setText("");
            }
        });
    }
}
