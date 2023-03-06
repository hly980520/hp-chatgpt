package com.huangpeng.chatgpt.sdk.autoconfig;

import com.huangpeng.chatgpt.sdk.client.v1.ChatGptV1Client;
import com.huangpeng.chatgpt.sdk.properties.v1.ChatGptV1Properties;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @author peng.huang
 */
@EnableConfigurationProperties({ChatGptV1Properties.class})
public class ChatGptSdkV1AutoConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public OkHttpClient chatGptHttpClient() {
        return new OkHttpClient().newBuilder().
                connectionPool(new ConnectionPool(30, 10, TimeUnit.SECONDS))
                .readTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .writeTimeout(Duration.of(10, ChronoUnit.SECONDS))
                .connectTimeout(Duration.of(20, ChronoUnit.SECONDS))
                .build();
    }

    @Bean(name = "chatGptV1Client")
    public ChatGptV1Client chatGptV1Client() {
        return new ChatGptV1Client();
    }
}
