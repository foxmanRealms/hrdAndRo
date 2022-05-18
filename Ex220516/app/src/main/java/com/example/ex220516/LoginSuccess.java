package com.example.ex220516;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginSuccess extends AppCompatActivity {

    private TextView tv_login_id,tv_login_pw,tv_login_nick,tv_login_phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        tv_login_id=findViewById(R.id.tv_login_id);
        tv_login_pw=findViewById(R.id.tv_login_pw);
        tv_login_nick=findViewById(R.id.tv_login_nick);
        tv_login_phone=findViewById(R.id.tv_login_phone);

        tv_login_id.setText(LoginCheck.info.getId()  );
        tv_login_pw.setText(LoginCheck.info.getPw() );
        tv_login_nick.setText(LoginCheck.info.getNick() );
        tv_login_phone.setText(LoginCheck.info.getPhone() );

        MemberVo info = LoginCheck.info;
        
        // 로그아웃기능
        // LoginCheck.info=null;


    }
}