package com.pollServiceProject.repository;

import com.pollServiceProject.model.PollQuestion;
import com.pollServiceProject.repository.mapper.PollQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public  class PollQuestionRepositoryImpl implements PollQuestionRepository {
    private static final String QUESTION_TABLE_NAME = "poll_question_table";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createPollQuestion(PollQuestion pollQuestion) {
        String sql = "INSERT INTO " + QUESTION_TABLE_NAME + " (title, first_answer, second_answer, third_answer,fourth_answer) values (?,?,?,?,?)";
        jdbcTemplate.update(
                sql,
                pollQuestion.getTitle(),
                pollQuestion.getFirstAnswer(),
                pollQuestion.getSecondAnswer(),
                pollQuestion.getThirdAnswer(),
                pollQuestion.getFourthAnswer()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);

    }

    @Override
    public void updatePollQuestion(PollQuestion pollQuestion) {
        String sql = "UPDATE " + QUESTION_TABLE_NAME + " SET title=?, first_answer=?, second_answer=?, third_answer=?,fourth_answer=? WHERE question_id=?";
        jdbcTemplate.update(
                sql,
                pollQuestion.getTitle(),
                pollQuestion.getFirstAnswer(),
                pollQuestion.getSecondAnswer(),
                pollQuestion.getThirdAnswer(),
                pollQuestion.getFourthAnswer(),
                pollQuestion.getId()
        );
    }

    @Override
    public void deletePollQuestionById(Long id) {
        String sql = "DELETE " + QUESTION_TABLE_NAME + " WHERE question_id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public PollQuestion getPollQuestionById(Long id) {
        String sql = "SELECT * FROM " + QUESTION_TABLE_NAME + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PollQuestionMapper());
    }

    @Override
    public String getQuestionTitleById(Long id) {
        String sql = "SELECT title FROM " + QUESTION_TABLE_NAME + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }

    @Override
    public List<Long> getAllQuestionIds() {
        String sql = "SELECT question_id FROM " + QUESTION_TABLE_NAME;
        return jdbcTemplate.queryForList(sql, Long.class);
    }
}