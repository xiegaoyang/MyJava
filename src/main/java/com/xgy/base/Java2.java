package com.xgy.base;


public class Java2 {

    public static void main(String[] args) {

        Human xgy = new Human();
        Class c1 = xgy.getClass();
        System.out.println(c1.getName());

        calSize();

//		IO1 io = new IO1();
//		io.TestIO1();

        //MyFile.TestFile();
//		MyFile file = new MyFile();
//		file.TestFile();
//		MyFile.BianLiFolder();

//		URLClient client = new URLClient();  
//	    String yahoo = client.getDocumentAt("http://www.yahoo.com");  
//	    System.out.println(yahoo); 

        TestSystem();
    }

    private static void calSize() {
        System.out.println("Integer: " + Integer.SIZE / 8);           // 4
        System.out.println("Short: " + Short.SIZE / 8);               // 2
        System.out.println("Long: " + Long.SIZE / 8);                 // 8
        System.out.println("Byte: " + Byte.SIZE / 8);                 // 1
        System.out.println("Character: " + Character.SIZE / 8);       // 2
        System.out.println("Float: " + Float.SIZE / 8);               // 4
        System.out.println("Double: " + Double.SIZE / 8);             // 8
        //System.out.println("Boolean: " + Boolean);  
    }

    public static void TestSystem() {
        String version = System.getProperty("java.version");
        System.out.println(version);
        String home = System.getProperty("java.home");
        System.out.println(home);
        String osName = System.getProperty("os.name");
        System.out.println(osName);
        String osVersion = System.getProperty("os.version");
        System.out.println(osVersion);
        String username = System.getProperty("user.name");
        System.out.println(username);
        String oshome = System.getProperty("user.home");
        System.out.println(oshome);
        String userdir = System.getProperty("user.dir");
        System.out.println(userdir);
    }

}

class Human {
    private int a = 9;
}