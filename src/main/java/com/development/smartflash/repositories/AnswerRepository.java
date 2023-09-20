package com.development.smartflash.repositories;

import com.development.smartflash.entities.Answer;
import com.development.smartflash.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByQuestionId(Question question);
}
