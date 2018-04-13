package com.weixin.weixin1991.weixin.utils;

import com.weixin.weixin1991.weixin.pojo.AccessToken;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinAccessTokenTest {
    @Test
    public void getAccessToken() throws Exception {
      String json=  WeixinAccessToken.getAccessToken();
        AccessToken accessToken = JsonUtils.jsonToPojo(json, AccessToken.class);
        System.out.println(accessToken.getAccess_token());
    }

}