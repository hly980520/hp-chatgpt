package com.huangpeng.chatgpt.sdk.domain;

import com.huangpeng.chatgpt.sdk.data.UsageData;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:33:46
 **/
public class BaseCompletions implements Serializable {
    private static final long serialVersionUID = 919975753233775490L;

    private String id;

    private String object;

    private String model;

    private String created;

    private UsageData usage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UsageData getUsage() {
        return usage;
    }

    public void setUsage(UsageData usage) {
        this.usage = usage;
    }
}
