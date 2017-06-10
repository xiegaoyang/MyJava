package com.xgy.rmi;

import java.rmi.*;

public class RMISrv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��SecurityManagerװ����
		System.setSecurityManager(new RMISecurityManager());
		
		
	}

}
