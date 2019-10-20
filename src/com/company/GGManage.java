package com.company;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class GGManage {
    public  void auto(){
        String sUrl="http://202.193.80.124/a70.htm";//网址
        //webclient设置
        WebClient webClient = new WebClient(BrowserVersion.CHROME); //创建一个webclient
        webClient.getOptions().setJavaScriptEnabled(true); // 启动JS
        webClient.getOptions().setUseInsecureSSL(true);//忽略ssl认证
        webClient.getOptions().setCssEnabled(false);//禁用Css，可避免自动二次请求CSS进行渲染
        webClient.getOptions().setThrowExceptionOnScriptError(false);//运行错误时，不抛出异常
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());// 设置Ajax异步
        //登录
        try {
            HtmlPage page = (HtmlPage) webClient.getPage(sUrl);


            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HtmlForm form=page.getFormByName("f1");
            HtmlTextInput  txtUName = (HtmlTextInput )form.getInputByName("DDDDD"); //用户名text框
            txtUName.setValueAttribute("s3172052051626");
            HtmlPasswordInput txtPwd = (HtmlPasswordInput)form.getInputByName("upass");//密码框
            txtPwd.setValueAttribute("123456");
            //submit没有name，只有class和value属性，通过value属性定位元素
            HtmlSubmitInput submit=(HtmlSubmitInput) form.getInputByValue("登录");//0MKKey
            page = (HtmlPage) submit.click();//登录进入
            webClient.waitForBackgroundJavaScript(10000);//等待1秒

            System.out.println(page.asText());
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
//
//文链接：https://blog.csdn.net/u013592964/article/details/52097874
//        为了用手机登录校网时不用一遍一遍的输入账号密码，于是决定用爬虫抓取学校登录界面，然后模拟填写本次保存的账号、密码，模拟点击登录按钮。实现过程折腾好几个。
//        一开始选择的是htmlunit解析登录界面html，在pc上测的能实现，结果在android上运行不起来，因为htmlunit利用了javax中的类实现的解析，android不支持javax，所以就跑不起来。
//        不过pc还是ok的
//        ————————————————
//        版权声明：本文为CSDN博主「_Yasin」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/u013592964/article/details/52097874