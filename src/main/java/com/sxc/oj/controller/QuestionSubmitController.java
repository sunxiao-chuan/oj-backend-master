package com.sxc.oj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sxc.oj.common.BaseResponse;
import com.sxc.oj.common.ErrorCode;
import com.sxc.oj.common.ResultUtils;
import com.sxc.oj.exception.BusinessException;
import com.sxc.oj.exception.ThrowUtils;
import com.sxc.oj.model.dto.question.QuestionQueryRequest;
import com.sxc.oj.model.dto.questionSubmit.QuestionSubmitAddRequest;
import com.sxc.oj.model.dto.questionSubmit.QuestionSubmitQueryRequest;
import com.sxc.oj.model.entity.Question;
import com.sxc.oj.model.entity.QuestionSubmit;
import com.sxc.oj.model.entity.User;
import com.sxc.oj.model.vo.QuestionSubmitVO;
import com.sxc.oj.model.vo.QuestionVO;
import com.sxc.oj.service.QuestionSubmitService;
import com.sxc.oj.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提交题目接口
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
@Deprecated
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     *
     * @param questionSubmitAddRequest
     * @param request
     */
    @PostMapping("/")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
                                         HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        final User loginUser = userService.getLoginUser(request);
        long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(questionSubmitId);
    }


    /**
     * 分页获取题目提交列表（封装类,除了管理员，普通用户只能看见非答案，提交代码等信息）
     *
     * @param
     * @param request
     * @return QuestionVO
     */
    @PostMapping("/list/page/vo")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
                                                                           HttpServletRequest request) {
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        User loginUser = userService.getLoginUser(request);
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }

}

