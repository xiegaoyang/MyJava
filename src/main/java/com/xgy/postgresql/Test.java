package com.xgy.postgresql;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by hadoop on 2017/4/3.
 */

public class Test {

    private final String IP = "172.16.7.93";
    private final String PORT = "5433";
    private final String DB = "voip_log";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "pqdAD34rASDF";
    private final String DRIVER = "jdbc:postgresql://";


    public String writeFile(List<JSONObject> list){

        FileWriter out = null;
        String filePath = "xgy-" + UUID.randomUUID();

        try{
            out = new FileWriter(new File(filePath));
            for(int i=0;i<list.size();i++){
                Object[] objs = list.get(i).values().toArray();
                for(int j=0;j<objs.length;j++){
                    if(objs[j] == null){
                        out.write("null");
                    }else{
                        out.write(String.valueOf(objs[j]));
                    }
                    if(j != objs.length - 1){
                        out.write(",");
                    }
                }
                if(i != list.size() - 1){
                    out.write("\n");
                }
            }
            out.flush();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return filePath;
    }

    public void copyTest(String tablename,List<MyPerson> list){

        Connection conn = null;
        CopyManager copyManager = null;
        FileReader reader = null;

        try{

            long starttime = System.currentTimeMillis();

            JSONArray array = JSONArray.fromObject(list);
            System.out.println(array.toString());

//            String filePath = writeFile(array);
            String filePath = "ebensz-27ba600c-79b7-4b09-8d44-accd7aad766f";

            String url = DRIVER + IP + ":" + PORT + "/" + DB;

            conn = DriverManager.getConnection(url, USERNAME, PASSWORD);
            copyManager = new CopyManager((BaseConnection)conn);
            reader = new FileReader(new File(filePath));
            copyManager.copyIn("copy "+tablename+" from stdin delimiter as '#' NULL as 'null'",reader);
            long endtime = System.currentTimeMillis();

            System.out.println(endtime-starttime);

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
//        List<JSONObject> list = new ArrayList<JSONObject>();
        List<MyPerson> list = new ArrayList<MyPerson>();
        for(int i=0;i<12;i++){
//            JSONObject jsonObject = new JSONObject();
            MyPerson myPerson = new MyPerson();
            myPerson.name = "xgy-" + i;
            myPerson.sex = "男";
            myPerson.work = "it-" + i;
//            jsonObject.put("name","xgy-" + i);
//            jsonObject.put("sex","男");
//            jsonObject.put("work","it-" + i);
//            list.add(jsonObject);
            list.add(myPerson);
        }



        new Test().copyTest("voip_2017_01", list);
    }
}
