package com.xgy.network;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class MySocket {

	public static void main(String[] args) {
		
		try {
			InetAddress ip = InetAddress.getByName("localhost");
			System.out.println("�Ƿ�ɵ���  : " + ip.isReachable(2000));
			System.out.println("ip : " + ip.getHostAddress());
			
			InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});
			System.out.println("�Ƿ�ɵ���  : " + local.isReachable(2000));
			System.out.println(local.getCanonicalHostName());//��ȡ������
			
			@SuppressWarnings("resource")
			ServerSocket sListen = new ServerSocket(12345);
			System.out.println("����������......");
			
			while(true)
			{
				Socket s = sListen.accept();
				//System.out.println("��" + count + "���ͻ��� ip = " + s.get + ", port = " + );
				PrintStream ps = new PrintStream(s.getOutputStream());
				ps.println("xgy");
				
				ps.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
