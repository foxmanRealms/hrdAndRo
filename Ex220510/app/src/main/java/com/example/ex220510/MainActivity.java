package com.example.ex220510;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_web,btn_camera,btn_dial,btn_call;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_web=findViewById(R.id.btn_web);
        btn_camera=findViewById(R.id.btn_camera);
        btn_dial=findViewById(R.id.btn_dial);
        btn_call=findViewById(R.id.btn_call);

        btn_web.setOnClickListener(this);
        btn_camera.setOnClickListener(this);
        btn_dial.setOnClickListener(this);
        btn_call.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_web ){
            Uri uri=Uri.parse("https://www.naver.com");
            Intent intent= new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
        }else if(view.getId()==R.id.btn_camera ){
            Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        }else if(view.getId()==R.id.btn_dial ){
            Uri uri=Uri.parse("tel:01046115278");
            Intent intent= new Intent(Intent.ACTION_DIAL,uri);
            startActivity(intent);

        }else if(view.getId()==R.id.btn_call ){
            Uri uri=Uri.parse("tel:01046115278");
            Intent intent= new Intent(Intent.ACTION_CALL,uri);

            if(ActivityCompat.checkSelfPermission(getApplicationContext() ,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED ){
                ActivityCompat.requestPermissions(MainActivity.this, new String[]
                        {Manifest.permission.CALL_PHONE},0 );
                return;
            }
            startActivity(intent);


        }
    }
}