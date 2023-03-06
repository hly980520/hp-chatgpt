package com.huangpeng.chatgpt.sdk.params.v1;

import com.huangpeng.chatgpt.sdk.domain.CompletionsMessage;

import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:44:50
 **/
public class ChatCompletionsV1Params extends BaseCompletionsV1Params{
    private static final long serialVersionUID = -83610918237889073L;

    private List<CompletionsMessage> messages;

    public List<CompletionsMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<CompletionsMessage> messages) {
        this.messages = messages;
    }
}
