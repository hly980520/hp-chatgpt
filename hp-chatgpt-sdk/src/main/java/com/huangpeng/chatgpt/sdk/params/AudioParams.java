package com.huangpeng.chatgpt.sdk.params;

import java.io.File;

/**
 * @Program: hp-chatgpt
 * @Description: 音频请求参数
 * @author: peng.huang
 * @create: 2023-03-07 09:57:58
 **/
public class AudioParams extends BaseParams{
    private static final long serialVersionUID = -2585117433503186386L;

    private File file;

    private String language;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
