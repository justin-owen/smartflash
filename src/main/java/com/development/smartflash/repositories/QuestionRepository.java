package com.development.smartflash.repositories;

import com.development.smartflash.entities.Question;
import com.development.smartflash.entities.User;
import com.development.smartflash.entities.UserSet;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllBySet(UserSet userSet);
}
