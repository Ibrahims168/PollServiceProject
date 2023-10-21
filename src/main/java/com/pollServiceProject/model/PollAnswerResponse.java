package com.pollServiceProject.model;

import java.util.List;

public class PollAnswerResponse {
    private Long userId;
    private List<PollAnswer> pollAnswerList;
   PollAnswerResponse(){};

    public PollAnswerResponse(Long userId, List<PollAnswer> pollAnswerList) {
        this.userId = userId;
        this.pollAnswerList = pollAnswerList;
    }

    public Long getUserId() {
        return userId;
    }

    public List<PollAnswer> getPollAnswerList(Long userId) {
        return pollAnswerList;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPollAnswerList(List<PollAnswer> pollAnswerList) {
        this.pollAnswerList = pollAnswerList;
    }
}
