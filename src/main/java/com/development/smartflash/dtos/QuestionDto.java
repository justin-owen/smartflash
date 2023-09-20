package com.development.smartflash.dtos;

import com.development.smartflash.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto implements Serializable {
    private Long id;
    private String question_string;
//    private UserSetDto setDto;
//    private AnswerDto answerDto;

    public QuestionDto(Question question){
        if (question.getId() != null){
            this.id = question.getId();
        }
        if (question.getQuestion_string() != null){
            this.question_string = question.getQuestion_string();
        }
    }
}
