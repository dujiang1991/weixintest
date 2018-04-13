package com.weixin.weixin1991.weixin.service;

public interface WeixinService {
    public boolean checkSignature(String signature,String timestamp,String nonce);
}
