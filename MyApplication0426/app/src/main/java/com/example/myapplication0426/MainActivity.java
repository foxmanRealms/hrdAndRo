package com.example.myapplication0426;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 버튼이 클릭되어 졌을 때!
    // PlainText에 적은 내용을 가져와서
    // TextView에 적용!
    EditText edt_text;
    TextView tv_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_text =findViewById(R.id.edt_text);
        tv_text =findViewById(R.id.tv_text);

    }

    public void onClick(View view){ // View --> 어떤 객체가 호출했는지를 담아줌

        //edt_text에 적힌 내용을 가져오면 됨!
        //Text 가져오기 ->getText() 주의! 문자열로 변환하는 작업이 필요함!
        String text = edt_text.getText().toString() ;
        
        // 데이터 출력
        Log.d("적힌값",text);

        // 가져온 내용을 TextView에 띄워주기
        tv_text.setText(text);


        
    }
}