package com.weixin.weixin1991.weixin.controller;

import com.weixin.weixin1991.weixin.service.WeixinService;
import com.weixin.weixin1991.weixin.utils.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@Controller
public class WeixinBaseController {

    @Autowired
    private WeixinService weixinService;

    //接入微信
    @GetMapping("/accessWeixin")
    public void accessWeixin(HttpServletRequest request, HttpServletResponse response) {
        //获取微信后台传入的四个参数
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        boolean flag = weixinService.checkSignature(signature, timestamp, nonce);

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
//接收消息
    @PostMapping("/accessWeixin")
    public void wgetInfo(HttpServletRequest
                                 request, HttpServletResponse
                                 response) throws IOException, DocumentException {
        Map<String, String> msg = MessageUtil.req2map(request);

        String resCon = MessageUtil.handleMsg(msg);
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        System.out.println(resCon);
        response.getWriter().write(resCon);

    }
}
