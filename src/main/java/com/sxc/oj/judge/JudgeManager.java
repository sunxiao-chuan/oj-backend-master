package com.sxc.oj.judge;

import com.sxc.oj.judge.strategy.DefaultJudgeStrategy;
import com.sxc.oj.judge.strategy.JavaLanguageJudgeStrategy;
import com.sxc.oj.judge.strategy.JudgeContext;
import com.sxc.oj.judge.strategy.JudgeStrategy;
import com.sxc.oj.judge.codesandbox.model.JudgeInfo;
import com.sxc.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext){
        QuestionSubmit questionSubmit=judgeContext.getQuestionSubmit();
        // 根据编程语言选择不同的判题策略
        String language=questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy=new DefaultJudgeStrategy();
        if(language.equals("java")){
            judgeStrategy=new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);

    }
}
