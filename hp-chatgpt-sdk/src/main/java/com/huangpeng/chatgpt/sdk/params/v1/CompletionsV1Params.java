package com.huangpeng.chatgpt.sdk.params.v1;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 16:08:28
 **/
public class CompletionsV1Params extends BaseCompletionsV1Params {

    private static final long serialVersionUID = -4788032871294657017L;
    private String prompt;

    private Integer temperature;

    private Integer max_tokens;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }
}
