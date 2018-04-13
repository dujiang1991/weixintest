package com.weixin.demo1.weixin.user.tag;

import com.weixin.demo1.kit.WeixinKit;
import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.util.GetAccessToken;
import com.weixin.demo1.util.JsonUtils;

import java.util.HashMap;
import java.util.Map;

//用户标签管理
public class BiaoQian {
    //post请求添加标签
    public static String psotBiaoqian(Map<String, Object> map) {

        String json = JsonUtils.objectToJson(map);
        String url = WeisinFinalValue.TAG_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        return WeixinKit.postReq(url, json, "application/json");

    }

    //get请求获取标签
    public static String getTag() {
        String url = WeisinFinalValue.GET_TAG_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        String json = WeixinKit.getReq(url);

        return json;
    }

    //修改标签

    public static String updateTag(Map<String, Object> map) {
        String url = WeisinFinalValue.POST_UPDATE_TAG_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        String data = JsonUtils.objectToJson(map);
        return WeixinKit.postReq(url, data, "application/json");

    }

}
