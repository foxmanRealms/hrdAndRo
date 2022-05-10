package com.example.ex220510;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends AppCompatActivity {

    private Button btn_moveB;
    private EditText edit_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        btn_moveB=findViewById(R.id.btn_moveB);
        edit_input=findViewById(R.id.edit_input);


        btn_moveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String value = edit_input.getText().toString();

                Intent intent = new Intent(getApplicationContext(),ActivityB.class );
                intent.putExtra("value",value);

                startActivity(intent);
                finish();

            }
        });
    }
}