package com.weixin.weixin1991.weixin.utils;

import com.weixin.weixin1991.weixin.pojo.TemplateMsg;
import org.junit.Test;
import sun.plugin2.message.Message;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MessageUtilTest {
    @Test
    public void postTemplateMsg() throws Exception {
        TemplateMsg tm=new TemplateMsg();
        tm.setTouser("oima80QqfopAfyshy1xLEusAkw-c");
        tm.setTemplate_id("b2yec6Hmhg1MHpznQuQ1qigLyneluAZ9-kcYUBTwfJY");
        tm.setUrl("http://www.baidu.com");
        Map<String ,Object> map=new HashMap<>();
        Map<String ,String> map1=new HashMap<>();
        map1.put("value","12334");
        map1.put("color","#ff0000");
        map.put("note1",map1);
        Map<String ,String> map2=new HashMap<>();
        map2.put("value","1万元");
        map2.put("color","#ff0000");
        map.put("note2",map2);
        tm.setData(map);
        String json = MessageUtil.postTemplateMsg(tm);
        System.out.println(json);
    }

}