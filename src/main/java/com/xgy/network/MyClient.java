package com.xgy.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class MyClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            Socket s = new Socket("127.0.0.1", 12345);
            new Thread(new ClientThread(s)).start();

            PrintStream ps = new PrintStream(s.getOutputStream());
            String line = null;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while ((line = br.readLine()) != null) {
                ps.println(line);
            }
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

class ClientThread implements Runnable {
    Socket s = null;
    BufferedReader br = null;

    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void run() {

        try {
            String content = null;
            while ((content = br.readLine()) != null) {
                System.out.println(content);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
