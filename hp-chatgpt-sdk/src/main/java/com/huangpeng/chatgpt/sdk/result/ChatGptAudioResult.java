package com.huangpeng.chatgpt.sdk.result;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description: 音频处理返回结果
 * @author: peng.huang
 * @create: 2023-03-07 09:56:24
 **/
public class ChatGptAudioResult implements Serializable {
    private static final long serialVersionUID = -1070333750422876372L;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
