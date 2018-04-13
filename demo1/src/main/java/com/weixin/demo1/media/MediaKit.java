package com.weixin.demo1.media;

import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.pojo.WeixinMedia;
import com.weixin.demo1.util.GetAccessToken;
import com.weixin.demo1.util.JsonUtils;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class MediaKit {
    public static String postMedia(String path, String type) {
        CloseableHttpClient client = null;
        CloseableHttpResponse resp = null;
        try {
            client = HttpClients.createDefault();
            String url = WeisinFinalValue.POST_MEDIA;
            url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
            url = url.replaceAll("TYPE", type);
            HttpPost post = new HttpPost(url);
            FileBody fb = new FileBody(new File(path));
            HttpEntity reqEntity = MultipartEntityBuilder.create().addPart("media", fb).build();
            post.setEntity(reqEntity);
            resp = client.execute(post);
            int code = resp.getStatusLine().getStatusCode();
            if (code >= 200 && code < 300) {
                final String json = EntityUtils.toString(resp.getEntity());
                WeixinMedia weixinMedia = JsonUtils.jsonToPojo(json, WeixinMedia.class);
                return weixinMedia.getMedia_id();
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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

    }

    public static void getMedia(String media_id,File file){
        {
            CloseableHttpClient client = null;
            CloseableHttpResponse resp = null;
            try {
                client = HttpClients.createDefault();
                String url = WeisinFinalValue.GET_MEDIA;
                url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
                url = url.replaceAll("MEDIA_ID", media_id);
                HttpGet get = new HttpGet(url);


                resp = client.execute(get);
                int code = resp.getStatusLine().getStatusCode();
                if (code >= 200 && code < 300) {
                    InputStream content = resp.getEntity().getContent();
                    FileUtils.copyInputStreamToFile(content,file);
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

        }

    }

}
