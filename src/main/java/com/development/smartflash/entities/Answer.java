package com.development.smartflash.entities;

import com.development.smartflash.dtos.AnswerDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Answers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition = "text")
    private String answer_string;

    @OneToOne
    @JoinColumn(name = "question_id",
            referencedColumnName = "id")
    @JsonBackReference(value = "question_answer")
    private Question question;

    public Answer(AnswerDto answerDto){
        if (answerDto.getAnswer_string() != null){
            this.answer_string = answerDto.getAnswer_string();
        }
    }
}
