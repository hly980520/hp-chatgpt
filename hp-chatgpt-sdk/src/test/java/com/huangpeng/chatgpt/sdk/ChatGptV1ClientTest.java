package com.huangpeng.chatgpt.sdk;

import com.alibaba.fastjson2.JSON;
import com.huangpeng.chatgpt.sdk.autoconfig.ChatGptSdkV1AutoConfiguration;
import com.huangpeng.chatgpt.sdk.client.v1.ChatGptV1Client;
import com.huangpeng.chatgpt.sdk.data.ChatCompletionsData;
import com.huangpeng.chatgpt.sdk.data.CompletionsData;
import com.huangpeng.chatgpt.sdk.data.ModelData;
import com.huangpeng.chatgpt.sdk.domain.CompletionsMessage;
import com.huangpeng.chatgpt.sdk.domain.GenerateImage;
import com.huangpeng.chatgpt.sdk.params.v1.ChatCompletionsV1Params;
import com.huangpeng.chatgpt.sdk.params.v1.CompletionsV1Params;
import com.huangpeng.chatgpt.sdk.params.v1.GenerateImageV1Params;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:06:32
 **/
@SpringBootTest(classes = ChatGptSdkV1AutoConfiguration.class)
public class ChatGptV1ClientTest {

    private static final Logger logger = LoggerFactory.getLogger(ChatGptV1ClientTest.class);

    @Resource
    private ChatGptV1Client chatGptV1Client;

    @Test
    public void queryModelListTest() {
        List<ModelData> modelDataList = chatGptV1Client.queryModelList();
        logger.info(JSON.toJSONString(modelDataList));
    }

    @Test
    public void queryModelByIdTest() {
        ModelData modelData = chatGptV1Client.queryModelById("babbage");
        logger.info(JSON.toJSONString(modelData));
    }

    @Test
    public void queryCompletionsTest() {
        CompletionsV1Params params = new CompletionsV1Params();
        params.setModel("text-davinci-003");
        params.setPrompt("去你大爷");
        params.setTemperature(0);
        params.setMax_tokens(7);
        CompletionsData completionsData = chatGptV1Client.queryCompletions(params);
        logger.info(JSON.toJSONString(completionsData));
    }

    @Test
    public void chatCompletionsTest() {
        ChatCompletionsV1Params params = new ChatCompletionsV1Params();
        CompletionsMessage message = new CompletionsMessage();
        message.setRole("user");
        message.setContent("习近平");
        params.setModel("gpt-3.5-turbo");
        params.setMessages(Collections.singletonList(message));
        ChatCompletionsData chatCompletionsData = chatGptV1Client.chatCompletions(params);
        logger.info(JSON.toJSONString(chatCompletionsData));
    }

    @Test
    public void generateImagesTest() {
        GenerateImageV1Params params = new GenerateImageV1Params();
        params.setN(5);
        params.setSize("1024x1024");
        params.setPrompt("清纯高中学妹");
        List<GenerateImage> imageList = chatGptV1Client.generateImages(params);
        imageList.forEach(generateImage -> {
            if (Objects.nonNull(generateImage)) {
                logger.info(generateImage.getUrl());
            }
        });
    }
}
