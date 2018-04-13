package com.weixin.demo1.model.WeixinMenu;

import lombok.Data;

import java.util.List;

@Data

public class WeixinMenu {
    private int id;
    private String name;
    private String type;
    private String url;
    private String key;
    private int pid;
    private List<WeixinMenu> sub_button;
}
