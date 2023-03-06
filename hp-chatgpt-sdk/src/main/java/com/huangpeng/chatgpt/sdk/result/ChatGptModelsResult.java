package com.huangpeng.chatgpt.sdk.result;

import com.huangpeng.chatgpt.sdk.domain.ChatGptModel;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:00:51
 **/
public class ChatGptModelsResult implements Serializable {
    private static final long serialVersionUID = -907534634636165484L;

    private String object;

    private List<ChatGptModel> data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<ChatGptModel> getData() {
        return data;
    }

    public void setData(List<ChatGptModel> data) {
        this.data = data;
    }
}
