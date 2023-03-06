package com.huangpeng.chatgpt.sdk.constant;

/**
 * @Program: hp-chatgpt
 * @Description: 请求头常量类
 * @author: peng.huang
 * @create: 2023-03-06 16:00:42
 **/
public class RequestHeadersConst {

    private RequestHeadersConst() {
    }

    public static final String AUTHORIZATION = "Authorization";

    public static final String OPENAI_ORGANIZATION = "OpenAI-Organization";

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String APPLICATION_JSON = "application/json";

    public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json; charset=utf-8";
}
