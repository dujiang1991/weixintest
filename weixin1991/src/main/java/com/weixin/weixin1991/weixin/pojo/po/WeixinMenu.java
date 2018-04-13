package com.weixin.weixin1991.weixin.pojo.po;

import lombok.Data;

@Data
public class WeixinMenu {
    private int id;
    private String name;
    private String content;
    private String url;
    private String menuKey;
    private int pid;
    private int respType;


}
