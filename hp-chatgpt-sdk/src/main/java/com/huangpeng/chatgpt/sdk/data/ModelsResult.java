package com.huangpeng.chatgpt.sdk.data;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:00:51
 **/
public class ModelsResult implements Serializable {
    private static final long serialVersionUID = -907534634636165484L;

    private String object;

    private List<ModelData> data;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public List<ModelData> getData() {
        return data;
    }

    public void setData(List<ModelData> data) {
        this.data = data;
    }
}
