CREATE TABLE poll_question_table (
    question_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(300) NOT NULL DEFAULT '',
    first_answer VARCHAR(300) NOT NULL DEFAULT '',
    second_answer VARCHAR(300) NOT NULL DEFAULT '',
    third_answer VARCHAR(300) NOT NULL DEFAULT '',
    fourth_answer VARCHAR(300) NOT NULL DEFAULT '',
    PRIMARY KEY (question_id)
);

CREATE TABLE poll_answer_table (
       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
       user_id INT NOT NULL,
       question_id INT NOT NULL,
       question_title VARCHAR(300) NOT NULL DEFAULT '',
       user_answer VARCHAR(300) NOT NULL DEFAULT '',
       PRIMARY KEY (id),
       FOREIGN KEY (question_id) REFERENCES poll_question_table(question_id)
);
