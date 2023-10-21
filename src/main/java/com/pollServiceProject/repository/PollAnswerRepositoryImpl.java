package com.pollServiceProject.repository;

import com.pollServiceProject.model.PollAnswer;
import com.pollServiceProject.repository.mapper.PollAnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PollAnswerRepositoryImpl implements PollAnswerRepository{
    private static final String POLL_ANSWER_TABLE = "poll_answer_table";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long createPollAnswer(PollAnswer pollAnswer) {
        String sql = "INSERT INTO " + POLL_ANSWER_TABLE + " (user_id, question_id, question_title, user_answer) values (?,?,?,?)";
        jdbcTemplate.update(
                sql,
                pollAnswer.getUserId(),
                pollAnswer.getQuestionId(),
                pollAnswer.getQuestionTitle(),
                pollAnswer.getAnswer()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }

    @Override
    public void deletePollAnswerById(Long id) {
        String sql = "DELETE FROM " + POLL_ANSWER_TABLE + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }


    @Override
    public PollAnswer getPollAnswerById(Long id) {
        String sql = "SELECT * FROM " + POLL_ANSWER_TABLE + " WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new PollAnswerMapper());
    }

    @Override
    public List<PollAnswer> getAllPollAnswersByUserId(Long userId) {
        String sql = "SELECT * FROM " + POLL_ANSWER_TABLE + " WHERE user_Id=?";
        return jdbcTemplate.query(sql, new Object[]{userId},new PollAnswerMapper());
    }

    @Override
    public Long getAnswerCountByUserId(Long userId) {
        String sql = "SELECT COUNT(*) FROM " + POLL_ANSWER_TABLE + " WHERE user_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, Long.class);
    }

    @Override
    public void deleteAllUserAnswers(Long userId) {
        String sql = "DELETE FROM " + POLL_ANSWER_TABLE + " WHERE user_id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public Long countUniqueUsersByQuestionId(Long questionId) {
        String sql = "SELECT COUNT(DISTINCT user_id) FROM " + POLL_ANSWER_TABLE + " WHERE question_id=?";
        return jdbcTemplate.queryForObject(sql, Long.class, questionId);    }

    @Override
    public List<Map<String, Object>> getOptionCountByQuestionId(Long questionId) {
        String sql = "SELECT user_answer, COUNT(*) as count FROM poll_answer_table WHERE question_id=? GROUP BY user_answer";
        return jdbcTemplate.query(sql, new Object[]{questionId}, (rs, rowNum) -> {
            Map<String, Object> result = new HashMap<>();
            result.put("option", rs.getString("user_answer"));
            result.put("count", rs.getLong("count"));
            return result;
        });
    }

    @Override
    public List<Map<String, Object>> getOptionCountsForAllQuestions() {
        String sql = "SELECT question_id, user_answer, COUNT(*) as count FROM poll_answer_table GROUP BY question_id, user_answer";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Long questionId = rs.getLong("question_id");
            String option = rs.getString("user_answer");
            Long count = rs.getLong("count");

            Map<String, Object> result = new HashMap<>();
            result.put("questionId", questionId);
            result.put("option", option);
            result.put("count", count);

            return result;
        });
    }
}
