package com.huangpeng.chatgpt.sdk.data;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:35:23
 **/
public class UsageData implements Serializable {
    private static final long serialVersionUID = 6471990819846732683L;

    private Integer prompt_tokens;

    private Integer completion_tokens;

    private Integer total_tokens;

    public Integer getPrompt_tokens() {
        return prompt_tokens;
    }

    public void setPrompt_tokens(Integer prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public Integer getCompletion_tokens() {
        return completion_tokens;
    }

    public void setCompletion_tokens(Integer completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public Integer getTotal_tokens() {
        return total_tokens;
    }

    public void setTotal_tokens(Integer total_tokens) {
        this.total_tokens = total_tokens;
    }
}
