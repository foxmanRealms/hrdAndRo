package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccess_intent extends AppCompatActivity {

    private TextView tv_login_id,tv_login_pw,tv_login_nick,tv_login_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        tv_login_id=findViewById(R.id.tv_login_id);
        tv_login_pw=findViewById(R.id.tv_login_pw);
        tv_login_nick=findViewById(R.id.tv_login_nick);
        tv_login_phone=findViewById(R.id.tv_login_phone);

        ///// 인텐트 안의 값을 하나하나 뿌려주면 된다.

        Intent intent = getIntent();
        ///// 시리얼자이블 상태의 데이터를  멤버VO로 다운캐스팅한다
        MemberVo_intent vo= (MemberVo_intent)intent.getSerializableExtra("vo");
        tv_login_id.setText(vo.getId());
        tv_login_pw.setText(vo.getPw());
        tv_login_nick.setText(vo.getNick());
        tv_login_phone.setText(vo.getPhone());


    }
}