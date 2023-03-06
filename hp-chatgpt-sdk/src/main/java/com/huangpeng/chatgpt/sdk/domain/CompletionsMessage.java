package com.huangpeng.chatgpt.sdk.domain;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:46:28
 **/
public class CompletionsMessage implements Serializable {
    private static final long serialVersionUID = -800248802763554496L;

    private String role;

    private String content;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
