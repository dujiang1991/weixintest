package com.weixin.weixin1991.weixin.service;

import com.weixin.weixin1991.weixin.pojo.po.WeixinMenu;
import com.weixin.weixin1991.weixin.pojo.vo.WeixinMenuVo;

import java.util.List;

public interface WeixinMenuService {
    void add(WeixinMenu wm);
    void delete(int id);
    void update(WeixinMenu wm);
    WeixinMenu findOne(int id);
    List<WeixinMenu> findAll();
    WeixinMenu findByKey(String key);
    //发布按钮
    List<WeixinMenuVo> generateWeixinMenu();

}
