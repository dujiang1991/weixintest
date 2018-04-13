package com.weixin.weixin1991.weixin.pojo;

import lombok.Data;

import java.util.Map;

@Data
public class TemplateMsg {

    private String touser;
    private String template_id;
    private String url;
    private String topcolor;
    private Map<String,Object> data;
}
