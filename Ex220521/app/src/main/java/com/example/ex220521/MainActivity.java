package com.example.ex220521;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navi;
    private FragmentInfo info;
    private FragmentList list;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm=getSupportFragmentManager();

        info=new FragmentInfo();
        list=new FragmentList();

        navi=findViewById(R.id.navi);
        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId() ){
                    case R.id.info:
                        fm.beginTransaction().replace(R.id.frame,info).commit();
                        Toast.makeText(getApplicationContext(), "내 정보",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.list:
                        fm.beginTransaction().replace(R.id.frame,list).commit();
                        Toast.makeText(getApplicationContext(), "친구목록보기",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Toast.makeText(getApplicationContext(), "설정",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });


    }
}