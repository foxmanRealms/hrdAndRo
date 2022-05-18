package com.example.ex220516;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MemberList extends AppCompatActivity {

    private ListView listView; // 리스트뷰 객체
    private ArrayAdapter<String> adapter; // 리스트뷰에 적용되는 어댑터
    private ArrayList<String> items = new ArrayList<String>();

    private RequestQueue requestQueue;
    private StringRequest stringRequest; ///// 서버통신이 필요하기 때문에 2가지 객체 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        listView=findViewById(R.id.listview);  ///// 객체 찾기

        sendRequest();




    }

    public void sendRequest(){
            // Request 객체 생성
            requestQueue= Volley.newRequestQueue(getApplicationContext()); ///// 안쪽 내용을 this로 대체할수있다
            // 서버에 요청할 주소
            String url="http://211.48.228.42:8081/web/memberList.do";


            // 요청시 필요한 문자열 객체
            stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                // 응답데이터를 받아오는 곳 ///// 서버와 통신하면 마지막에 넘어오는 곳이다
                @Override
                public void onResponse(String response) {
                    Log.v("resultValue",response);
                    try {
                        JSONArray jsonArray=new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                           JSONObject jsonObject = jsonArray.getJSONObject(i);
                            // jsonobject에는 회원들의 정보가 담겨있다
                            // 회원들의 정보를 리스트뷰에 보이게 하시오
                            // 1. ~~~~~  
                            // 2. ~~~~~ 처럼
                            String id=jsonObject.getString("id");
                            String pw=jsonObject.getString("pw");
                            String nick=jsonObject.getString("nick");
                            String phone=jsonObject.getString("phone");

                            items.add((i+1)+". "+id+". "+pw+". "+nick+". "+phone )  ;

                            adapter= new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);

                            listView.setAdapter(adapter);

                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
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

                    return params;
                }
            };
            stringRequest.setTag("main");  ///// 이곳은 구분자다. 보내오는 곳?을 확인하는것
            requestQueue.add(stringRequest);  ///// 이곳이 더 중요하다



        }




    }



