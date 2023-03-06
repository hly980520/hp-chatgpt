package com.huangpeng.chatgpt.sdk.params.v1;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 21:03:43
 **/
public class BaseParams implements Serializable {
    private static final long serialVersionUID = 1596342292734065215L;

    /**
     * 模型id
     */
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
