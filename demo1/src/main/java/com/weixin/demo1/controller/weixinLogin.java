package com.weixin.demo1.controller;

import com.weixin.demo1.msg.MessageKit;
import com.weixin.demo1.service.impl.ServiceImf;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class weixinLogin {

    @GetMapping("test")
    public ModelAndView test() {
        return new ModelAndView("success");
    }


    @Autowired
    private ServiceImf service;

    @GetMapping("weixin1")
    public void loginByWechat(HttpServletRequest request, HttpServletResponse response) {
        //获取微信后台传入的四个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        boolean flag = service.checkSignature(signature, timestamp, nonce);
        System.out.println(flag);
        PrintWriter p = null;
        try {
            p = response.getWriter();
            if (flag) {
                p.print(echostr);//注意此处必须返回echostr以完成验证
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("weixin1")
    public void wgetInfo(HttpServletRequest
                                 request, HttpServletResponse
                                 response) throws IOException, DocumentException {
        Map<String, String> msg = MessageKit.req2map(request);

        String resCon = MessageKit.handleMsg(msg);
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(resCon);
        response.getWriter().write(resCon);

    }


}



