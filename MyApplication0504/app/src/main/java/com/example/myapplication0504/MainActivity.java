package com.example.myapplication0504;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity  {

    Button btn_before, btn_after;
    ImageView img_pocket;

    // 이미지를 관리할 배열
    // imgArray ==>> 이미지를 가리킬 수 있는 데이터를 배열로 관리함
    int[] imgArray = {R.drawable.and1, R.drawable.and2, R.drawable.and3};
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_before = findViewById(R.id.btn_before);
        btn_after = findViewById(R.id.btn_after);
        img_pocket = findViewById(R.id.image_pocket);

        // 이벤트 적용 3번째 방법!
        //리스너 인터페이스를 익명클래스로 정의해서 사용!
        //리스너를 임시적으로 만들어서 버튼에 적용한다!
        // 각각의 버튼에 있는 기능이 전혀 다르고 로직이 길어질 때 사용한다
        // ex 회원가입, 로그인, 게시판 등등
        btn_before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다음버튼이 클릭 되었을 때 랜덤한 이미지가 출력되도록 만들어라.
                Random ran=new Random();
                //nextInt(숫자) --> 숫자-1  인 숫자중에서 랜덤한 숫자를 가져올꺼에요!
                int num=ran.nextInt(3); 
                img_pocket.setImageResource(imgArray[num]);


                /*index++;
                if (index == 3) {
                    index = 0;
                }
                img_pocket.setImageResource(imgArray[index]);*/
            }
        });
        btn_after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index--;
                if (index < 0) {
                    index = 2;
                }
                img_pocket.setImageResource(imgArray[index]);
            }
        });

    }
    // 이벤트 적용 두번째 방법으로 만들어 주세요!
    // 단! 마지막 이미지에서 다음 버튼을 클릭하면 첫번째 이미지로 돌아오게끔 만들어주세요



    // 이벤트 적용 2번째 --> 리스너 상속받아서 이벤트를 적용하는 방법
    // 각각의 버튼에 있는 기능이 비슷할 때 사용된다.
    // ex. 사칙연산, 간단한 로직(이미지 변경 등등등 )

   /* ///// 선생님 로직  2번째 방법
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_after) {
            index++;
            if (index == 3) {
                index = 0;
            }
            img_pocket.setImageResource(imgArray[index]);


        } else if (view.getId() == R.id.btn_before) {
            index--;
            if (index < 0) {
                index = 2;
            }
            img_pocket.setImageResource(imgArray[index]);
        }
*/


        
        
        
        /// 내 로직 오류 있음
        /*if (view.getId() == R.id.btn_after) {
            index++;
            img_pocket.setImageResource(imgArray[index]);
                if (index > 2) {
                img_pocket.setImageResource(imgArray[0]);
            }

        } else if (view.getId() == R.id.btn_before) {
            index--;
            img_pocket.setImageResource(imgArray[index]);
            if (index < 0) {
                img_pocket.setImageResource(imgArray[imgArray.length - 1]);

            }*/










    /*public void change(View view){
        index++;
        img_pocket.setImageResource(imgArray[index]);

    }

    public void before(View view){
        index--;
        img_pocket.setImageResource(imgArray[index]);

    }*/

}

