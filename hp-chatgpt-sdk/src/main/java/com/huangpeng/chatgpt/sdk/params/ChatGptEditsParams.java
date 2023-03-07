package com.huangpeng.chatgpt.sdk.params;

/**
 * @Program: hp-chatgpt
 * @Description: 目前支持：text-davinci-edit-001/code-davinci-edit-001
 * @author: peng.huang
 * @create: 2023-03-06 21:03:05
 **/
public class ChatGptEditsParams extends BaseParams{
    private static final long serialVersionUID = -4660883764607345322L;

    /**
     * 输入值<br>
     * example: 你打爷还是你大爷
     */
    private String input;

    /**
     * 告诉模型如何编辑提示的指令<br>
     * example: Fix the spelling mistakes
     */
    private String instruction;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
