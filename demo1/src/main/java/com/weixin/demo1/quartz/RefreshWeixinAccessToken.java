package com.weixin.demo1.quartz;

import org.springframework.stereotype.Component;

@Component
public class RefreshWeixinAccessToken {
public void refreshToken(){
    System.out.println("refresh");
}


}
