package com.pollServiceProject.service;

import com.pollServiceProject.model.PollAnswer;
import com.pollServiceProject.model.PollAnswerRequest;
import com.pollServiceProject.model.PollAnswerResponse;
import com.pollServiceProject.repository.PollAnswerRepository;
import com.pollServiceProject.repository.PollQuestionRepository;
import com.pollServiceProject.userServiceFeignClient.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PollAnswerServiceImpl implements PollAnswerService{
    @Autowired
    private PollAnswerRepository pollAnswerRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PollQuestionService pollQuestionService;
    @Autowired
    private PollQuestionRepository pollQuestionRepository;
    @Override
    public PollAnswerResponse createPollAnswer(PollAnswerRequest pollAnswerRequest) {
        Long userId = pollAnswerRequest.getUserId();

        if (!userService.isUserRegistered(userId)) {
            throw new IllegalArgumentException("User is NOT registered");
        }

        Long questionId = pollAnswerRequest.getPollAnswer().getQuestionId();
        String questionTitle = pollQuestionRepository.getQuestionTitleById(questionId);
        String answer = pollAnswerRequest.getPollAnswer().getAnswer();
        pollAnswerRequest.setUserId(userId);

        PollAnswer pollAnswerToCreate = pollAnswerRequest.toPollCreate();
        pollAnswerToCreate.setUserId(userId);
        pollAnswerToCreate.setQuestionId(questionId);
        pollAnswerToCreate.setQuestionTitle(questionTitle);
        pollAnswerToCreate.setAnswer(answer);
        pollAnswerRepository.createPollAnswer(pollAnswerToCreate);

        List<PollAnswer> userAnswers = pollAnswerRepository.getAllPollAnswersByUserId(userId);
        return new PollAnswerResponse(userId, userAnswers);
    }


    @Override
    public void deletePollAnswerById(Long id) {
        pollAnswerRepository.deletePollAnswerById(id);
    }

    @Override
    public PollAnswer getPollAnswerById(Long id) {
        return pollAnswerRepository.getPollAnswerById(id);
    }

    @Override
    public List<PollAnswer> getAllPollAnswersByUserId(Long userId) {
        return pollAnswerRepository.getAllPollAnswersByUserId(userId);
    }

    @Override
    public Long getAnswerCountByUserId(Long userId) {
        return pollAnswerRepository.getAnswerCountByUserId(userId);
    }

    @Override
    public void deleteAllUserAnswers(Long userId) {
        pollAnswerRepository.deleteAllUserAnswers(userId);
    }

    @Override
    public Long countUniqueUsersByQuestionId(Long questionId) {
        return pollAnswerRepository.countUniqueUsersByQuestionId(questionId);
    }

    @Override
    public List<Map<String, Object>> getOptionCountByQuestionId(Long questionId) {
        List<Map<String, Object>> optionCountList = pollAnswerRepository.getOptionCountByQuestionId(questionId);
        List<Map<String, Object>> optionList = new ArrayList<>();

        for (Map<String, Object> optionCount : optionCountList) {
            String option = (String) optionCount.get("option");
            Long count = (Long) optionCount.get("count");

            Map<String, Object> optionCountObject = new HashMap<>();
            optionCountObject.put("count", count);
            optionCountObject.put("option", option);

            optionList.add(optionCountObject);
        }

        Map<String, Object> questionObject = new HashMap<>();
        questionObject.put("questionId", questionId);
        questionObject.put("options", optionList);

        List<Map<String, Object>> result = new ArrayList<>();
        result.add(questionObject);

        return result;
    }

    @Override
    public List<Map<String, Object>> getOptionCountsForAllQuestions() {
        List<Map<String, Object>> optionCountsForAllQuestions = new ArrayList<>();
        List<Long> questionIds = pollQuestionService.getAllQuestionIds();

        for (Long questionId : questionIds) {
            Map<String, Object> questionObject = new HashMap<>();
            questionObject.put("questionId", questionId);

            List<Map<String, Object>> optionCounts = pollAnswerRepository.getOptionCountByQuestionId(questionId);
            List<Map<String, Object>> optionList = new ArrayList<>();

            for (Map<String, Object> optionCount : optionCounts) {
                String option = (String) optionCount.get("option");
                Long count = (Long) optionCount.get("count");

                Map<String, Object> optionCountObject = new HashMap<>();
                optionCountObject.put("count", count);
                optionCountObject.put("option", option);
                optionList.add(optionCountObject);
            }
            questionObject.put("options", optionList);
            optionCountsForAllQuestions.add(questionObject);
        }
        return optionCountsForAllQuestions;
    }
}
