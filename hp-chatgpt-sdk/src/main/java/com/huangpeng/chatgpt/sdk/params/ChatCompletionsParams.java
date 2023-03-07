package com.huangpeng.chatgpt.sdk.params;

import com.huangpeng.chatgpt.sdk.domain.CompletionsMessage;

import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description: 目前支持：gpt-3.5-turbo/gpt-3.5-turbo-0301
 * @author: peng.huang
 * @create: 2023-03-06 17:44:50
 **/
public class ChatCompletionsParams extends BaseParams{
    private static final long serialVersionUID = -83610918237889073L;

    private List<CompletionsMessage> messages;

    public List<CompletionsMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<CompletionsMessage> messages) {
        this.messages = messages;
    }
}
