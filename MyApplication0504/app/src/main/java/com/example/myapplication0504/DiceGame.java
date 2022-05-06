package com.example.myapplication0504;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class DiceGame extends AppCompatActivity {

    TextView tv_score;
    ImageView img_user,img_com;
    Button btn_play;

    int[] diceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,R.drawable.dice4,
            R.drawable.dice5,R.drawable.dice6};

    // 몇번 이겼는지를 알려주는 변수
    int userCnt,comCnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_game);

        tv_score = findViewById(R.id.tv_score);
        img_user = findViewById((R.id.img_user));
        img_com = findViewById((R.id.img_com));
        btn_play = findViewById(R.id.btn_play);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 1. 플레이 버튼 클릭 시 랜덤하게 주사위 모양이 바뀌게끔
                //   두개의 랜덤한 수를 받아와서 주사위 이미지 변경!
                Random ran = new Random();

                int userNum = ran.nextInt(6);
                int comNum = ran.nextInt(6);

                img_user.setImageResource(diceArray[userNum]);
                img_com.setImageResource(diceArray[comNum]);

                // 2. 주사위의 눈이, 컴퓨터가 큰지 사용자가 큰지 판단
                if (userNum > comNum) {
                    userCnt++;
                    if(userCnt>=10){
                        //토스트 알림창 띄우는 방법
                        // --> 띄워졌다가 사라지는 알림창
                        Toast.makeText(DiceGame.this,"user 승리 입니다",Toast.LENGTH_LONG).show();

                    }

                } else if (userNum < comNum) {
                    comCnt++;
                    if(comCnt>=10){
                        Toast.makeText(DiceGame.this,"컴퓨터의 승리 입니다",Toast.LENGTH_LONG).show();


                    }
                }

                // 3. 더 큰 눈을 가지고 있는 편의 스코어를 1 증가

                tv_score.setText(userCnt+" : "+comCnt);

            }

        });
    }






    
}