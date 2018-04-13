package com.weixin.demo1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class ServiceImf implements service{


    private UtilService shalUtil;
    @Autowired
    public void setShalUtil(UtilService shalUtil){
        this.shalUtil = shalUtil;
    }

    //微信公众平台登录的签名校验
    private static final String token="dujiang1991";
    @Override
    public boolean checkSignature(String signature,String timestamp,String nonce) {
        //1、排序
        String [] arr = new String[]{token,timestamp,nonce};
        Arrays.sort(arr);
        //2、生成新的字符串
        StringBuffer content = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            content.append(arr[i]);
        }
        //3、shal加密
        String temp = shalUtil.getSha1(content.toString());

        return temp.equals(signature);
    }


}