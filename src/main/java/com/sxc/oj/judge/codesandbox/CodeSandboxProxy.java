package com.sxc.oj.judge.codesandbox;

import com.sxc.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CodeSandboxProxy implements CodeSandbox{


    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱的请求信息："+executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱的响应信息："+executeCodeResponse.toString());
        return executeCodeResponse;
    }
}
