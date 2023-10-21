package com.pollServiceProject.model;

public class PollQuestion {
    private Long id;
    private String title;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String fourthAnswer;

    public PollQuestion(){};

    public PollQuestion(Long id, String title, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer) {
        this.id = id;
        this.title = title;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.fourthAnswer = fourthAnswer;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public String getFourthAnswer() {
        return fourthAnswer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public void setFourthAnswer(String fourthAnswer) {
        this.fourthAnswer = fourthAnswer;
    }
}
