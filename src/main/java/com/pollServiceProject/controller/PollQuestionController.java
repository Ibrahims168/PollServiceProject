package com.pollServiceProject.controller;

import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.service.PollQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/poll-service")
public class PollQuestionController {
    @Autowired
    private PollQuestionService pollQuestionService;

    @PostMapping("/create")
    public ResponseEntity<?> createPollQuestion(@RequestBody PollQuestion pollQuestion){
        pollQuestionService.createPollQuestion(pollQuestion);
        return ResponseEntity.ok("Poll Question CREATED successfully.");
    }
    @PutMapping("/update")
    public  ResponseEntity<?> updatePollQuestion(@RequestBody PollQuestion pollQuestion){
        pollQuestionService.updatePollQuestion(pollQuestion);
        return ResponseEntity.ok("Poll Question UPDATED successfully.");

    }
    @DeleteMapping("/delete/{questionId}")
    public ResponseEntity<?> deletePollQuestion(@PathVariable Long questionId){
        pollQuestionService.deletePollQuestionById(questionId);
        return ResponseEntity.ok("Poll Question DELETED successfully.");
    }
    @GetMapping("/{questionId}")
    public PollQuestion getPollQuestionById(@PathVariable Long questionId) {
        return pollQuestionService.getPollQuestionById(questionId);
    }
    @GetMapping("/all-question-ids")
    public ResponseEntity<List<Long>> getAllQuestionIds() {
        List<Long> questionIds = pollQuestionService.getAllQuestionIds();
        return ResponseEntity.ok(questionIds);
    }
}
