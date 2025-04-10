package com.sxc.oj.model.dto.questionSubmit;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 提交题目
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {


    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 编程语言
     */
    private String language;

    /**
     * 编程代码
     */
    private String code;


    private static final long serialVersionUID = 1L;
}