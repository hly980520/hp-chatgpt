package com.huangpeng.chatgpt.sdk.utils;

import com.huangpeng.chatgpt.sdk.constant.RequestHeadersConst;
import com.huangpeng.chatgpt.sdk.properties.ChatGptProperties;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;

import java.io.File;

/**
 * @Program: hp-chatgpt
 * @Description: http请求工具类
 * @author: peng.huang
 * @create: 2023-03-07 10:00:47
 **/
public class HttpUtils {

    /**
     * 构建form表单post请求<br>
     * 主要用于文件上传
     * @param chatGptProperties
     * @param url
     * @param file
     * @param model
     * @return
     */
    public static Request buildFilePostRequest(ChatGptProperties chatGptProperties,
                                               String url, File file, String model, String language) {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        if (StringUtils.isNotEmpty(language)) {
            builder.addFormDataPart("language", language);
        }
        MultipartBody multipartBody = builder
                .addFormDataPart("file", file.getName(), RequestBody.create(file, MediaType.parse("audio/mp3")))
                .addFormDataPart("model", model)
                .build();

        return new Request.Builder()
                .url(url)
                .header(RequestHeadersConst.CONTENT_TYPE, RequestHeadersConst.MULTIPART_FORM_DATA)
                .header(RequestHeadersConst.AUTHORIZATION, chatGptProperties.getAuthorization())
                .header(RequestHeadersConst.OPENAI_ORGANIZATION, chatGptProperties.getOpenAiOrganization())
                .post(multipartBody)
                .build();
    }

    /**
     * 构建json post请求
     * @param url
     * @return
     */
    public static Request buildJsonPostRequest(ChatGptProperties chatGptProperties, String url, String requestBodyData) {
        RequestBody body = RequestBody.create(requestBodyData,
                MediaType.parse(RequestHeadersConst.MEDIA_TYPE_APPLICATION_JSON));

        return new Request.Builder()
                .url(url)
                .header(RequestHeadersConst.CONTENT_TYPE, RequestHeadersConst.APPLICATION_JSON)
                .header(RequestHeadersConst.AUTHORIZATION, chatGptProperties.getAuthorization())
                .header(RequestHeadersConst.OPENAI_ORGANIZATION, chatGptProperties.getOpenAiOrganization())
                .post(body)
                .build();
    }

    /**
     * 构建get请求
     * @param url
     * @return
     */
    public static Request buildGetRequest(ChatGptProperties chatGptProperties, String url) {
        return new Request.Builder()
                .url(url)
                .header(RequestHeadersConst.AUTHORIZATION, chatGptProperties.getAuthorization())
                .header(RequestHeadersConst.OPENAI_ORGANIZATION, chatGptProperties.getOpenAiOrganization())
                .get()
                .build();
    }
}
