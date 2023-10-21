package com.pollServiceProject.repository;

import com.pollServiceProject.model.PollQuestion;

import java.util.List;

public interface PollQuestionRepository {
    Long createPollQuestion(PollQuestion pollQuestion);
    void updatePollQuestion(PollQuestion pollQuestion);
    void deletePollQuestionById(Long id);
    PollQuestion getPollQuestionById(Long id);
    String getQuestionTitleById(Long id);
    List<Long> getAllQuestionIds();
}
