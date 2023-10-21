package com.pollServiceProject.service;

import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.repository.PollQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PollQuestionServiceImpl implements PollQuestionService {
    @Autowired
    private PollQuestionRepository pollQuestionRepository;

    @Override
    public Long createPollQuestion(PollQuestion pollQuestion) {
        return pollQuestionRepository.createPollQuestion(pollQuestion);
    }

    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {
        pollQuestionRepository.updatePollQuestion(pollQuestion);
    }

    @Override
    public void deletePollQuestionById(Long id) {
        pollQuestionRepository.deletePollQuestionById(id);
    }

    @Override
    public PollQuestion getPollQuestionById(Long id) {
        return pollQuestionRepository.getPollQuestionById(id);
    }

    @Override
    public String getQuestionTitleById(Long id) {
        return pollQuestionRepository.getQuestionTitleById(id);
    }

    @Override
    public List<Long> getAllQuestionIds() {
        return pollQuestionRepository.getAllQuestionIds();
    }

}