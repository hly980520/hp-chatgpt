package com.huangpeng.chatgpt.sdk.result;

import com.huangpeng.chatgpt.sdk.domain.GenerateImage;

import java.io.Serializable;
import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description: 图片生成返回结果
 * @author: peng.huang
 * @create: 2023-03-06 18:14:06
 **/
public class GenerateImagesResult implements Serializable {
    private static final long serialVersionUID = -7056708934593809466L;

    private String created;

    private List<GenerateImage> data;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<GenerateImage> getData() {
        return data;
    }

    public void setData(List<GenerateImage> data) {
        this.data = data;
    }
}
