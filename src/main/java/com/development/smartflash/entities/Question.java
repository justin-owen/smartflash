package com.development.smartflash.entities;

import com.development.smartflash.dtos.QuestionDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "question_answer")
    private Answer answer;

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
}
