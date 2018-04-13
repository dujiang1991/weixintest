package com.weixin.weixin1991.weixin.utils.Template;

import com.weixin.weixin1991.weixin.pojo.TemplateMsg;
import com.weixin.weixin1991.weixin.utils.JsonUtils;
import com.weixin.weixin1991.weixin.utils.WeixinAccessToken;
import com.weixin.weixin1991.weixin.utils.WeixinFinalURL;
import com.weixin.weixin1991.weixin.utils.WeixinHttpClientUtil;

import java.util.Map;

public class TemplateMessageUtil {
    //发送模版消息工具方法
    public static String postTemplateMsg(TemplateMsg tm) {
        String url = WeixinFinalURL.SEND_TEMPLATE_MSG;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        String json = JsonUtils.objectToJson(tm);
        return WeixinHttpClientUtil.postReq(url, json, "application/json");
    }

    //设置模版消息（设置所属行业）
    public static String setIndustry(Map<String, String> map) {
        String url = WeixinFinalURL.POST_TEMPLATE_SETINDUSTRY_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        String data = JsonUtils.objectToJson(map);
        return WeixinHttpClientUtil.postReq(url, data, "application/json");
    }

    //获取模版行业信息
    public static String getIndustry() {
        String url = WeixinFinalURL.GET_TEMPLATE_GETINDUSTRY_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        return WeixinHttpClientUtil.getReq(url);
    }

    //获取模版id
    public static String getTemplateMessageID(Map<String, String> map) {
        String url = WeixinFinalURL.POST_TEMPLATE_GETTEMPLATEID_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        String data = JsonUtils.objectToJson(map);
        return WeixinHttpClientUtil.postReq(url, data, "application/json");

    }

    //获取模版列表、
    public static String getTemplateList() {
        String url = WeixinFinalURL.GET_TEMPLATE_GETTEMPLATELIST_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        return WeixinHttpClientUtil.getReq(url);
    }

    //删除模版
    public static String deleteTempalteMessage(Map<String, String> map) {
        String url = WeixinFinalURL.POST_TEMPLATE_DELETETEMPLATE_URL;
        url = url.replaceAll("ACCESS_TOKEN", WeixinAccessToken.getAccessToken());
        String data = JsonUtils.objectToJson(map);
        return WeixinHttpClientUtil.postReq(url, data, "application/json");
    }

}
