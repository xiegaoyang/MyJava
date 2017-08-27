package com.xgy.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/11/15.
 */

public class MyHttp {

    public static void main(String[] args) {
        HttpClient httpclient = new DefaultHttpClient();
        try {
            HttpGet httpget = new HttpGet("http://www.apache.org/");
            System.out.println("executing request " + httpget.getURI());
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (null == entity) {
                return;
            }

            System.out.println("----------------------------------------");
            System.out.println(response.getStatusLine());
            System.out.println("Response content length: " + entity.getContentLength());
            System.out.println("----------------------------------------");

            InputStream inSm = entity.getContent();
            Scanner inScn = new Scanner(inSm);
            while (inScn.hasNextLine()) {
                System.out.println(inScn.nextLine());
            }
            // Do not feel like reading the response body
            // Call abort on the request object
            httpget.abort();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // When HttpClient instance is no longer needed,
            // shut down the connection manager to ensure
            // immediate deallocation of all system resources
            httpclient.getConnectionManager().shutdown();
        }
    }

}
