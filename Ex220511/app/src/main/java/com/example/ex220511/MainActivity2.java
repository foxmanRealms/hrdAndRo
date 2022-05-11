package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();

        MemberVO vo=(MemberVO) intent.getSerializableExtra("vo");
        Log.v("myData",vo.toString() );








//        String name=intent.getStringExtra("name");
//        int age=intent.getIntExtra("age",0);
//        String[] hobby = intent.getStringArrayExtra("hobby");
//
//        Log.v("myData",name);
//        Log.v("myData",age+""); /// 정수를 그냥 꺼내지 못하니까 문자를 넣어서 문자로만듦
//        for(int i=0;i< hobby.length;i++){
//            Log.v("myData",hobby[i]);
//
//        }



    }
}