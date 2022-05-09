package com.example.myapplication0509;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication0509.databinding.ActivityMainActivitySolveBinding;
import com.example.myapplication0509.databinding.ActivityMainBinding;

public class MainActivity_solve extends AppCompatActivity implements View.OnClickListener {
    EditText edit_num1, edit_num2;
    Button btn_add, btn_minus, btn_mul, btn_div;
    TextView tv_result;
    
    // 바인딩 객체 만들기 --> 어플에 있는 모든 View에 대한 정보를 저장하고 있음
    ActivityMainActivitySolveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // xml에 있는 정보 가져오기
        binding = ActivityMainActivitySolveBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ///// 바인딩이 모든 내용을 가지고 있기 때문에 하단의 객체 선언이 필요없다고 한다.
//        edit_num1 = findViewById(R.id.edit_num1);
//        edit_num2 = findViewById(R.id.edit_num2);
//        btn_add = findViewById(R.id.btn_add);
//        btn_minus = findViewById(R.id.btn_minus);
//        btn_mul = findViewById(R.id.btn_mul);
//        btn_div = findViewById(R.id.btn_div);
//        tv_result = findViewById(R.id.tv_result);

        binding.btnAdd.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnMul.setOnClickListener(this);
        binding.btnDiv.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int num1=Integer.parseInt(binding.editNum1.getText().toString() );
        int num2=Integer.parseInt(binding.editNum2.getText().toString() );

        int result=0;
        if (view.getId() == R.id.btn_add) {
            result=num1+num2;
        } else if (view.getId() == R.id.btn_minus) {
            result=num1-num2;

        } else if (view.getId() == R.id.btn_mul) {
            result=num1*num2;
        } else if (view.getId() == R.id.btn_div) {
            result=num1/num2;

        }

        binding.tvResult.setText("연산결과 : "+result);
    }
}