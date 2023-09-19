package com.development.smartflash.dtos;

import com.development.smartflash.entities.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto implements Serializable {
    private Long id;
    private String answer_string;
//    private QuestionDto questionDto;

    public AnswerDto(Answer answer){
        if (answer.getId() != null){
            this.id = answer.getId();
        }
        if (answer.getAnswer_string() != null){
            this.answer_string = answer.getAnswer_string();
        }
    }
}
