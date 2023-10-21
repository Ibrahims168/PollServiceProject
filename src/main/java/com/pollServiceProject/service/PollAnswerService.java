package com.pollServiceProject.service;

import com.pollServiceProject.model.PollAnswer;
import com.pollServiceProject.model.PollAnswerRequest;
import com.pollServiceProject.model.PollAnswerResponse;

import java.util.List;
import java.util.Map;

public interface PollAnswerService {
    PollAnswerResponse createPollAnswer(PollAnswerRequest pollAnswerRequest);
    void deletePollAnswerById(Long id);
    PollAnswer getPollAnswerById(Long id);
    List<PollAnswer> getAllPollAnswersByUserId(Long userId);
    Long getAnswerCountByUserId(Long userId);
    void deleteAllUserAnswers(Long userId);
    Long countUniqueUsersByQuestionId(Long questionId);
    List<Map<String, Object>> getOptionCountByQuestionId(Long questionId);
    List<Map<String, Object>> getOptionCountsForAllQuestions();
}
