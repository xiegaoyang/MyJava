package com.xgy.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 16-10-20.
 */
public class MyFolder {

    private String dir = "";


    MyFolder() {

    }

    MyFolder(String dir) {
        this.dir = dir;
    }

    public List<String> transverseFolder() {

        if (dir.equals("")) {
            return null;
        }

        List<String> fileList = new ArrayList<String>();
        File file = new File(dir);
        String[] ls = file.list();
        for (int i = 0; i < ls.length; ++i) {
            System.out.println(ls[i]);
            fileList.add(ls[i]);
        }
        return fileList;
    }
}
