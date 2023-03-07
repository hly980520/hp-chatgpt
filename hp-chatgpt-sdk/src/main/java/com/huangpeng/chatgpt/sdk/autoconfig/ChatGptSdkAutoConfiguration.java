package com.huangpeng.chatgpt.sdk.autoconfig;

import com.huangpeng.chatgpt.sdk.client.ChatGptClient;
import com.huangpeng.chatgpt.sdk.properties.ChatGptProperties;
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
@EnableConfigurationProperties({ChatGptProperties.class})
public class ChatGptSdkAutoConfiguration {

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

    @Bean(name = "chatGptClient")
    public ChatGptClient chatGptClient() {
        return new ChatGptClient();
    }
}
