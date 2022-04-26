package com.example.myapplication0426event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_res;
    Button btnP;
    Button btnM;
    int cnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_res= findViewById(R.id.tv_res);
        btnP=findViewById(R.id.btn_Plus);
        btnM=findViewById(R.id.btn_Minus);

    }

    public void onClickP(View v){
        cnt = 0;
        cnt= Integer.parseInt( tv_res.getText().toString() );

        cnt++;
        String s_cnt = Integer.toString(cnt);

        tv_res.setText(s_cnt);

    }

    public void onClickM(View v){
        cnt = 0;
        cnt= Integer.parseInt( tv_res.getText().toString() );

        cnt--;
        String s_cnt = Integer.toString(cnt);

        tv_res.setText(s_cnt);


    }
}