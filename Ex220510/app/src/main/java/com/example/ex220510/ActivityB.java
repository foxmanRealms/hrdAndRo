package com.example.ex220510;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv_result=findViewById(R.id.tv_result);

        Intent intent=getIntent();
        String value = intent.getStringExtra("value"); ///// intent에 들어있는 값을꺼내온다
        tv_result.setText(value);
    }
}