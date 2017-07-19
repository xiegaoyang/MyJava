package com.xgy.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyProcess {

    public static void main(String[] args) {

        Process p = null;

        try {
            p = Runtime.getRuntime().exec("notepad.exe");
            String line = null;
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            p.waitFor();
            System.out.println("Program exit.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
