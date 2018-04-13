package com.weixin.weixin1991.weixin.utils;

import com.weixin.weixin1991.weixin.pojo.TemplateMsg;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.*;

public class MessageUtil {

    //回复的消息
    private static Map<String, String> respMsg = new HashMap<>();

    static {
        respMsg.put("hello", "world");
        respMsg.put("123", "你好");
        respMsg.put("run", "一路顺风");
    }

    public static Map<String, String> req2map(HttpServletRequest request) throws IOException, DocumentException {
        String xml = req2xml(request);
        Document document = DocumentHelper.parseText(xml);
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        Map<String, String> map = new HashMap<>();
        for (Element e : elements) {
            map.put(e.getName(), e.getTextTrim());
        }
        return map;
    }

    private static String req2xml(HttpServletRequest request) throws IOException {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        return sb.toString();

    }

    public static String handleMsg(Map<String, String> msg) throws IOException {
        String msgTpye = msg.get("MsgType");
        if (msgTpye.equals(WeixinFinalURL.MSG_TYPE_EVENT)) {

        } else if (msgTpye.equals(WeixinFinalURL.MSG_TYPE_TEXT)) {
            return textTypeHandler(msg);

        } else if (msgTpye.equals(WeixinFinalURL.MSG_TYPE_IMAGE)) {
            return imageTypeHandler(msg, "Q2aZRQMQ0KTRbItiM3bEE2VRF6nYjtD9vLD8WUpuMo3Et6fG8Z8338d4unMKVVfz");
        }
        return null;
    }

    private static String imageTypeHandler(Map<String, String> msg, String media_id) throws IOException {
        {
            Map<String, String> mymap = new HashMap<>();
            mymap.put("ToUserName", msg.get("FromUserName"));
            mymap.put("FromUserName", msg.get("ToUserName"));
            mymap.put("CreateTime", new Date().getTime() + "");
            mymap.put("MsgType", "image");
            mymap.put("Image", "<MediaId>" + media_id + "</MediaId>");

            return map2xml(mymap);
        }
    }

    private static String textTypeHandler(Map<String, String> msg) throws IOException {
        Map<String, String> mymap = new HashMap<>();
        mymap.put("ToUserName", msg.get("FromUserName"));
        mymap.put("FromUserName", msg.get("ToUserName"));
        mymap.put("CreateTime", new Date().getTime() + "");
        mymap.put("MsgType", "text");
        String respm = "您请求消息格式不正确";
        if (respMsg.containsKey(msg.get("Content"))) {
            respm = respMsg.get(msg.get("Content"));
        }
        mymap.put("Content", respm);
        return map2xml(mymap);
    }

    public static String map2xml(Map<String, String> mymap) throws IOException {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("xml");
        Set<String> keys = mymap.keySet();
        for (String key : keys) {
            root.addElement(key).addText(mymap.get(key));
        }
        StringWriter sw = new StringWriter();
        XMLWriter xw = new XMLWriter(sw);
        xw.setEscapeText(false);
        xw.write(document);


        return sw.toString();


    }

    //发送模版消息工具方法
    public static String postTemplateMsg(TemplateMsg tm) {
        String url = WeixinFinalURL.SEND_TEMPLATE_MSG;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        String json = JsonUtils.objectToJson(tm);
        return WeixinHttpClientUtil.postReq(url, json, "application/json");
    }


}
