package com.xgy.network;

import java.io.*;
import java.security.cert.*;
import java.text.SimpleDateFormat;
import java.util.*;

class CertManager {
	private String certName = "";
	public CertManager(String certName) {
		this.certName = certName;
	}

	public void showCertInfo() {
		try {
			// ��ȡ֤���ļ�
			File file = new File(certName);
			InputStream inStream = new FileInputStream(file);
			// ����X509������
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			// ����֤�����
			X509Certificate oCert = (X509Certificate) cf.generateCertificate(inStream);
			inStream.close();
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
			String info = null;

			// ���֤��汾
			info = String.valueOf(oCert.getVersion());
			System.out.println("֤��汾:" + info);
			// ���֤�����к�
			info = oCert.getSerialNumber().toString(16);
			System.out.println("֤�����к�:" + info);
			// ���֤����Ч��
			Date beforedate = oCert.getNotBefore();
			info = dateformat.format(beforedate);
			System.out.println("֤����Ч����:" + info);
			Date afterdate = oCert.getNotAfter();
			info = dateformat.format(afterdate);
			System.out.println("֤��ʧЧ����:" + info);
			// ���֤��������Ϣ
			info = oCert.getSubjectDN().getName();
			System.out.println("֤��ӵ����:" + info);
			// ���֤��䷢����Ϣ
			info = oCert.getIssuerDN().getName();
			System.out.println("֤��䷢��:" + info);
			// ���֤��ǩ���㷨����
			info = oCert.getSigAlgName();
			System.out.println("֤��ǩ���㷨:" + info);

			byte[] byt = oCert.getExtensionValue("1.2.86.11.7.9");
			String strExt = new String(byt);
			System.out.println("֤����չ��:" + strExt);
			byt = oCert.getExtensionValue("1.2.86.11.7.1.8");
			String strExt2 = new String(byt);
			System.out.println("֤����չ��2:" + strExt2);
		} catch (Exception e) {
			System.out.println("����֤�����");
		}
	}// end showCertInfo
}


public class MyHttps {


	public static void main(String[] args) {

		CertManager certManager = new CertManager("G:/server.crt");
		certManager.showCertInfo();

	}

}
