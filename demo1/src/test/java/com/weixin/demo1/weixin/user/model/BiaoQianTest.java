package com.weixin.demo1.weixin.user.model;

import com.weixin.demo1.msg.MessageKit;
import com.weixin.demo1.weixin.user.tag.BiaoQian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BiaoQianTest {
    @Test
    public void psotBiaoqian() throws Exception {
        Map<String, Object> map = new HashMap<>();
        TagEntity tag=new TagEntity("江西");
        map.put("tag",tag);
        BiaoQian.psotBiaoqian(map);


    }

}