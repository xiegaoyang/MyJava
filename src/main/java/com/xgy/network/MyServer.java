package com.xgy.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class MyServer {

    public static List<Socket> socketList = new ArrayList<Socket>();

    private static int port = 12345;

    public static void main(String[] args) throws IOException {

        @SuppressWarnings("resource")
        ServerSocket ss = new ServerSocket(port);
        System.out.println("server start ...... ");
        while (true) {
            Socket s = ss.accept();
            socketList.add(s);
            new Thread(new ServerThread(s)).start();
        }

    }

}

class ServerThread implements Runnable {
    Socket s = null;
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public void run() {

        try {
            String content = null;
            while ((content = readFromClient()) != null) {
                for (Socket s : MyServer.socketList) //�����пͻ��˷���
                {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromClient() {
        try {
            return br.readLine();
        } catch (IOException e) {
            MyServer.socketList.remove(s);
        }
        return null;
    }


}
