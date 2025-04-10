package com.sxc.oj.judge;

import com.sxc.oj.judge.codesandbox.model.ExecuteCodeResponse;
import com.sxc.oj.model.entity.QuestionSubmit;
import com.sxc.oj.model.vo.QuestionSubmitVO;

public interface JudgeService {

    /**
     * 判题服务
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(Long questionSubmitId);

}
