package com.example.ex220511;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity5 extends AppCompatActivity {

    private ListView listview;
    private ArrayList<String> item=new ArrayList<String>();

    private EditText edt_input;
    private Button btn_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        listview=findViewById(R.id.listview);
        edt_input=findViewById(R.id.edt_input);
        btn_input=findViewById(R.id.btn_input);

        item.add("떡볶이");
        item.add("탕수육");
        item.add("짜장면");
        item.add("김치찌개");
        item.add("오뎅");
        item.add("감바스");
        item.add("오일파스타");
        item.add("고래밥");
        item.add("타코야끼");
        item.add("붕어빵");
        item.add("호떡");
        item.add("부대찌개");
        item.add("잔치국수");
        item.add("순대국밥");
        item.add("매운탕");
        item.add("생선구이");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplication(), android.R.layout.simple_list_item_1, item );

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= (String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), value,Toast.LENGTH_SHORT).show();

            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                item.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });


        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edt_input.getText().toString();
                item.add(input);
                adapter.notifyDataSetChanged();
                edt_input.setText(""); // 입력하고나서 해당 칸을 비워서 다음 입력을 편리하게만듦
            }
        });


    }
}