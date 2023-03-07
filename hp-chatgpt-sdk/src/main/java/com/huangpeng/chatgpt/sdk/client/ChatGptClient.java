package com.huangpeng.chatgpt.sdk.client;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Stopwatch;
import com.huangpeng.chatgpt.sdk.constant.RequestHeadersConst;
import com.huangpeng.chatgpt.sdk.domain.*;
import com.huangpeng.chatgpt.sdk.params.*;
import com.huangpeng.chatgpt.sdk.result.ChatGptAudioResult;
import com.huangpeng.chatgpt.sdk.result.ChatGptModelsResult;
import com.huangpeng.chatgpt.sdk.properties.ChatGptProperties;
import com.huangpeng.chatgpt.sdk.result.GenerateImagesResult;
import com.huangpeng.chatgpt.sdk.utils.HttpUtils;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * @Program: hp-chatgpt
 * @Description: chatGpt客户端
 * @author: peng.huang
 * @create: 2023-03-06 16:04:41
 **/
public class ChatGptClient {

    private static final Logger logger = LoggerFactory.getLogger(ChatGptClient.class);

    @Autowired
    private ChatGptProperties chatGptProperties;

    @Autowired
    private OkHttpClient chatGptHttpClient;

    /**
     * 获取模型列表
     * @return
     */
    public List<ChatGptModel> queryModelList() {

        Request request = HttpUtils.buildGetRequest(chatGptProperties, chatGptProperties.getUrlModels());

        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("queryModels: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("queryModels: responseBody.string is null");
                return null;
            }
            ChatGptModelsResult chatGptModelsResult = JSON.parseObject(body, ChatGptModelsResult.class);
            if (Objects.isNull(chatGptModelsResult)) {
                logger.warn("queryModels: modelsResult is null");
                return null;
            }

            return chatGptModelsResult.getData();
        } catch (Exception e) {
            logger.warn("queryModels: request exception, ", e);
            return null;
        } finally {
            logger.info("queryModels: request end, costTime: {}", stopwatch.stop());
        }
    }

    /**
     * 根据id获取模型
     * @param id
     * @return
     */
    public ChatGptModel queryModelById(String id) {
        Request request = HttpUtils.buildGetRequest(chatGptProperties, chatGptProperties.getUrlModels() + "/" + id);
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("queryModelById: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("queryModelById: responseBody.string is null");
                return null;
            }
            return JSON.parseObject(body, ChatGptModel.class);
        } catch (Exception e) {
            logger.warn("queryModelById: request exception, ", e);
            return null;
        } finally {
            logger.info("queryModelById: request end, costTime: {}", stopwatch.stop());
        }
    }

    /**
     * 给定一个提示，该模型将返回一个或多个预测的完成，并且还可以返回每个位置的替代标记的概率
     * @param params
     * @return
     */
    public Completions queryCompletions(CompletionsParams params) {
        Request request = HttpUtils.buildJsonPostRequest(chatGptProperties, chatGptProperties.getUrlCompletions(),
                JSON.toJSONString(params));
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("queryCompletions: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("queryCompletions: responseBody.string is null");
                return null;
            }

            return JSON.parseObject(body, Completions.class);
        } catch (Exception e) {
            logger.warn("queryCompletions: request exception, ", e);
            return null;
        } finally {
            logger.info("queryCompletions: request end, costTime: {}", stopwatch.stop());
        }
    }

    /**
     * 给定聊天对话，模型将返回聊天完成响应。
     * @param params
     * @return
     */
    public ChatCompletions chatCompletions(ChatCompletionsParams params) {
        Request request = HttpUtils.buildJsonPostRequest(chatGptProperties, chatGptProperties.getUrlChatCompletions(),
                JSON.toJSONString(params));
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("chatCompletions: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("chatCompletions: responseBody.string is null");
                return null;
            }

            return JSON.parseObject(body, ChatCompletions.class);
        } catch (Exception e) {
            logger.warn("chatCompletions: request exception, ", e);
            return null;
        } finally {
            logger.info("chatCompletions: request end, costTime: {}", stopwatch.stop());
        }
    }


    /**
     * 只支持text-davinci-edit-001/code-davinci-edit-001
     * 给定提示和指令，模型将返回提示的编辑版本。
     * @param params
     * @return
     */
    public ChatGptEdits createdEdits(ChatGptEditsParams params) {
        Request request = HttpUtils.buildJsonPostRequest(chatGptProperties, chatGptProperties.getUrlEdits(),
                JSON.toJSONString(params));
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("createdEdits: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("createdEdits: responseBody.string is null, [params:{}]", JSON.toJSONString(params));
                return null;
            }

            return JSON.parseObject(body, ChatGptEdits.class);
        } catch (Exception e) {
            logger.warn("createdEdits: request exception, [params:{} ]", JSON.toJSONString(params), e);
            return null;
        } finally {
            logger.info("createdEdits: request end, costTime: {}", stopwatch.stop());
        }
    }


    /**
     *
     * 根据提示创建图像
     * @param params
     * @return
     */
    public List<GenerateImage> generateImages(GenerateImageParams params) {
        Request request = HttpUtils.buildJsonPostRequest(chatGptProperties, chatGptProperties.getUrlImagesGenerations(),
                JSON.toJSONString(params));
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("generateImages: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("generateImages: responseBody.string is null");
                return null;
            }

            GenerateImagesResult result = JSON.parseObject(body, GenerateImagesResult.class);
            if (Objects.isNull(result)) {
                logger.warn("generateImages: generateImagesResult is null");
                return null;
            }
            return result.getData();
        } catch (Exception e) {
            logger.warn("generateImages: request exception, ", e);
            return null;
        } finally {
            logger.info("generateImages: request end, costTime: {}", stopwatch.stop());
        }
    }


    /**
     * 将音频转录为输入语言<br>
     * 只支持whisper-1模型
     * @param params
     * @return
     */
    public String audioTranscriptions(AudioParams params) {
        Request request = HttpUtils.buildFilePostRequest(
                chatGptProperties,
                chatGptProperties.getUrlAudioTranscriptions(),
                params.getFile(),
                params.getModel(),
                params.getLanguage()
        );

        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
            Response response = chatGptHttpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (Objects.isNull(responseBody)) {
                logger.warn("audioTranscriptions: responseBody is null");
                return null;
            }
            String body = responseBody.string();
            if (StringUtils.isEmpty(body)) {
                logger.warn("audioTranscriptions: responseBody.string is null");
                return null;
            }

            ChatGptAudioResult result = JSON.parseObject(body, ChatGptAudioResult.class);
            if (Objects.isNull(result)) {
                logger.warn("audioTranscriptions: ChatGptAudioResult is null");
                return null;
            }
            return result.getText();
        } catch (Exception e) {
            logger.warn("audioTranscriptions: request exception, ", e);
            return null;
        } finally {
            logger.info("audioTranscriptions: request end, costTime: {}", stopwatch.stop());
        }
    }
}
