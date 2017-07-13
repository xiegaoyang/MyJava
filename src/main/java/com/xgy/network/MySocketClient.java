package com.xgy.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketTimeoutException;


public class MySocketClient {

    public static void main(String[] args) throws SocketTimeoutException {
        // TODO Auto-generated method stub
        try {
            Socket s = new Socket("127.0.0.1", 12345);
            s.setSoTimeout(5000);//���ó�ʱʱ��,����ʱ�����ӳ�ʱ

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line = br.readLine();
            System.out.println("data : " + line);

            br.close();
            s.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

    }

}
