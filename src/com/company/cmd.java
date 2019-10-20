package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class cmd {

    public static  String ipconfig() throws IOException {
        String command = "cmd.exe /c tracert -h 4 tangxin.32haodktkg5.duihuanche.com";//路由地址
        Process p = null;

        {
            try {
                p = Runtime.getRuntime().exec(command);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(p.getInputStream(),"GB2312"));

        //保存到s
           String temp;
            String s = "";
            while((temp = br.readLine()) != null)
           {
                 s = s + temp;

           }
    br.close();
    return s;
    }

}