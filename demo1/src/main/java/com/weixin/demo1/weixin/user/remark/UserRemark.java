package com.weixin.demo1.weixin.user.remark;

import com.weixin.demo1.kit.WeixinKit;
import com.weixin.demo1.model.WeisinFinalValue;
import com.weixin.demo1.util.GetAccessToken;
import com.weixin.demo1.util.JsonUtils;

import java.util.Map;

public class UserRemark {
    //给用户设置备注
    public static String setUserRemark(Map<String, String> map) {
        String url = WeisinFinalValue.POST_USER_SETREMARK_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        String json = JsonUtils.objectToJson(map);
        return WeixinKit.postReq(url, json, "application/json");

    }

    //查询用户详细信息（获取用户基本信息）
    public static String getUserInfo(String oppenid) {
        String url = WeisinFinalValue.GET_USER_INFO_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        url = url.replaceAll("OPENID", oppenid);
        return WeixinKit.getReq(url);


    }

    //获取用户列表
    public static String getUsers(String openid) {
        String url = WeisinFinalValue.GET_USER_LIST_URL;
        url = url.replaceAll("ACCESS_TOKEN", GetAccessToken.gettoken());
        url=url.replaceAll("NEXT_OPENID",openid);
        return WeixinKit.getReq(url);

    }
}
