package com.huangpeng.chatgpt.sdk.properties;

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
public class ChatGptProperties {

    private String authorization;

    private String openAiOrganization;

    private String urlModels;

    private String urlCompletions;

    private String urlChatCompletions;

    private String urlImagesGenerations;

    private String urlEdits;

    private String urlAudioTranscriptions;

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

    public String getUrlEdits() {
        return urlEdits;
    }

    public void setUrlEdits(String urlEdits) {
        this.urlEdits = urlEdits;
    }

    public String getUrlAudioTranscriptions() {
        return urlAudioTranscriptions;
    }

    public void setUrlAudioTranscriptions(String urlAudioTranscriptions) {
        this.urlAudioTranscriptions = urlAudioTranscriptions;
    }
}
