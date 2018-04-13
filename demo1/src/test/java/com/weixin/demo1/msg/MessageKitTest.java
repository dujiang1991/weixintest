package com.weixin.demo1.msg;

import com.weixin.demo1.pojo.ModelMsgData;
import com.weixin.demo1.pojo.TemplateMsg;
import com.weixin.demo1.util.JsonUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MessageKitTest {
    @Test
    public void postTemplateMsg() throws Exception {
        TemplateMsg tm=new TemplateMsg();

        tm.setTouser("oima80QqfopAfyshy1xLEusAkw-c");
        tm.setTemplate_id("6oylnopmOLOm8HquRDu-S8cjWJg7MACR9DsCiqN1Ols");
        tm.setTopcolor("#ff0000");
        tm.setUrl("http://www.baidu.com");
        Map<String,Object> data=new HashMap<>();
        data.put("num",new ModelMsgData("123","#FF1493"));
        tm.setData(data);
        System.out.println(JsonUtils.objectToJson(tm));
        MessageKit.postTemplateMsg(tm);



    }

    @Test
    public void handleMsg() throws Exception {
        Map<String ,String> map=new HashMap<>();
        map.put("Content","123");
        map.put("ToUserName","dd");
        map.put("FromUserName","vvv");
        String s = MessageKit.map2xml(map);
        System.out.println(s);


    }

}