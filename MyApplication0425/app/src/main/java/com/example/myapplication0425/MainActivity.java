package com.example.myapplication0425;

import static android.graphics.Color.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainBack;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // xml --> 실질적으로 보여지게끔 만들어 준다!
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainBack=findViewById(R.id.mainBack);



    }
    // 누가 어떤 객체를 눌렀는지 알기 위해서 View 객체를 사용해야 한다!
    public  void onClick(View v) {
        // 버튼을 한번 클릭했을 때는 원하는 색상으로 바뀌도록

        if (cnt == 0) {
            mainBack.setBackgroundColor(Color.parseColor("#69c0e5"));
            cnt++;
        // 버튼을 한번더 클릭했을 때는 다시 흰색으로 돌아오도록
        } else {
            cnt--;
            mainBack.setBackgroundColor(Color.parseColor("white"));
        }
    }




        


    }
