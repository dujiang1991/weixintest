package com.weixin.demo1.weixin.user.model;

import lombok.Data;

@Data
public class TagEntity {
    private int id;
    private String name;
    private String count;

    public TagEntity() {
    }

    public TagEntity(String name){
        this.name=name;
    }
}
