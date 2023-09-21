package com.development.smartflash.entities;

import com.development.smartflash.dtos.UserSetDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "sets")
@Table(name = "Sets")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "set", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "userSet_question")
    private Set<Question> questionSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id",
    referencedColumnName = "id")
    @JsonBackReference(value = "user_userSet")
    private User user;

    public UserSet(UserSetDto setDto, User user){
        if (setDto.getName() != null){
            this.name = setDto.getName();
        }
        if (setDto.getSubject() != null){
            this.subject = setDto.getSubject();
        }
        if (user != null){
            this.user = user;
        }
    }
}
