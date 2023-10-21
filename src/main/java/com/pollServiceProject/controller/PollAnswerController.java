package com.pollServiceProject.controller;

import com.pollServiceProject.model.PollAnswer;
import com.pollServiceProject.model.PollAnswerRequest;
import com.pollServiceProject.service.PollAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/poll-answer")
public class PollAnswerController {
    @Autowired
    private PollAnswerService pollAnswerService;

    @PostMapping("/create")
    public ResponseEntity<?> createPollAnswer(@RequestBody PollAnswerRequest pollAnswerRequest) {
        pollAnswerService.createPollAnswer(pollAnswerRequest);
        return ResponseEntity.ok("User answer CREATED successfully.");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePollAnswer(@PathVariable Long id){
        pollAnswerService.deletePollAnswerById(id);
        return ResponseEntity.ok("User Answer DELETED successfully.");
    }
    @GetMapping("/answer/{id}")
    public PollAnswer getAnswerById(@PathVariable Long id){
        return pollAnswerService.getPollAnswerById(id);
    }
    @GetMapping("/option-count/{questionId}")
    public ResponseEntity<List<Map<String, Object>>> getOptionCountByQuestionId(@PathVariable Long questionId) {
        List<Map<String, Object>> optionCountList = pollAnswerService.getOptionCountByQuestionId(questionId);
        return ResponseEntity.ok(optionCountList);
    }
    @GetMapping("/users-answered-count/{questionId}")
    public ResponseEntity<String> getUsersAnsweredCountForQuestion(@PathVariable Long questionId) {
        Long userCount = pollAnswerService.countUniqueUsersByQuestionId(questionId);
        String responseMessage = "Total users who answered question with ID " + questionId + " is : " + userCount;
        return ResponseEntity.ok(responseMessage);
    }
    @GetMapping("/user-answers/{userId}")
    public List<PollAnswer> getAllUserAnswersByUserId(@PathVariable Long userId) {
        return pollAnswerService.getAllPollAnswersByUserId(userId);
    }
    @GetMapping("/user-answer-count/{userId}")
    public ResponseEntity<String> getUserAnswerCount(@PathVariable Long userId) {
        long answerCount = pollAnswerService.getAnswerCountByUserId(userId);
        String responseMessage = "Total answers given by user with ID " + userId + " is : " + answerCount;
        return ResponseEntity.ok(responseMessage);
    }
    @DeleteMapping("/delete-user-answers/{userId}")
    public ResponseEntity<String> deleteUserAnswers(@PathVariable Long userId) {
        pollAnswerService.deleteAllUserAnswers(userId);
        String responseMessage = "All answers of user with ID " + userId + " have been deleted.";
        return ResponseEntity.ok(responseMessage);
    }
    @GetMapping("/option-counts-for-all-questions")
    public ResponseEntity<List<Map<String, Object>>> getOptionCountsForAllQuestions() {
        List<Map<String, Object>> optionCounts = pollAnswerService.getOptionCountsForAllQuestions();
        return ResponseEntity.ok(optionCounts);
    }
}

