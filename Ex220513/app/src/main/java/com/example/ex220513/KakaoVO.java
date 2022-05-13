package com.example.ex220513;

import android.graphics.drawable.Drawable;

public class KakaoVO {

    private Drawable img;
    private String name;
    private String message;
    private String music;

    public Drawable getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

    public KakaoVO(Drawable img, String name, String message, String music) {
        this.img = img;
        this.name = name;
        this.message = message;
        this.music = music;
    }

    public KakaoVO() {

    }

    @Override
    public String toString() {
        return "KakaoVO{" +
                "img=" + img +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", music='" + music + '\'' +
                '}';
    }
}
