package com.weixin.weixin1991.weixin.utils.Template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TemplateMessageUtilTest {
    @Test
    public void deleteTempalteMessage() throws Exception {
        Map<String ,String> map =new HashMap<>();
        map.put("template_id","6oylnopmOLOm8HquRDu-S8cjWJg7MACR9DsCiqN1Ols");
        String json = TemplateMessageUtil.deleteTempalteMessage(map);
        System.out.println(json);
    }

    @Test
    public void getTemplateList() throws Exception {
        String json = TemplateMessageUtil.getTemplateList();
        System.out.println(json);
    }

    @Test
    public void getTemplateMessageID() throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("template_id_short","1");
        String json  = TemplateMessageUtil.getTemplateMessageID(map);
        System.out.println(json);

    }

    @Test
    public void setIndustry() throws Exception {
        Map<String ,String> map=new HashMap<>();
        map.put("industry_id1","1");
        map.put("industry_id2","5");

        String json = TemplateMessageUtil.setIndustry(map);
        System.out.println(json);

    }

    @Test
    public void getIndustry() throws Exception {
        String json = TemplateMessageUtil.getIndustry();
        System.out.println(json);

    }

}