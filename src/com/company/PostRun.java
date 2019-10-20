package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//校园网登录

class PostRun extends Thread{
     String  link="http://202.193.80.124/a70.htm";
     String data="DDDDD=s3172052051626&upass=123456&R1=0&R2=&R3=0&R6=0&para=00&0MKKey=123456&buttonClicked=&redirect_url=&err_flag=&username=&password=&user=&cmd=&Login=&v6ip=";
        @Override
        public void run() {
            try {
                URL url = new URL(link);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.addRequestProperty("encoding", "UTF-8");//添加请求属性
                connection.setDoInput(true);//允许输入
                connection.setDoOutput(true);//允许输出
                connection.setRequestMethod("POST");//POST请求要在获取输入输出流之前设置否则报错
                //输出
                OutputStream os = connection.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(data);
                bw.flush();

                //输入
                InputStream in = connection.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String line;
                StringBuilder sb = new StringBuilder();
                while((line = br.readLine()) != null)
                {
                    sb.append(line);
                }
                bw.close();
                osw.close();
                os.close();
                br.close();
                isr.close();
                in.close();

                System.out.println("使用POST方式得：\n"+sb.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


