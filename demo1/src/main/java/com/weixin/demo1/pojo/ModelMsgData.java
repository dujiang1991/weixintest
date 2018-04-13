package com.weixin.demo1.pojo;

import lombok.Data;

@Data
public class ModelMsgData {
    private String value;
    private String color;

    public ModelMsgData(String value,String color){
        this.value=value;
        this.color=color;

    }

}
