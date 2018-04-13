package com.weixin.weixin1991.weixin.utils;

public class WeixinFinalURL {

    public static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static String APPID = "wxbf573cdbb64da446";
    public static String APPSECRET = "1dde3892ad7118822e5eb958e354c6ac";
    public static String MEMU_ADD = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    //消息类型
    public static String MSG_TYPE_TEXT = "text";
    public static String MSG_TYPE_IMAGE = "image";
    public static String MSG_TYPE_VOICE = "voice";
    public static String MSG_TYPE_VIDEO = "video";
    public static String MSG_TYPE_SHORTVIDEO = "shortvideo";
    public static String MSG_TYPE_LOCATION = "location";
    public static String MSG_TYPE_LINK = "link";
    public static String MSG_TYPE_EVENT = "event";

    //新增素材路径
    public static String POST_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
    public static String GET_MEDIA = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
    //模版消息发送postURL
    public static final String SEND_TEMPLATE_MSG = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    //微信用户创建标签url
    public static final String TAG_URL = "https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";
    //获取标签url
    public static final String GET_TAG_URL = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=ACCESS_TOKEN";
    //修改标签url
    public static final String POST_UPDATE_TAG_URL = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=ACCESS_TOKEN";

    //用户备注url
    public static final String POST_USER_SETREMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=ACCESS_TOKEN";
    //获取用户基本信息
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
    //获取用户列表
    public static final String GET_USER_LIST_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

    //设置模版消息所属行业
    public static final String POST_TEMPLATE_SETINDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
    //获取模版消息所属行业的信息
    public static final String GET_TEMPLATE_GETINDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
    //获取模版id
    public static final String POST_TEMPLATE_GETTEMPLATEID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
    //获取模版列表
    public static final String GET_TEMPLATE_GETTEMPLATELIST_URL = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";
//删除模版
    public static final String POST_TEMPLATE_DELETETEMPLATE_URL="https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=ACCESS_TOKEN";


}
