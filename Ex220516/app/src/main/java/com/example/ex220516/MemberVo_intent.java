package com.example.ex220516;

import java.io.Serializable;

public class MemberVo_intent implements Serializable{
        ///// 시리얼자이블로 구현되었다
    private String id;
    private String pw;
    private String nick;
    private String phone;

    @Override
    public String toString() {
        return "MemberVo{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", nick='" + nick + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public MemberVo_intent() {

    }


    public MemberVo_intent(String id, String pw, String nick, String phone) {
        this.id = id;
        this.pw = pw;
        this.nick = nick;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
