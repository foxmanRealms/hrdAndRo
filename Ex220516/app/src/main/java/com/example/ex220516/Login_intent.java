package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login_intent extends AppCompatActivity {

    private EditText edt_login_id,edt_login_pw;
    private Button btn_login;
    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_login_id= findViewById(R.id.edt_login_id);
        edt_login_pw= findViewById(R.id.edt_login_pw);
        btn_login= findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendReqeust();
            }
        });

    }

    public void sendReqeust(){
        // Request 객체 생성
        requestQueue= Volley.newRequestQueue(getApplicationContext()); ///// 안쪽 내용을 this로 대체할수있다
        // 서버에 요청할 주소
        String url="http://211.48.228.42:8081/web/andLogin.do";


        // 요청시 필요한 문자열 객체
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            // 응답데이터를 받아오는 곳 ///// 서버와 통신하면 마지막에 넘어오는 곳이다
            @Override
            public void onResponse(String response) {
                Log.v("resultValue",response);
                //Log.v("resultValue",response.length() +"");
                if (response.length() > 0) {
                    //로그인 성공
                    try {
                        JSONObject jsonObject=new JSONObject(response);
                        String id=jsonObject.getString("id");
                        String pw=jsonObject.getString("pw");
                        String nick=jsonObject.getString("nick");
                        String phone=jsonObject.getString("phone");
                        Log.v("resultValue",id+"/"+pw+"/"+nick+"/"+phone);
                        // 로그인 성공시 id,pw,nick,phone 데이터를 LoginSucecess Activity로
                        // 전달하여서 TextView에 보여주게하시오
                        // 단, MemberVo를 만들어서 활용할 것.

                         MemberVo_intent vo= new MemberVo_intent(id,pw,nick,phone); ///// 인텐트로 넘겨줄때 사용하던 코드
                        ///// 페이지를 넘어가려면 인텐트가 필요하다
                        Intent intent=new Intent(getApplicationContext(), LoginSuccess_intent.class);
                        ///// 인텐트는 기본자료형들만 기본적으로 지원하기 떄문에 vo를 직렬화해서 넣어주어야함
                        intent.putExtra("vo",vo);
                        startActivity(intent);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }else{
                    //로그인 실패
                    Toast.makeText(getApplicationContext() , "로그인 실패",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            // 서버와의 연동 에러시 출력
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override //response를 UTF8로 변경해주는 소스코드
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }


            // 보낼 데이터를 저장하는 곳 ///// 이곳이 중요하다
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                String id=edt_login_id.getText().toString();
                String pw=edt_login_pw.getText().toString();

                params.put("id",id );
                params.put("pw",pw );

//                edt_id.setText("");   ///// 입력했던 내용을 초기화시켜서 다음 입력을 편리하게 만든다 동시에 처리하다보니까 안되는 것이었다 임시로 주석처리
//                edt_pw.setText("");
//                edt_nick.setText("");
//                edt_phone.setText("");


                return params;
            }
        };
        stringRequest.setTag("main");  ///// 이곳은 구분자다. 보내오는 곳?을 확인하는것
        requestQueue.add(stringRequest);  ///// 이곳이 더 중요하다



    }
}