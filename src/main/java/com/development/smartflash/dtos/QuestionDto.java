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
    private String answer_string;
//    private UserSetDto setDto;

    public QuestionDto(Question question){
        if (question.getId() != null){
            this.id = question.getId();
        }
        if (question.getQuestion_string() != null){
            this.question_string = question.getQuestion_string();
        }
        if (question.getAnswer_string() != null){
            this.answer_string = question.getAnswer_string();
        }
    }
}
