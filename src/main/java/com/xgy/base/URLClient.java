package com.xgy.base; /**
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author shyboy(chao.shen@duoguo.cn)
 *
 */
public class URLClient {
	
	StringBuilder sb = new StringBuilder();

	/**
	 * ���ӵ���������������������ĵ�
	 *
	 * @param urlString
	 *            ���ĵ���ַ
	 * @return��String
	 */
	public String getDocumentAt(String urlString) {
		try {
			URL url = new URL(urlString);// ����url����
			URLConnection urlConnection = url.openConnection();// ��url����
			BufferedReader br = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream()));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (MalformedURLException e) {
			System.out.println("�������ӵ�URL��" + urlString);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���ӵ�URL�׳��쳣��Ϣ��" + urlString);
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URLClient client = new URLClient();
		String url = client.getDocumentAt("http://www.baidu.com");
		System.out.println(url);
	}
}