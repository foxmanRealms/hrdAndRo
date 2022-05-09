package com.example.myapplication0507;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_start;

    // 하단 버튼의 id 값을 저장하는 배열 생성
    int[] btnArray = {R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,};
    int cnt = 1;
    int round = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.btn_start);

        // 어플 실행시 하단에 있는 9개의 버튼이 전부 안보이게 만들어 주세요

        for(int i = 0; i<btnArray.length; i++){
            Button btn = findViewById(btnArray[i]);
            btn.setVisibility(View.INVISIBLE);
            btn.setOnClickListener(this);
        }

        // 게임 스타트 버튼을 클릭하면
        // 테스트 버튼이 안보이게 해주세요

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                round = 1;
                cnt = 1;
                //btn.setVisibility(View.VISIBLE); --> 숨었던 버튼 나오기
                //9개의 버튼이 보여지게 해야함
                //단! 랜덤한 숫자를 가지고 나오게 해야함
                //btn.setText() --> 버튼 내용지정!
                Random ran = new Random();
                int [] num = new int[9];
                    for (int i = 0; i < num.length; i++) {
                        num[i] = ran.nextInt(9) + 1;
                        for(int j = 0; j < i; j++){
                            if(num[i]==num[j]){
                                i--;
                            }
                        }
                    }

                for(int i = 0; i < num.length; i++){
                    Button btn = findViewById(btnArray[i]);
                    btn.setVisibility(View.VISIBLE);
                    btn.setText(num[i]+"");
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        Button btn = findViewById(view.getId());
        if(cnt == Integer.parseInt((String) btn.getText())) {
            btn.setVisibility(View.INVISIBLE);
            cnt++;
        }else{
            Toast.makeText(MainActivity.this,"순서대로 클릭해주세요",Toast.LENGTH_SHORT).show();
        }

        if(cnt == round*9+1 && cnt < 46){

        // 마지막 번호를 클릭했을때 다음 랜덤 숫자가
        // 버튼으로 나오게끔 만들어 주세요!
        Random ran = new Random();
        int [] num = new int[9];
        for (int i = 0; i < num.length; i++) {
            num[i] = ran.nextInt(9) + round*9+1;
            for(int j = 0; j < i; j++){
                if(num[i]==num[j]){
                    i--;
                }
            }
        }
            for(int i = 0; i < num.length; i++){
                btn = findViewById(btnArray[i]);
                btn.setVisibility(View.VISIBLE);
                btn.setText(num[i]+"");
            }
            round++;
        }else if(cnt == 46){
            Toast.makeText(MainActivity.this,"게임끝",Toast.LENGTH_SHORT).show();
        }
        //순서대로 클릭 했을때만 버튼이 사라지게끔 만들어 주세요!
    }
}