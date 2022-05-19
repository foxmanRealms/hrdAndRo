package com.example.ex220519;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private Button btn_start,btn_stop,btn_reset;
    private TextView tv_result;

    private int minute;  // 분
    private int second;  // 초
    private int milliSecond; // 밀리초

    private  boolean isCheck=true;  // while문을 멈추는


    private Handler handler = new Handler(){
        // Thread에서 데이터를 넘겨받아 UI/UX 부분을 수정할 수 있게 해주는 객체

        @Override
        public void handleMessage(@NonNull Message msg) {
            // Thread로부터 데이터를 넘겨받는 메소드

            String result = "";
            if(msg.arg1 < 10){
                result += "0" + msg.arg1;
            }else{
                if(msg.arg1 == 100){
                    second++;
                    milliSecond = 0;
                }
                result += msg.arg1;
            }

            if(second < 10){
                result = "0" + second +"."+ result;
            }else{
                result = second +"."+ result;
                if(second >= 60){
                    minute ++;
                    second = 0;
                }
            }
            if(minute < 10){
                result = "0" + minute + ":" + result;
            }else{
                result = minute + ":" + result;
            }

            tv_result.setText(result);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
        btn_reset=findViewById(R.id.btn_reset);

        tv_result=findViewById(R.id.tv_result);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyThread thread= new MyThread();  ///// 상속으로 이용하던방법
                thread.start();


            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isCheck=false;
            }
        });


        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               minute=0;
               second=0;
               milliSecond=0;

               tv_result.setText("00:00.00");


            }
        });

    }

    public class MyThread extends Thread{

        @Override
        public void run() {
            // Thread를 실행시키는 메소드

            isCheck=true;
            while(isCheck){
                try {
                    Thread.sleep(10);
                    milliSecond++;

                    Message message=new Message();
                    message.arg1=milliSecond;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}