package com.sxc.oj.judge.strategy;

import com.sxc.oj.model.dto.question.JudgeCase;
import com.sxc.oj.judge.codesandbox.model.JudgeInfo;
import com.sxc.oj.model.entity.Question;
import com.sxc.oj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;


@Data
public class JudgeContext {


    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private JudgeInfo judgeInfo;

    private Question question;

    private QuestionSubmit questionSubmit;

}
