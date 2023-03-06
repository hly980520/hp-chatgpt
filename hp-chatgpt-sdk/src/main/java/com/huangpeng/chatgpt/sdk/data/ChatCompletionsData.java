package com.huangpeng.chatgpt.sdk.data;

import com.huangpeng.chatgpt.sdk.domain.CompletionsMessage;

import java.util.List;

/**
 * @Program: hp-chatgpt
 * @Description:
 * @author: peng.huang
 * @create: 2023-03-06 17:40:12
 **/
public class ChatCompletionsData extends BaseCompletionsData{
    private static final long serialVersionUID = -6802385716682036093L;

    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    static class Choice {

        private Integer index;

        private CompletionsMessage message;

        private String finish_reason;


        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public CompletionsMessage getMessage() {
            return message;
        }

        public void setMessage(CompletionsMessage message) {
            this.message = message;
        }

        public String getFinish_reason() {
            return finish_reason;
        }

        public void setFinish_reason(String finish_reason) {
            this.finish_reason = finish_reason;
        }
    }
}
