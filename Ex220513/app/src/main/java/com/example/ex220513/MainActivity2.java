package com.example.ex220513;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private KakaoAdapter adapter = new KakaoAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView=findViewById(R.id.kakaoListView);
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img1 ),"1번 여우", "메롱" ,"네박자-송대관▶");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img2 ),"2번 여우", "입갤" ,"댓댓-싸이▶");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img3 ),"3번 여우", "심심해" ,"하하하송-자우림▶");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img4 ),"4번 여우", "귀찮아" ,"여우는어떻게울지-Ylvis▶");
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.img5 ),"5번 여우", "피곤해" ,"여우는어떻게울지-Ylvis▶");

        listView.setAdapter((adapter));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                KakaoVO vo=(KakaoVO) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext() , vo.toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}