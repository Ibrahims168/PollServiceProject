package com.pollServiceProject.repository;

import com.pollServiceProject.model.PollAnswer;

import java.util.List;
import java.util.Map;

public interface PollAnswerRepository {
    Long createPollAnswer(PollAnswer pollAnswer);
    void deletePollAnswerById(Long id);
    PollAnswer getPollAnswerById(Long id);
    List<PollAnswer> getAllPollAnswersByUserId(Long userId);
    Long getAnswerCountByUserId(Long userId);
    void deleteAllUserAnswers(Long userId);
    Long countUniqueUsersByQuestionId(Long questionId);
    List<Map<String, Object>> getOptionCountByQuestionId(Long questionId);
    List<Map<String, Object>> getOptionCountsForAllQuestions();

}
