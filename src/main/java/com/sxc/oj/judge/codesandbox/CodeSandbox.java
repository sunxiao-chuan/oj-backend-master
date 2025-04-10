package com.sxc.oj.judge.codesandbox;

import com.sxc.oj.judge.codesandbox.model.ExecuteCodeRequest;
import com.sxc.oj.judge.codesandbox.model.ExecuteCodeResponse;
/**
 * 代码沙箱接口
 */
public interface CodeSandbox {

    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
