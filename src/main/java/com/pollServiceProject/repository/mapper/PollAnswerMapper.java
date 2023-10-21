package com.pollServiceProject.repository.mapper;

import com.pollServiceProject.model.PollAnswer;
import org.apache.tomcat.jni.Poll;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class PollAnswerMapper implements RowMapper<PollAnswer> {
    @Override
    public PollAnswer mapRow(ResultSet rs, int rowNum) throws SQLException {
        PollAnswer pollAnswer = new PollAnswer(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getLong("question_id"),
                rs.getString("question_title"),
                rs.getString("user_answer")
        );
        return pollAnswer;
    }
}
