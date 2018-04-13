package com.weixin.demo1.service.impl;

import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.model.WeixinMenu.WeixinMenu;
import com.weixin.demo1.util.GetAccessToken;
import com.weixin.demo1.util.JsonUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuTest {
    @Test
    public void testMenu() throws IOException {
        List<WeixinMenu> mes = new ArrayList<>();
        WeixinMenu m1 = new WeixinMenu();
        m1.setId(1);
        m1.setName("学习网站");
        m1.setType("view");
        m1.setUrl("http://www.baidu.com");
        mes.add(m1);
        WeixinMenu m2 = new WeixinMenu();
        m2.setName("测试资源");

        List<WeixinMenu> mes2 = new ArrayList<>();
        WeixinMenu m3 = new WeixinMenu();

        m3.setId(2);
        m3.setName("今日歌曲");
        m3.setType("click");
        m3.setKey("V1001_TODAY_MUSIC");
        mes2.add(m3);
        WeixinMenu m4 = new WeixinMenu();
        m4.setId(3);
        m4.setName("扫码带提示");
        m4.setType("scancode_waitmsg");
        m4.setKey("rselfmenu_0_0");
        mes2.add(m4);

        m2.setSub_button(mes2);
        mes.add(m2);
        Map<String, List<WeixinMenu>> map = new HashMap<>();
        map.put("button", mes);
        String json = JsonUtils.objectToJson(map);


        CloseableHttpClient client = HttpClients.createDefault();
        String url = WeisinFinalValue.MEMU_ADD;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());

        HttpPost post = new HttpPost(url);
        post.addHeader("Content-Type", "application/json");

        StringEntity entity=new StringEntity(json, ContentType.create("application/json","utf-8"));

        post.setEntity(entity);
        CloseableHttpResponse resp = client.execute(post);
        int code = resp.getStatusLine().getStatusCode();
        if (code>= 200 && code < 300 ){
            System.out.println(EntityUtils.toString(resp.getEntity()));
        }
    }

}
