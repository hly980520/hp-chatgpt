package com.huangpeng.chatgpt.sdk.properties.v1;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 16:12:04
 **/
@ConfigurationProperties(
        prefix = "hp.chatgpt.sdk.v1"
)
public class ChatGptV1Properties {

    private String authorization;

    private String openAiOrganization;

    private String urlModels;

    private String urlCompletions;

    private String urlChatCompletions;

    private String urlImagesGenerations;

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getOpenAiOrganization() {
        return openAiOrganization;
    }

    public void setOpenAiOrganization(String openAiOrganization) {
        this.openAiOrganization = openAiOrganization;
    }

    public String getUrlModels() {
        return urlModels;
    }

    public void setUrlModels(String urlModels) {
        this.urlModels = urlModels;
    }

    public String getUrlCompletions() {
        return urlCompletions;
    }

    public void setUrlCompletions(String urlCompletions) {
        this.urlCompletions = urlCompletions;
    }

    public String getUrlChatCompletions() {
        return urlChatCompletions;
    }

    public void setUrlChatCompletions(String urlChatCompletions) {
        this.urlChatCompletions = urlChatCompletions;
    }

    public String getUrlImagesGenerations() {
        return urlImagesGenerations;
    }

    public void setUrlImagesGenerations(String urlImagesGenerations) {
        this.urlImagesGenerations = urlImagesGenerations;
    }
}
