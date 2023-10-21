package com.pollServiceProject.service;

import com.pollServiceProject.model.PollQuestion;

import java.util.List;

public interface PollQuestionService {
    Long createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestionById(Long id);
    String getQuestionTitleById(Long id);
    List<Long> getAllQuestionIds();
}
