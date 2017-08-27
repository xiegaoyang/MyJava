package com.xgy.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/10/23.
 */
public class MyHttpClient {

    public static void main(String[] args) {

        URL url = null;
        StringBuilder sb = new StringBuilder();

        try {
            url = new URL("http://127.0.0.1:8080/rest/MyRestJaxrs/xiegy");
            URLConnection urlConnection = url.openConnection();                                                    // 打开连接
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf-8")); // 获取输入流
            String line = null;

            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(sb.toString());
    }

    public boolean GetSingleParameter() {
        return true;
    }

    public boolean GetMultiParameter() {
        return true;
    }

    public boolean PostJson() {
        return true;
    }

    public boolean PostXml() {
        return true;
    }


}
