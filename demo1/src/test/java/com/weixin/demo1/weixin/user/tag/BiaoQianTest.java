package com.weixin.demo1.weixin.user.tag;

import com.weixin.demo1.weixin.user.model.TagEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BiaoQianTest {
    @Test
    public void updateTag() throws Exception {
        Map<String ,Object> map=new HashMap<>();
        TagEntity tag=new TagEntity();
        tag.setId(101);
        tag.setName("李白");
        map.put("tag",tag);
     String json=   BiaoQian.updateTag(map);
        System.out.println(json);
    }

    @Test
    public void getTag() throws Exception {
      String json=  BiaoQian.getTag();
        System.out.println(json);
    }

}