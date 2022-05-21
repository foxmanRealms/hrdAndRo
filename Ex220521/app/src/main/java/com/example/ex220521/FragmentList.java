package com.example.ex220521;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentList extends Fragment {

    private ListView listView;
    private ArrayList<String >items;
    private ArrayAdapter<String> adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View fragment = inflater.inflate(R.layout.list,container,false);

        listView=fragment.findViewById(R.id.listview);
        items = new ArrayList<String>();
        items.add("1. 박병관");
        items.add("2. 이명훈");
        items.add("3. 채수민");
        items.add("4. 최태양");
        items.add("5. 오지윤");
        items.add("6. 선영표");


        adapter= new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,items);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = (String) adapterView.getItemAtPosition(i);
                Log.v("myValue",value);

            }
        });

        return fragment;
    }
}
