package com.huangpeng.chatgpt.sdk.domain;

import com.huangpeng.chatgpt.sdk.data.UsageData;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 21:16:23
 **/
public class ChatGptEdits implements Serializable {
    private static final long serialVersionUID = 4196411204059034463L;

    private String object;

    private String created;

    private UsageData usage;

    private List<Choice> choices;

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    static class Choice {

        private String text;

        private Integer index;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }
    }
}
