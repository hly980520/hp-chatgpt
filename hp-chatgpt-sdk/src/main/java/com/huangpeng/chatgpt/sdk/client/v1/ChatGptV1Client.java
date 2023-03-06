package com.huangpeng.chatgpt.sdk.client.v1;

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Stopwatch;
import com.huangpeng.chatgpt.sdk.constant.RequestHeadersConst;
import com.huangpeng.chatgpt.sdk.data.ChatCompletionsData;
import com.huangpeng.chatgpt.sdk.data.CompletionsData;
import com.huangpeng.chatgpt.sdk.data.ModelData;
import com.huangpeng.chatgpt.sdk.data.ModelsResult;
import com.huangpeng.chatgpt.sdk.domain.GenerateImage;
import com.huangpeng.chatgpt.sdk.params.v1.ChatCompletionsV1Params;
import com.huangpeng.chatgpt.sdk.params.v1.CompletionsV1Params;
import com.huangpeng.chatgpt.sdk.params.v1.GenerateImageV1Params;
import com.huangpeng.chatgpt.sdk.properties.v1.ChatGptV1Properties;
import com.huangpeng.chatgpt.sdk.result.GenerateImagesV1Result;
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
public class ChatGptV1Client {

    private static final Logger logger = LoggerFactory.getLogger(ChatGptV1Client.class);

    @Autowired
    private ChatGptV1Properties chatGptV1Properties;

    @Autowired
    private OkHttpClient chatGptHttpClient;

    /**
     * 获取模型列表
     * @return
     */
    public List<ModelData> queryModelList() {

        Request request = this.buildGetRequest(chatGptV1Properties.getUrlModels());

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
            ModelsResult modelsResult = JSON.parseObject(body, ModelsResult.class);
            if (Objects.isNull(modelsResult)) {
                logger.warn("queryModels: modelsResult is null");
                return null;
            }

            return modelsResult.getData();
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
    public ModelData queryModelById(String id) {
        Request request = this.buildGetRequest(chatGptV1Properties.getUrlModels() + "/" + id);
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
            return JSON.parseObject(body, ModelData.class);
        } catch (Exception e) {
            logger.warn("queryModelById: request exception, ", e);
            return null;
        } finally {
            logger.info("queryModelById: request end, costTime: {}", stopwatch.stop());
        }
    }

    public CompletionsData queryCompletions(CompletionsV1Params params) {
        Request request = this.buildPostRequest(chatGptV1Properties.getUrlCompletions(),
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

            return JSON.parseObject(body, CompletionsData.class);
        } catch (Exception e) {
            logger.warn("queryCompletions: request exception, ", e);
            return null;
        } finally {
            logger.info("queryCompletions: request end, costTime: {}", stopwatch.stop());
        }
    }

    public ChatCompletionsData chatCompletions(ChatCompletionsV1Params params) {
        Request request = this.buildPostRequest(chatGptV1Properties.getUrlChatCompletions(),
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

            return JSON.parseObject(body, ChatCompletionsData.class);
        } catch (Exception e) {
            logger.warn("chatCompletions: request exception, ", e);
            return null;
        } finally {
            logger.info("chatCompletions: request end, costTime: {}", stopwatch.stop());
        }
    }


    public List<GenerateImage> generateImages(GenerateImageV1Params params) {
        Request request = this.buildPostRequest(chatGptV1Properties.getUrlImagesGenerations(),
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

            GenerateImagesV1Result result = JSON.parseObject(body, GenerateImagesV1Result.class);
            if (Objects.isNull(result)) {
                logger.warn("generateImages: generateImagesV1Result is null");
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
     * 构建post请求
     * @param url
     * @return
     */
    private Request buildPostRequest(String url, String requestBodyData) {
        RequestBody body = RequestBody.create(requestBodyData,
                MediaType.parse(RequestHeadersConst.MEDIA_TYPE_APPLICATION_JSON));

        return new Request.Builder()
                .url(url)
                .header(RequestHeadersConst.CONTENT_TYPE, RequestHeadersConst.APPLICATION_JSON)
                .header(RequestHeadersConst.AUTHORIZATION, chatGptV1Properties.getAuthorization())
                .header(RequestHeadersConst.OPENAI_ORGANIZATION, chatGptV1Properties.getOpenAiOrganization())
                .post(body)
                .build();
    }

    /**
     * 构建get请求
     * @param url
     * @return
     */
    private Request buildGetRequest(String url) {
        return new Request.Builder()
                .url(url)
                .header(RequestHeadersConst.AUTHORIZATION, chatGptV1Properties.getAuthorization())
                .header(RequestHeadersConst.OPENAI_ORGANIZATION, chatGptV1Properties.getOpenAiOrganization())
                .get()
                .build();
    }
}
