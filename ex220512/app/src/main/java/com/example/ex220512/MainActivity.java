package com.example.ex220512;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn_create;

    private int[] edt_ids={R.id.edt_num1,R.id.edt_num2,R.id.edt_num3,
                        R.id.edt_num4,R.id.edt_num5,R.id.edt_num6};  /////아이디 숫자를 저장하는 배열
    private EditText[] edt_nums= new EditText[6];
    private  int[] nums=new int[6];   ///// 로또 숫자 넣을 배열


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // 실습
        // edt_num1 ~ edt_num6 까지 사용자가 입력한 데이터를
        // 배열로 만들어 Intent에 담아 MainActivity2로 이동하시오

        ///// 6번 변수 입력하는 대신 배열로 처리하였다
        for(int i=0;i<edt_ids.length;i++){
            edt_nums[i]=findViewById(edt_ids[i]);
        }

        btn_create=findViewById(R.id.btn_create);


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < edt_nums.length; i++) {
                    nums[i]=Integer.parseInt(edt_nums[i].getText().toString() );

                }

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("nums",nums);
                startActivity(intent); ///// 받아서 돌아올 내용이 없기 때문에 이렇게 처리

            }
        });

    }
}