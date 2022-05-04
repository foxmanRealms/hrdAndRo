package com.example.myapplication0426_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculator extends AppCompatActivity implements View.OnClickListener{
    EditText edit_num1,edit_num2;
    Button btn_plus2,btn_minus2,btn_mult2,btn_div2;
    TextView tv_res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        edit_num1=findViewById(R.id.edit_num1);
        edit_num2=findViewById(R.id.edit_num2);
        tv_res=findViewById(R.id.tv_res);

        btn_minus2=findViewById(R.id.btn_minus2);
        btn_plus2=findViewById(R.id.btn_plus2);
        btn_mult2=findViewById(R.id.btn_mult2);
        btn_div2=findViewById(R.id.btn_div2);

        // 이벤트 적용 두번째 방법
        // --> 리스너 인터페이스를 상속받아 적용시키는 방법!

        btn_plus2.setOnClickListener(this);
        btn_minus2.setOnClickListener(this);
        btn_mult2.setOnClickListener(this);
        btn_div2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // 1. 클릭되었을 때 입력한 숫자 가져오기
        int num1= Integer.parseInt(edit_num1.getText().toString()  ) ; ///  형변환 전String.valueof(edit_num1.getText() )
        int num2= Integer.parseInt(edit_num2.getText().toString()  ) ;
        int result=0;

        // 2. 어떤 버튼 클릭되었는지 판단!
        if(view.getId()==R.id.btn_plus2  ){
            result=num1+num2;

        }else if(view.getId()==R.id.btn_minus2  ){
            result=num1-num2;

        }else if(view.getId()==R.id.btn_mult2  ){
            result=num1*num2;

        }else if(view.getId()==R.id.btn_div2  ){
            result=num1/num2;

        }
        tv_res.setText(String.valueOf("연산결과 : "+result)); /// 스트링 + 인트는 자료형 스트링이 된다





        /*String num1=edit_num1.getText().toString(); /// String.valueof(edit_num1.getText() )
        String num2=edit_num2.getText().toString();
        int iNum1=Integer.parseInt(num1);
        int iNum2=Integer.parseInt(num2);
        int numData= 0;

        if(view.getId()==R.id.btn_minus2  ){
            numData=iNum1-iNum2;

        }else if(view.getId()==R.id.btn_plus2  ){
            numData=iNum1+iNum2;

        }else if(view.getId()==R.id.btn_mult2  ){
            numData=iNum1*iNum2;

        }else if(view.getId()==R.id.btn_div2  ){
            numData=iNum1/iNum2;

        }
        tv_res.setText(String.valueOf(numData));*/
    }
}