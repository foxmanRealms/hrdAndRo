package com.example.ex220513;

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

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText edt_food;
    private Button btn_food;
    private ArrayList<String> items=new ArrayList<String>();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);
        edt_food=findViewById(R.id.edt_food);
        btn_food=findViewById(R.id.btn_food);
        
        items.add("보쌈");items.add("삼겹살");items.add("김치찌개");items.add("짜장면");
        items.add("짬뽕");items.add("쫄면");items.add("족발");items.add("아이스크림");

        adapter= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=(String) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), value,Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                items.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btn_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=edt_food.getText().toString();
                items.add(input);
                adapter.notifyDataSetChanged();
                edt_food.setText("");
            }
        });


    }
}