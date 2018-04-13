package com.weixin.weixin1991.weixin.pojo.vo;

import lombok.Data;

import java.util.List;
@Data
public class WeixinMenuVo {
    private int id;
    private String name;
    private String key;
    private String type;
    private List<WeixinMenuVo> sub_button;
}
