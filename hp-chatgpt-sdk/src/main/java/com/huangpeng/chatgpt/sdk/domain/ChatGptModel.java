package com.huangpeng.chatgpt.sdk.domain;

import com.huangpeng.chatgpt.sdk.data.PermissionData;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description: 模型数据
 * @author: peng.huang
 * @create: 2023-03-06 16:52:42
 **/
public class ChatGptModel implements Serializable {
    private static final long serialVersionUID = -3324468974760341378L;

    private String id;

    private String object;

    private String root;

    private Object parent;

    private String owned_by;

    private List<PermissionData> permission;

    private Long created;

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

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public Object getParent() {
        return parent;
    }

    public void setParent(Object parent) {
        this.parent = parent;
    }

    public String getOwned_by() {
        return owned_by;
    }

    public void setOwned_by(String owned_by) {
        this.owned_by = owned_by;
    }

    public List<PermissionData> getPermission() {
        return permission;
    }

    public void setPermission(List<PermissionData> permission) {
        this.permission = permission;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }
}
