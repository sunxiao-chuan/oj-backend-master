package com.sxc.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxc.oj.common.BaseResponse;
import com.sxc.oj.model.dto.question.QuestionQueryRequest;
import com.sxc.oj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.sxc.oj.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.sxc.oj.model.entity.Question;
import com.sxc.oj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sxc.oj.model.entity.User;
import com.sxc.oj.model.vo.QuestionSubmitVO;
import com.sxc.oj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author sxc
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2025-03-22 10:20:23
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    Long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);


    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit,  User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
