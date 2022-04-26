package com.example.myapplication0426_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChangeColor extends AppCompatActivity implements View.OnClickListener{

    Button btn_red,btn_green,btn_blue;
    ConstraintLayout ly_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 어느 xml 파일을 실행할 것인지 정해주는 부분이다!
        setContentView(R.layout.activity_change_color);


        ly_back=findViewById(R.id.ly_back);
        btn_red=findViewById(R.id.btn_red);
        btn_green=findViewById(R.id.btn_green);
        btn_blue=findViewById(R.id.btn_blue);

        btn_red.setOnClickListener(this);
        btn_green.setOnClickListener(this);
        btn_blue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.btn_red){
            ly_back.setBackgroundColor(Color.parseColor("red"));

        }else if(view.getId() ==R.id.btn_green){
            ly_back.setBackgroundColor(Color.parseColor("green"));

        }else if(view.getId() ==R.id.btn_blue){
            ly_back.setBackgroundColor(Color.parseColor("blue"));

        }

    }
}