package com.sxc.oj.judge.codesandbox.impl;

import com.sxc.oj.judge.codesandbox.CodeSandbox;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.sxc.oj.judge.codesandbox.model.JudgeInfo;
import com.sxc.oj.model.enums.JudgeInfoEnum;
import com.sxc.oj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * 示例代码沙箱
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        String language = executeCodeRequest.getLanguage();
        String code = executeCodeRequest.getCode();

        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCESS.getValue());
        JudgeInfo judgeInfo =new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
