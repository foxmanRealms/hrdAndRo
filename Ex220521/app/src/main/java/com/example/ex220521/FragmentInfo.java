package com.example.ex220521;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentInfo extends Fragment {

    private Button btn_change;
    private TextView tv_nick;
    private EditText edt_nick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View fragment = inflater.inflate(R.layout.info,container,false);

        btn_change=fragment.findViewById(R.id.btn_change);
        edt_nick=fragment.findViewById(R.id.edt_nick);
        tv_nick=fragment.findViewById(R.id.tv_nick);


        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nick=edt_nick.getText().toString();

                tv_nick.setText("닉네임 : "+nick);


            }
        });


        return fragment;
    }
}
