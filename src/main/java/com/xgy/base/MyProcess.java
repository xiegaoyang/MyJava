package com.xgy.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Process p = null;
		
			try {
				p = Runtime.getRuntime().exec("notepad.exe");
				
				//��ȡ�ӽ������
				String line = null;
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while((line = br.readLine()) != null)
				{
					System.out.println(line);
				}
				
				//�ȴ������˳�
				p.waitFor();
				
				
				
				
				
				
				System.out.println("Program exit.");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}
