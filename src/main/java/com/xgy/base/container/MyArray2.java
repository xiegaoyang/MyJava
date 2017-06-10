package com.xgy.base.container;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;

public class MyArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] aArray = new String[5];
		String[] bArray = { "a", "b", "c", "d", "e" };
		String[] cArray = new String[] { "a", "b", "c", "d", "e" };
		
		
//		String[] stringArray = { "a", "b", "c", "d", "e" };
//		boolean b = Arrays.asList(stringArray).contains("a");
//		System.out.println(b);



		int[] intArray = { 1, 2, 3, 4, 5 };
		String intArrayString = Arrays.toString(intArray);

		// print directly will print reference value
		System.out.println(intArray);
		// [I@7150bd4d

		System.out.println(intArrayString);
		// [1, 2, 3, 4, 5]
		
		String[] stringArray = { "a", "b", "c", "d", "e" };
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
		System.out.println(arrayList);
		// [a, b, c, d, e]
		
		
		//ArrayUtils��Apache�ṩ�����鴦����⣬��addAll�������Ժܷ���ؽ������������ӳ�һ�����顣
//		int[] intArray = { 1, 2, 3, 4, 5 };
//		int[] intArray2 = { 6, 7, 8, 9, 10 };
//		// Apache Commons Lang library
//		int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
		
		byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();

		for (byte t : bytes) {
		System.out.format("0x%x ", t);
		}
	}

}
