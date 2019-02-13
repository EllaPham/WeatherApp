package com.projects.trang.myweather.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by Trang on 1/29/2019.
 */
// preference: https://www.youtube.com/watch?v=wAV2Uqv9KLo

public class common {
    public static String API_KEY="a65cb9d27ae75340ac7115646fed14ec";
    public static String API_LINK = "https://api.openweathermap.org/data/2.5/weather";

    public static String APIRequest(String lat, String lng) {
        StringBuilder sb = new StringBuilder(API_LINK);
        sb.append(String.format("?lat=%s&lon=%s&APPID=%s&units=metric", lat, lng, API_KEY));
        return sb.toString();
    }
    public static String UnixTimeStampToDateTime(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long)unixTimeStamp*1000);
        return dateFormat.format(date);
    }
    public static String GetImagine(String icon){

        return String.format("https://openweathermap.org/img/w/%s.png",icon);
    }
    public static String GetDateNow(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }

    }
