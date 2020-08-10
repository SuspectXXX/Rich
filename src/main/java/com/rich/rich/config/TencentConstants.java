package com.rich.rich.config;

public class TencentConstants {
    /*
    * 获取企业微信token地址及对应参数
    * */
    public static final String GET_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    public static final String GET_TOKEN_URL_PARAM_COPRID = "coprid";
    public static final String GET_TOKEN_URL_PARAM_CORPSECRET = "corpsecret";

    /*
    * 获取企业微信token返回成功对应的errorcode值
    * */
    public static final String GET_TOKEN_RETURN_SUCCESS_CODE = "0";
    public static final String GET_TOKEN_RETURN_ERRCODE = "errcode";
    public static final String GET_TOKEN_RETUEN_ERRMSG = "errmsg";
    public static final String GET_TOKEN_RETURN_TOKEN = "access_token";

    /*
    * 获取企业微信引入JS-SDK的ticket地址及对应参数
    * */
    public static final String GET_JSAPITICKET_URL = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";
    public static final String GET_JSAPITICKET_URL_PARAM_TOKEN = "access_token";
    public static final String GET_JSAPITICKET_URL_PARAM_TICKET = "jsapi_ticket";
    public static final String GET_JSAPITICKET_URL_PARAM_NONCESTR = "noncestr";
    public static final String GET_JSAPITICKET_URL_PARAM_TIMESTAMP = "timestamp";
    public static final String GET_JSAPITICKET_URL_PARAM_URL = "url";

    public static final String GET_JSAPITICKET_RETURN_SIGNATURE = "signature";

    /*
    * 获取用户ticket参数
    * */
    public static final String GET_JSAPITICKET_RETURN_SUCCESS_CODE = "0";
    public static final String GET_JSAPITICKET_RETURN_ERRCODE = "errcode";
    public static final String GET_JSAPITICKET_RETURN_ERRMSG = "errmsg";
    public static final String GET_JSAPITICKET_RETURN_TICKET = "ticket";

    /*
    * 通过code获取用户信息url及其对应参数
    * */
    public static final String GET_USERINFO_URL = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";
    public static final String GET_USERINFO_URL_PARAM_TOKEN = "access_token";
    public static final String GET_USERINFO_URL_PARAM_code = "code";

    /*
    * 通过code获取用户信息返回参数
    * */
    public static final String GET_USERINFO_RETURN_SUCCESS_CODE = "0";
    public static final String GET_USERINFO_RETURN_ERRCODE = "errcode";
    public static final String GET_USERINFO_RETURN_ERRMSG = "errmsg";
    public static final String GET_USERINFO_RETURN_USERID = "userid";

    /**
     * 企业微信的CorpID，在企业微信管理端查看
     */
    public static final String CORPID = "ww99fb52ea64503670";

    /**
     * 授权方的网页应用ID，在具体的网页应用中查看
     */
    public static final String AGENTID = "1000008";

    /**
     * 应用的凭证密钥,在具体的网页应用中查看
     */
    public static final String CORPSECRET = "m_EtiGQ8jM1LOWglgLfXjYL8OkoRSV9B7kaCymEMewg";

    /*
    * 参数连接符
    * */
    public static final String AND = "&";
    public static final String EQUAL = "=";
    public static final String QUERY = "?";

}
