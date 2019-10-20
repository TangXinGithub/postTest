package com.company;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class getIP {

    public  void GETIP() throws UnknownHostException {
               // TODO Auto-generated method stub
             InetAddress ia=null;

                 ia = ia.getLocalHost();

                 String localname = ia.getHostName();
                 String localip = ia.getHostAddress();
                 System.out.println("本机名称是：" + localname);
                 System.out.println("本机的ip是 ：" + localip);
               log.logResult(localname);
                 log.logResult(localip);


             }
              String s;
    public  String muliIP() {
        Enumeration<NetworkInterface> netInterfaces;
        try {
            // 拿到所有网卡
            netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            // 遍历每个网卡，拿到ip
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = addresses.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
                        //System.out.println(ni.getName() + " " + ip.getHostAddress());
                        s=s+"\n"+ni.getName() + " " + ip.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
        }
        return s;
    }

}
