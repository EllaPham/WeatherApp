package com.projects.trang.myweather.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Trang on 1/31/2019.
 */

public class helper {
    static String stream = null;
    public String GetHTTPData(String urlString){

        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            System.out.println("Response code: " + httpURLConnection.getResponseCode());
            if(httpURLConnection.getResponseCode()==200){
                BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = r.readLine())!= null){
                    sb.append(line);
                }
                stream = sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
