package com.weixin.demo1.weixin.user.remark;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRemarkTest {
    @Test
    public void getUsers() throws Exception {
      String json=  UserRemark.getUsers("oima80QqfopAfyshy1xLEusAkw-c");
        System.out.println(json);
    }

    @Test
    public void getUserInfo() throws Exception {
    String json=    UserRemark.getUserInfo("oima80QqfopAfyshy1xLEusAkw-c");
        System.out.println(json);
    }

    @Test
    public void setUserRemark() throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("openid","oima80QqfopAfyshy1xLEusAkw-c");
        map.put("remark","傻子");
       String json= UserRemark.setUserRemark(map);
        System.out.println(json);
    }

}