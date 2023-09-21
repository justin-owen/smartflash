package com.development.smartflash.entities;

import com.development.smartflash.dtos.QuestionDto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;


@Entity
@Table(name = "Questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(columnDefinition = "text")
    private String question_string;

    @Column(columnDefinition = "text")
    private String answer_string;

    @ManyToOne
    @JoinColumn(name = "set_id",
    referencedColumnName = "id")
    @JsonBackReference(value = "userSet_question")
    private UserSet set;

    public Question(QuestionDto questionDto){
        if (questionDto.getQuestion_string() != null){
            this.question_string = questionDto.getQuestion_string();
        }
    }
    public Question(String question_string, String answer_string, UserSet set){
        if (question_string != null){
            this.question_string = question_string;
        }
        if (answer_string != null){
            this.answer_string = answer_string;
        }
        if (set != null){
            this.set = set;
        }
    }
}
