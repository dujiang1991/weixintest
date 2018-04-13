package com.weixin.demo1.service.impl;

import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.pojo.AccessToke;
import com.weixin.demo1.util.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilServiceTest {
    @Test
    public void getSha1() throws Exception {
        UtilService u=new UtilService();
        String hello = u.getSha1("a");
        System.out.println(hello);

    }
    @Test
    public void httpclientTest() {
        try {
            CloseableHttpClient aDefault = HttpClients.createDefault();
            String url = WeisinFinalValue.ACCESS_TOKEN_URL;
            url=   url.replaceAll("APPID",WeisinFinalValue.APPID);
            url=  url.replaceAll("APPSECRET",WeisinFinalValue.APPSECRET);
            HttpGet get=new HttpGet(url);
            CloseableHttpResponse resp = aDefault.execute(get);
            int code= resp.getStatusLine().getStatusCode();
            System.out.println(code);
            if(code>=200 && code <300){
                HttpEntity entity = resp.getEntity();
                String s = EntityUtils.toString(entity);
                System.out.println(s);
                AccessToke accessToke = JsonUtils.jsonToPojo(s, AccessToke.class);
                System.out.println(accessToke.getAccess_token()+"你好"+accessToke.getExpires_in());

            }
        }catch (Exception e){
e.printStackTrace();
        }

    }

}