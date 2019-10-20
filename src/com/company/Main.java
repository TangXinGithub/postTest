package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        //连接
        pingANDconnection();
           HostIP();
    }


    public static void pingANDconnection(){

        //ping baidu.com
        NetState netState = new NetState();
        // System.out.println(netState.isConnect());//返回true

        if (netState.isConnect() == false)
        // new PostRun().start();//post请求
//这两个都可以
        {
            try {
                Thread.sleep(1000*60);//1分钟检测一次
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( netState.isConnect()==false)//再ping一次

            {  new GGManage().auto();}
        }

        try {
            Thread.sleep(1000*60);//1分钟检测一次
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    public  static void HostIP(){
        //ip
       getIP ip = new getIP();
      String ss= ip.muliIP();


//        cmd下ipconfig
        String s = null;
        try {
            s = cmd.ipconfig();
          s=s.replaceAll("\\[|\\]|<", "");//去掉非法字符
        } catch (IOException e) {
            e.printStackTrace();
        }
        //发送ip
        PostRun ippost=new PostRun();
        ippost.link="http://tangxin.32haodktkg5.duihuanche.com/index.php/index/Getip/writeip";
        ippost.data=ss+"\n"+s;
        System.out.println(ippost.data);
        ippost.run();
    }
    public void waitTracer(){//java等待线程
        int threadNumber = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNumber);
        countDownLatch.countDown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

