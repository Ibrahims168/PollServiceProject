package com.pollServiceProject.model;

import java.util.List;

public class PollAnswer {
    private Long id;
    private Long userId;
    private Long questionId;
    private String questionTitle;
    private String answer;
    PollAnswer(){};

    public PollAnswer(Long id, Long userId, Long questionId, String questionTitle, String answer) {
        this.id = id;
        this.userId = userId;
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public PollAnswerResponse toPollAnswerResponse(Long userId, List<PollAnswer> pollAnswerList){
        return new PollAnswerResponse(userId, pollAnswerList);
    }
}
