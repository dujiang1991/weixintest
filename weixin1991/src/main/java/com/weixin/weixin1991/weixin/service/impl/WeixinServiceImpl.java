package com.weixin.weixin1991.weixin.service.impl;

import com.weixin.weixin1991.weixin.service.WeixinService;
import com.weixin.weixin1991.weixin.utils.Sha1Util;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WeixinServiceImpl  implements WeixinService{
    //微信公众平台登录的签名校验
    private static final String token="dujiang1991";
    @Override
    public boolean checkSignature(String signature, String timestamp, String nonce) {
        //1、排序
        String [] arr = new String[]{token,timestamp,nonce};
        Arrays.sort(arr);
        //2、生成新的字符串
        StringBuffer content = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            content.append(arr[i]);
        }
        //3、shal加密
        String temp = Sha1Util.getSha1(content.toString());

        return temp.equals(signature);
    }
}
