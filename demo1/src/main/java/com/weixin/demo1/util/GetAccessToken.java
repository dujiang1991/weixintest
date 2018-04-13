package com.weixin.demo1.util;

import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.pojo.AccessToke;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetAccessToken {

    public static String  gettoken() {
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

                AccessToke accessToke = JsonUtils.jsonToPojo(s, AccessToke.class);
              return accessToke.getAccess_token();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
return null;
    }
}
