package com.huangpeng.chatgpt.sdk.params.v1;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:43:25
 **/
public class BaseCompletionsV1Params implements Serializable {

    private static final long serialVersionUID = -7128832376940978786L;
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
