package com.huangpeng.chatgpt.sdk.params.v1;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description: 图片生成
 * @author: peng.huang
 * @create: 2023-03-06 18:11:42
 **/
public class GenerateImageV1Params implements Serializable {
    private static final long serialVersionUID = 2148370172854538410L;

    /**
     * 图片主题
     */
    private String prompt;

    /**
     * 图片数量
     */
    private Integer n;

    /**
     * 图片尺寸<br>
     * 1024x1024
     */
    private String size;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
