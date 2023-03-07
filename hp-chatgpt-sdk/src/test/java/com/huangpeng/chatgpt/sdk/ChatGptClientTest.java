package com.huangpeng.chatgpt.sdk;

import com.alibaba.fastjson2.JSON;
import com.huangpeng.chatgpt.sdk.autoconfig.ChatGptSdkAutoConfiguration;
import com.huangpeng.chatgpt.sdk.client.ChatGptClient;
import com.huangpeng.chatgpt.sdk.domain.*;
import com.huangpeng.chatgpt.sdk.params.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:06:32
 **/
@SpringBootTest(classes = ChatGptSdkAutoConfiguration.class)
public class ChatGptClientTest {

    private static final Logger logger = LoggerFactory.getLogger(ChatGptClientTest.class);

    @Resource
    private ChatGptClient chatGptClient;

    @Test
    public void queryModelListTest() {
        List<ChatGptModel> chatGptModelList = chatGptClient.queryModelList();
        logger.info(JSON.toJSONString(chatGptModelList));
    }

    @Test
    public void queryModelByIdTest() {
        ChatGptModel chatGptModel = chatGptClient.queryModelById("babbage");
        logger.info(JSON.toJSONString(chatGptModel));
    }

    @Test
    public void queryCompletionsTest() {
        CompletionsParams params = new CompletionsParams();
        params.setModel("text-davinci-003");
        params.setPrompt("去你大爷");
        params.setTemperature(0);
        params.setMax_tokens(7);
        Completions completionsData = chatGptClient.queryCompletions(params);
        logger.info(JSON.toJSONString(completionsData));
    }

    @Test
    public void chatCompletionsTest() {
        ChatCompletionsParams params = new ChatCompletionsParams();
        CompletionsMessage message = new CompletionsMessage();
        message.setRole("user");
        message.setContent("习近平");
        params.setModel("gpt-3.5-turbo");
        params.setMessages(Collections.singletonList(message));
        ChatCompletions chatCompletionsData = chatGptClient.chatCompletions(params);
        logger.info(JSON.toJSONString(chatCompletionsData));
    }

    @Test
    public void generateImagesTest() {
        GenerateImageParams params = new GenerateImageParams();
        params.setN(5);
        params.setSize("1024x1024");
        params.setPrompt("清纯高中学妹");
        List<GenerateImage> imageList = chatGptClient.generateImages(params);
        imageList.forEach(generateImage -> {
            if (Objects.nonNull(generateImage)) {
                logger.info(generateImage.getUrl());
            }
        });
    }

    @Test
    public void createdEditsTest() {
        ChatGptEditsParams params = new ChatGptEditsParams();
        params.setModel("code-davinci-edit-001");
        params.setInput("你打爷是你大爷");
        params.setInstruction("Fix the spelling mistakes");

        ChatGptEdits chatGptEdits = chatGptClient.createdEdits(params);
        logger.info(JSON.toJSONString(chatGptEdits));
    }

    @Test
    public void audioTranscriptionsTest() {
        AudioParams params = new AudioParams();
        params.setModel("whisper-1");
        params.setLanguage("zh");
        File file = new File("O:/hp/test.mp3");
        params.setFile(file);
        String text = chatGptClient.audioTranscriptions(params);
        logger.info(text);
    }
}
