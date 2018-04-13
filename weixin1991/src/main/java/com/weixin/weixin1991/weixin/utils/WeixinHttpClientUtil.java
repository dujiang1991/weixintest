package com.weixin.weixin1991.weixin.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeixinHttpClientUtil {
    public static String postReq(String url, String data, String type) {
        {
            CloseableHttpClient client = null;
            CloseableHttpResponse resp = null;
            try {
                client = HttpClients.createDefault();
                HttpPost post = new HttpPost(url);

                post.addHeader("content-Type", type);
                StringEntity entity = new StringEntity(data, ContentType.create(type,
                        "UTF-8"));
                post.setEntity(entity);
                resp = client.execute(post);
                int code = resp.getStatusLine().getStatusCode();
                if (code >= 200 && code < 300) {

                    String str = EntityUtils.toString(resp.getEntity());
                    System.out.println(str);
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (resp != null) {
                    try {
                        resp.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

    public static String getReq(String url) {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try {
            client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            resp = client.execute(get);
            int code = resp.getStatusLine().getStatusCode();

            if (code >= 200 && code < 300) {
                HttpEntity entity = resp.getEntity();
                String json = EntityUtils.toString(entity);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
