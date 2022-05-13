package com.example.ex220513;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KakaoAdapter extends BaseAdapter {

    private ArrayList<KakaoVO> items = new ArrayList<KakaoVO>();

    public void addItem(Drawable img,String name, String message, String music){
        KakaoVO vo = new KakaoVO(img,name,message,music);
        items.add(vo);
    }


    @Override
        public int getCount () {
        // 어댑터가 가지고 있는 아이템의 개수를 알려주는 메소드
        return items.size() ;
    }

    @Override
    public Object getItem ( int i){
    // 어댑터에게 해당 i번째의 아이템을 요청하는 메소드
        return items.get(i);
    }

    @Override
    public long getItemId ( int i){
        return i;   ///// 안쓰는 것이라고 한다.  그냥 i만 넣음
    }
        
        
    ////// 별표 500개  정말 중요하다고 한다
    //Adapter가 가지고 있는 item만큼 만들어놓은 xml에 틀에 맞게 넣어주는 메소드
    // 필수구현
    @Override
    public View getView ( int i, View view, ViewGroup viewGroup){
        // kakao.xml를 불러오기
        Context context=viewGroup.getContext();

        if(view==null){  ////// 리스트뷰를 의미하는 view 이다.
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.kakao,viewGroup,false);
        }
        ImageView img =view.findViewById(R.id.img);  ///// 액티비티가 없기 때문에 view에서 그 정보를 찾아낸다
        TextView tv_name=view.findViewById(R.id.tv_name);
        TextView tv_message=view.findViewById(R.id.tv_message);
        TextView tv_music=view.findViewById(R.id.tv_music);

        KakaoVO vo=items.get(i);
        img.setImageDrawable(vo.getImg() );
        tv_name.setText(vo.getName());
        tv_message.setText(vo.getMessage());
        tv_music.setText(vo.getMusic());


        return view;

        }
    }
