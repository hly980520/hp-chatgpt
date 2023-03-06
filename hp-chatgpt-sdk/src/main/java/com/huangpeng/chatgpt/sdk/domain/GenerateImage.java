package com.huangpeng.chatgpt.sdk.domain;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description: 图片
 * @author: peng.huang
 * @create: 2023-03-06 18:15:04
 **/
public class GenerateImage implements Serializable {
    private static final long serialVersionUID = -2349461286149034622L;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
