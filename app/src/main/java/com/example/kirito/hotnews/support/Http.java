package com.example.kirito.hotnews.support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kirito on 2016.11.01.
 */

public class Http {

    public static String getDataFromUrl(String strUrl){
        HttpURLConnection con = null;
        StringBuilder sb = null;
        try {
            sb = new StringBuilder();
            URL url = new URL(strUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setReadTimeout(8000);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String s = "";
            while ((s = br.readLine()) != null){
                sb.append(s);
            }
            br.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (con != null){
                con.disconnect();
            }
        }
        return sb.toString();
    }
}
