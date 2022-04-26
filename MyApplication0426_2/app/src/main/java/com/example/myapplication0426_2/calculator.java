package com.example.myapplication0426_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculator extends AppCompatActivity implements View.OnClickListener{

    Button btn_plus2,btn_minus2,btn_mult2,btn_div2;
    TextView tv_num1,tv_num2,tv_res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tv_num1=findViewById(R.id.tv_num1);
        tv_num2=findViewById(R.id.tv_num2);
        tv_res=findViewById(R.id.tv_res);

        btn_minus2=findViewById(R.id.btn_minus2);
        btn_plus2=findViewById(R.id.btn_plus2);
        btn_mult2=findViewById(R.id.btn_mult2);
        btn_div2=findViewById(R.id.btn_div2);

        btn_minus2.setOnClickListener(this);
        btn_plus2.setOnClickListener(this);
        btn_mult2.setOnClickListener(this);
        btn_div2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String num1=tv_num1.getText().toString();
        String num2=tv_num2.getText().toString();
        int iNum1=Integer.parseInt(num1);
        int iNum2=Integer.parseInt(num2);
        int numData= 0;

        if(view.getId()==R.id.btn_minus2  ){
            numData=iNum1-iNum2;

        }else if(view.getId()==R.id.btn_plus2  ){
            numData=iNum1+iNum2;

        }else if(view.getId()==R.id.btn_mult2  ){
            numData=iNum1*iNum2;

        }else if(view.getId()==R.id.btn_div2  ){
            numData=iNum1/iNum2;

        }
        tv_res.setText(String.valueOf(numData));
    }
}