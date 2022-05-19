package com.example.ex220519;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn_time;
    private TextView tv_time;
    private int time ; // 시간을 저장할 변수

    private Handler handler = new Handler(){
        // Thread에서 데이터를 넘겨받아 UI/UX 부분을 수정할 수 있게 해주는 객체

        @Override
        public void handleMessage(@NonNull Message msg) {
            // Thread로부터 데이터를 넘겨받는 메소드

            tv_time.setText(msg.arg1+"");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_time=findViewById(R.id.btn_time);
        tv_time=findViewById(R.id.tv_time);

        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TimeThread timeThread = new TimeThread();  ///// 상속으로 이용하던방법
                //timeThread.start();

                Thread t= new Thread(new InTimeThread() );
                t.start();

            }
        });

    }

    public class InTimeThread implements Runnable{

        @Override
        public void run() {
            // Thread를 실행시키는 메소드
            while(true){
                try {
                    Thread.sleep(1000);
                    time++;
                    Message message=new Message();
                    message.arg1=time;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }


    }




    public class TimeThread extends Thread{

        @Override
        public void run() {
            // Thread를 실행시키는 메소드
            while(true){
                try {
                    Thread.sleep(1000);
                    time++;
                    Message message=new Message();
                    message.arg1=time;
                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }


}