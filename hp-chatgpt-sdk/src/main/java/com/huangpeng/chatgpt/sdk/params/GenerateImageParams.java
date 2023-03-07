package com.huangpeng.chatgpt.sdk.params;

import java.io.Serializable;

/**
 * @Program: hp-chatgpt
 * @Description: 图片生成
 * @author: peng.huang
 * @create: 2023-03-06 18:11:42
 **/
public class GenerateImageParams implements Serializable {
    private static final long serialVersionUID = 2148370172854538410L;

    /**
     * A text description of the desired image(s). <br>
     * The maximum length is 1000 characters.
     */
    private String prompt;

    /**
     * The number of images to generate. Must be between 1 and 10.
     */
    private Integer n;

    /**
     * 图片尺寸<br>
     * The size of the generated images. Must be one of 256x256, 512x512, or 1024x1024.
     */
    private String size;

    /**
     * The format in which the generated images are returned. Must be one of url or b64_json.
     */
    private String response_format;

    /**
     * A unique identifier representing your end-user,
     * which can help OpenAI to monitor and detect abuse.
     * @see <a href="https://platform.openai.com/docs/guides/safety-best-practices/end-user-ids">...</a>
     */
    private String user;

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getResponse_format() {
        return response_format;
    }

    public void setResponse_format(String response_format) {
        this.response_format = response_format;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
