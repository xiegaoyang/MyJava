package com.xgy.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * Created by hadoop on 2017/8/31.
 */
public class HttpUtil {


    /**
     * 获取连接
     *
     * @param urlName
     * @param method
     * @param paramMap
     * @param data
     * @return
     */
    protected static HttpURLConnection getConnection(String urlName, String method, Map<String, String> paramMap, String data) {

        URL url;
        HttpURLConnection conn = null;

        try {

            url = new URL(urlName);
            conn = (HttpURLConnection) url.openConnection();

            /*设置连接属性*/
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            conn.setDoOutput(true);

            // 设置是否从httpUrlConnection读入，默认情况下是true;
            conn.setDoInput(true);

            // 设定请求的方法为"POST"，默认是GET
            conn.setRequestMethod(method);

            // 设定传送的内容类型是可序列化的java对象
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            //"Content-type", "application/x-java-serialized-object"
            for (Map.Entry<String, String> item : paramMap.entrySet()) {
                conn.setRequestProperty(item.getKey(), item.getValue());
            }
            //有可能需要添加下面
            //conn.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            //conn.setRequestProperty("Content-Length", String.valueOf(data.length()));

            //超时设置
            conn.setConnectTimeout(3 * 1000);
            conn.setReadTimeout(3 * 1000);

            // 连接，从上述第2条中url.openConnection()至此的配置必须要在connect之前完成，
            conn.connect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }

    /**
     * @param is
     * @return
     */
    public static byte[] streamToByte(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int c = 0;
        byte[] buffer = new byte[8 * 1024];
        try {
            while ((c = is.read(buffer)) != -1) {
                baos.write(buffer, 0, c);
                baos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }

    /**
     * @param urlName
     * @param method
     * @param paramMap
     * @param data
     * @return 返回字符流，需要考虑编码
     */
    public static String sendRequestWithString(String urlName, String method, Map<String, String> paramMap, String data) {

        HttpURLConnection conn = getConnection(urlName, method, paramMap, data);

        StringBuffer sb = new StringBuffer();
        String line;

        BufferedReader in = null;
        DataOutputStream out;

        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            out = new DataOutputStream(conn.getOutputStream());

            //写入数据
            if (null != data) {
                out.writeBytes(data);
                out.flush();
                out.close();
            }

            //读取数据
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    /**
     * @param urlName
     * @param method
     * @param paramMap
     * @param data
     * @return 返回字节流
     */
    public static byte[] sendRequestWithByte(String urlName, String method, Map<String, String> paramMap, String data) {

        HttpURLConnection conn = getConnection(urlName, method, paramMap, data);

        BufferedInputStream in = null;
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(conn.getOutputStream());
            //写入数据
            if (null != data) {
                out.writeBytes(data);
                out.flush();
                out.close();
            }

            //响应
            if (!String.valueOf(conn.getResponseCode()).startsWith("2")) {
                return null;
            }

            // 判断跟服务器的连接状态。如果是200，则说明连接正常，服务器有响应
            // 服务器有响应后，会将访问的url页面中的内容放进inputStream中，
            // 使用httpConn就可以获取到这个字节流
            in = new BufferedInputStream(conn.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return streamToByte(in);
    }


}
