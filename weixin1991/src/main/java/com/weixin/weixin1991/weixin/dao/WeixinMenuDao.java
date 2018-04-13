package com.weixin.weixin1991.weixin.dao;

import com.weixin.weixin1991.weixin.pojo.po.WeixinMenu;
import com.weixin.weixin1991.weixin.pojo.vo.WeixinMenuVo;

import java.util.List;

public interface WeixinMenuDao  {
    public WeixinMenu getByKey(String key);
    public List<WeixinMenu > findAll();
}
