package com.sxc.oj.judge.strategy;

import com.sxc.oj.judge.codesandbox.model.JudgeInfo;

public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);

}
