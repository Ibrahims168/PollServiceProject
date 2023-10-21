package com.pollServiceProject.model;

public class PollAnswerRequest {
    private Long userId;
    private PollAnswer pollAnswer;
    PollAnswerRequest(){};

    public PollAnswerRequest(Long userId, PollAnswer pollAnswer) {
        this.userId = userId;
        this.pollAnswer = pollAnswer;
    }

    public Long getUserId() {
        return userId;
    }

    public PollAnswer getPollAnswer() {
        return pollAnswer;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPollAnswer(PollAnswer pollAnswer) {
        this.pollAnswer = pollAnswer;
    }
    public PollAnswer toPollCreate(){
        return new PollAnswer(
                this.pollAnswer.getId(),
                this.userId,
                this.pollAnswer.getQuestionId(),
                this.pollAnswer.getQuestionTitle(),
                this.pollAnswer.getAnswer()
        );
    }
}
