package com.weixin.weixin1991.weixin.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weixin.weixin1991.weixin.pojo.AccessToken;

public class WeixinAccessToken {
    public static final String ACCESS_TOKEN="8_g1blUYLqU9H3CSQDGK21vuTE6BnyzDq7QtS4SdM6yTr9LmucYhiAzXBzKiSh59VOPFJVUUCZxjrFUaUAqx9m5mkS1777tSKLjmVKW6FacdBlfGy4v-dPUKhHLAiu_fjRFbN-CrgtMzqTB9gCJPOiAEAZFE";
    public static String getAccessToken() {
        String url = WeixinFinalURL.ACCESS_TOKEN_URL;
        url = url.replaceAll("APPID", "wxbf573cdbb64da446");
        url = url.replaceAll("APPSECRET", "1dde3892ad7118822e5eb958e354c6ac");
        String json = WeixinHttpClientUtil.getReq(url);
        AccessToken accessToken =  JsonUtils.jsonToPojo(json, AccessToken.class);
        return accessToken.getAccess_token();

    }
}
